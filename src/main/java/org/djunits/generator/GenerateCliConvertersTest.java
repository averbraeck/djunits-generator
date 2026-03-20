package org.djunits.generator;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.djunits.unit.UnitInterface;
import org.djunits.unit.Units;

/**
 * Generator for {@code org.djutils.cli.TestCliUnitConverters}.
 * <p>
 * This tool force-loads all quantity classes under {@code org.djunits.quantity} to trigger lazy registration in {@link Units},
 * then emits a JUnit test that: (1) declares one {@code @Option} field per quantity with a sensible default value string, and
 * (2) verifies default parsing and an override parsing against {@code T.valueOf(String)} by comparing SI values with a small
 * tolerance.
 * </p>
 * <p>
 * The generated source includes Checkstyle-compliant Javadoc for all classes, fields, and methods.
 * </p>
 * Copyright (c) 2014-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djutils.org" target="_blank"> https://djutils.org</a>. The DJUTILS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djutils.org/docs/license.html" target="_blank"> https://djutils.org/docs/license.html</a>. <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public final class GenerateCliConvertersTest
{
    /** Package that contains the quantity classes to discover. */
    private static final String QUANTITY_PACKAGE = "org.djunits.quantity";

    /** Resource path of the quantity package (slash-separated). */
    private static final String QUANTITY_PATH = QUANTITY_PACKAGE.replace('.', '/');

    /** Tolerance used in generated tests for SI value comparisons. */
    private static final double EPS = 1e-12;

    /** Prevent instantiation of utility class. */
    private GenerateCliConvertersTest()
    {
        // utility class
    }

    /**
     * Main entry point. Discovers quantities, builds test records, and emits a full JUnit test class to STDOUT.
     * @param args the command line arguments (unused).
     * @throws IOException if an I/O error occurs while scanning the classpath.
     * @throws URISyntaxException if a URL cannot be converted to a URI while scanning the classpath.
     */
    public static void main(final String[] args) throws IOException, URISyntaxException
    {
        // 1) Ensure the Units registry is complete: class initialization registers units lazily.
        int loaded = forceLoadAllQuantities();
        if (loaded == 0)
        {
            System.err.println("WARNING: No quantity classes loaded from " + QUANTITY_PACKAGE);
        }

        // 2) Build quantity -> abbreviations map from Units registry.
        Map<String, TreeSet<String>> quantityToAbbrs = registryByQuantity();

        // 3) Build a stable list of quantities and create test records with default/override values.
        List<String> quantities = new ArrayList<>(quantityToAbbrs.keySet());
        Collections.sort(quantities, String.CASE_INSENSITIVE_ORDER.thenComparing(String::compareTo));

        List<Record> records = new ArrayList<>();
        for (String q : quantities)
        {
            TreeSet<String> abbrs = quantityToAbbrs.get(q);
            String base = chooseDefaultAbbr(abbrs); // may be ""
            String alt = chooseAlternateAbbr(abbrs, base);

            String defaultValue = base.isEmpty() ? "2.0" : "2.0" + base;
            String overrideValue = alt.isEmpty() ? "1.0" : "1.0" + alt;

            records.add(new Record(q, defaultValue, overrideValue));
        }

        // 4) Emit the JUnit test source with full Javadoc.
        emitTest(records);
    }

    /**
     * Force-load all top-level classes in the quantity package to trigger static registration of units.
     * @return the number of successfully loaded classes.
     * @throws UncheckedIOException if an error occurs during classpath scanning.
     */
    private static int forceLoadAllQuantities()
    {
        int count = 0;
        try
        {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null)
            {
                cl = GenerateCliConvertersTest.class.getClassLoader();
            }

            Enumeration<URL> urls = cl.getResources(QUANTITY_PATH);
            while (urls.hasMoreElements())
            {
                URL url = urls.nextElement();
                String protocol = url.getProtocol();

                if ("file".equals(protocol))
                {
                    var dir = new java.io.File(url.toURI());
                    var files = dir.listFiles((
                            d, n
                    ) -> n.endsWith(".class") && isTopLevelClass(n));
                    if (files != null)
                    {
                        for (var f : files)
                        {
                            String simple = f.getName().substring(0, f.getName().length() - ".class".length());
                            count += tryLoad(QUANTITY_PACKAGE + "." + simple, cl);
                        }
                    }
                }
                else if ("jar".equals(protocol))
                {
                    JarURLConnection conn = (JarURLConnection) url.openConnection();
                    try (JarFile jar = conn.getJarFile())
                    {
                        String prefix = QUANTITY_PATH + "/";
                        Enumeration<JarEntry> entries = jar.entries();
                        while (entries.hasMoreElements())
                        {
                            JarEntry je = entries.nextElement();
                            String name = je.getName();
                            if (!name.startsWith(prefix) || !name.endsWith(".class"))
                            {
                                continue;
                            }
                            String rest = name.substring(prefix.length());
                            if (rest.contains("/"))
                            {
                                continue; // no subpackages
                            }
                            if (!isTopLevelClass(rest))
                            {
                                continue;
                            }

                            String simple = rest.substring(0, rest.length() - ".class".length());
                            count += tryLoad(QUANTITY_PACKAGE + "." + simple, cl);
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            throw new UncheckedIOException(new IOException("Error scanning " + QUANTITY_PACKAGE, e));
        }
        return count;
    }

    /**
     * Check whether the given class file name refers to a top-level class (not an inner class / metadata).
     * @param classFileName the class file name to check.
     * @return {@code true} if the class file name represents a top-level Java class; {@code false} otherwise.
     */
    private static boolean isTopLevelClass(final String classFileName)
    {
        return !classFileName.contains("$") && !"package-info.class".equals(classFileName)
                && !"module-info.class".equals(classFileName);
    }

    /**
     * Attempt to load and initialize the class with the provided name using the supplied class loader.
     * @param fqcn the fully qualified class name to load.
     * @param cl the class loader to use.
     * @return {@code 1} if class loading and initialization succeeded; {@code 0} otherwise.
     */
    private static int tryLoad(final String fqcn, final ClassLoader cl)
    {
        try
        {
            Class.forName(fqcn, true, cl); // initialize => triggers static unit registration in Units (lazy).
            return 1;
        }
        catch (Throwable t)
        {
            System.err.println("WARN: could not load " + fqcn + ": " + t.getClass().getSimpleName() + " - " + t.getMessage());
            return 0;
        }
    }

    /**
     * Build a map from simple quantity name to its registered textual unit abbreviations using {@link Units#registeredUnits()}.
     * <p>
     * Note that the DJUNITS registry is populated lazily during class initialization; ensure classes are loaded beforehand.
     * </p>
     * @return a map from quantity simple name to a sorted set of unique textual abbreviations (case-distinct ordering).
     */
    private static Map<String, TreeSet<String>> registryByQuantity()
    {
        Map<String, TreeSet<String>> out = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        // Comparator: sort case-insensitively but keep case for uniqueness (mm vs Mm).
        Comparator<String> orderButCaseDistinct = (
                a, b
        ) ->
        {
            int ci = String.CASE_INSENSITIVE_ORDER.compare(a, b);
            return (ci != 0) ? ci : a.compareTo(b);
        };

        // authoritative, lazy registry.
        Map<String, Map<String, UnitInterface<?, ?>>> all = Units.registeredUnits();

        for (var e : all.entrySet())
        {
            String key = e.getKey(); // e.g., "Length$Unit" or "Length.Unit"
            String quantity = baseQuantityName(key);
            var set = out.computeIfAbsent(quantity, k -> new TreeSet<>(orderButCaseDistinct));
            set.addAll(e.getValue().keySet());
        }
        return out;
    }

    /**
     * Obtain the simple quantity name (e.g., {@code "Length"}) from a Units registry key like {@code "Length$Unit"} or
     * {@code "Length.Unit"}.
     * @param registryKey the key from the Units registry.
     * @return the base quantity name without the nested class suffix.
     */
    private static String baseQuantityName(final String registryKey)
    {
        int i = registryKey.indexOf('$');
        if (i >= 0)
        {
            return registryKey.substring(0, i);
        }
        int j = registryKey.indexOf('.');
        return (j >= 0) ? registryKey.substring(0, j) : registryKey;
    }

    /**
     * Choose a default unit abbreviation for a quantity. Prefers the first non-empty abbreviation; falls back to the empty
     * string if needed (e.g., dimensionless).
     * @param abbrs the set of available abbreviations for the quantity.
     * @return the chosen default abbreviation, possibly {@code ""}.
     */
    private static String chooseDefaultAbbr(final TreeSet<String> abbrs)
    {
        for (String s : abbrs)
        {
            if (s != null && !s.isEmpty())
            {
                return s;
            }
        }
        return "";
    }

    /**
     * Choose an alternate unit abbreviation distinct from the default. Prefers a non-empty abbreviation; may fall back to empty
     * if appropriate; otherwise returns the base abbreviation.
     * @param abbrs the set of available abbreviations for the quantity.
     * @param base the base abbreviation already chosen.
     * @return a distinct alternate abbreviation if available; otherwise the base abbreviation.
     */
    private static String chooseAlternateAbbr(final TreeSet<String> abbrs, final String base)
    {
        for (String s : abbrs)
        {
            if (s == null || s.isEmpty())
            {
                continue;
            }
            if (!s.equals(base))
            {
                return s;
            }
        }
        if (!base.isEmpty() && abbrs.contains(""))
        {
            return "";
        }
        return base;
    }

    /**
     * Emit the complete source of {@code org.djutils.cli.TestCliUnitConverters} to STDOUT with full Javadoc and SI-based
     * assertions.
     * @param records the list of test records per quantity with default and override values.
     */
    private static void emitTest(final List<Record> records)
    {
        String genTime = Instant.now().toString();

        System.out.println("package org.djutils.cli;");
        System.out.println();
        System.out.println("import static org.junit.jupiter.api.Assertions.assertEquals;");
        System.out.println("import java.util.Locale;");

        // Import quantities used as types and for expected parsing.
        LinkedHashSet<String> imports = new LinkedHashSet<>();
        for (Record r : records)
        {
            imports.add("import " + QUANTITY_PACKAGE + "." + r.type + ";");
        }
        imports.stream().sorted().forEach(System.out::println);

        System.out.println("import org.junit.jupiter.api.Test;");
        System.out.println("import picocli.CommandLine.Command;");
        System.out.println("import picocli.CommandLine.Option;");
        System.out.println();
        System.out.println("/**");
        System.out.println(" * JUnit test for the generated DJUNITS CLI converters.");
        System.out.println(" * <p>");
        System.out.println(" * This test is generated at " + genTime + " by " + GenerateCliConvertersTest.class.getName()
                + " and validates that");
        System.out.println(
                " * each {@code @Option} field parses its default and an explicit override by comparing SI values with a small tolerance.");
        System.out.println(" * </p>");
        System.out.println(" */");
        System.out.println("@SuppressWarnings(\"checkstyle:visibilitymodifier\")");
        System.out.println("public class TestCliUnitConverters");
        System.out.println("{");
        System.out.println("  /** Numerical tolerance used for SI value comparisons. */");
        System.out.println("  private static final double EPS = " + EPS + ";");
        System.out.println();
        System.out.println("  /**");
        System.out.println("   * Picocli options holder for all quantities under test.");
        System.out.println("   */");
        System.out.println(
                "  @Command(description = \"Test program for CLI\", name = \"Program\", mixinStandardHelpOptions = true, version = \"1.0\")");
        System.out.println("  public static class Options");
        System.out.println("  {");

        // Emit @Option fields with Javadoc.
        for (Record r : records)
        {
            String optionName = r.type.toLowerCase(Locale.ROOT);
            System.out.println("    /** Option for " + r.type + " with a default value string. */");
            System.out.println("    @Option(names = {\"--" + optionName + "\"}, description = \"" + r.type
                    + "\", defaultValue = \"" + escapeJava(r.defaultValue) + "\")");
            System.out.println("    protected " + r.type + " " + optionName + ";");
        }

        System.out.println("  }");
        System.out.println();
        System.out.println("  /**");
        System.out.println("   * Tests CLI parsing for all quantities: default values and explicit overrides.");
        System.out.println("   *");
        System.out.println("   * @throws Exception if CLI execution or parsing fails for any quantity.");
        System.out.println("   */");
        System.out.println("  @Test");
        System.out.println("  public void testCli() throws Exception");
        System.out.println("  {");
        System.out.println("    Locale.setDefault(Locale.US);");
        System.out.println("    String[] args;");
        System.out.println("    Options options;");

        for (Record r : records)
        {
            String lname = r.type.toLowerCase(Locale.ROOT);

            // Default case
            System.out.println("    // " + r.type + " default");
            System.out.println("    args = new String[] {};");
            System.out.println("    options = new Options();");
            System.out.println("    CliUtil.execute(options, args);");
            System.out.println("    assertEquals(" + r.type + ".valueOf(\"" + escapeJava(r.defaultValue) + "\").si(), options."
                    + lname + ".si(), EPS);");

            // Override case
            System.out.println("    // " + r.type + " override");
            System.out.println("    args = new String[] {\"--" + lname + "\", \"" + escapeJava(r.overrideValue) + "\"};");
            System.out.println("    CliUtil.execute(options, args);");
            System.out.println("    assertEquals(" + r.type + ".valueOf(\"" + escapeJava(r.overrideValue) + "\").si(), options."
                    + lname + ".si(), EPS);");
            System.out.println();
        }

        System.out.println("  }");
        System.out.println("}");
    }

    /**
     * Escape a Java string literal minimally (quotes and backslashes).
     * @param s the input string to escape.
     * @return the escaped string suitable for inclusion in a Java string literal.
     */
    private static String escapeJava(final String s)
    {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    /**
     * Immutable record describing the default and override value strings used to test a quantity.
     */
    private static final class Record
    {
        /** Simple quantity name (e.g., {@code Length}). */
        final String type;

        /** Default value string (e.g., {@code "2.0m"}). */
        final String defaultValue;

        /** Override value string (e.g., {@code "1.0km"}). */
        final String overrideValue;

        /**
         * Constructs a record with default and override values for one quantity.
         * @param type the simple quantity name.
         * @param defaultValue the default value string, including unit if any.
         * @param overrideValue the override value string, including unit if any.
         */
        Record(final String type, final String defaultValue, final String overrideValue)
        {
            this.type = type;
            this.defaultValue = defaultValue;
            this.overrideValue = overrideValue;
        }
    }
}
