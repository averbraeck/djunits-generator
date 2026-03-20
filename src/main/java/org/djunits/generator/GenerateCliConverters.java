package org.djunits.generator;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Generator for {@code org.djutils.cli.CliUnitConverters}.
 * <p>
 * This tool discovers all top-level classes in {@code org.djunits.quantity}, force-loads them so that their static initializers
 * register all units lazily in {@link org.djunits.unit.Units}, and emits a CLI converter class that registers a Picocli
 * {@code ITypeConverter} for each quantity. The generated converters delegate to {@code T.valueOf(String)} for robust parsing
 * (consistent with the quantity API).
 * </p>
 * <p>
 * The generated source includes Checkstyle-compliant Javadoc for all classes, fields, and methods.
 * </p>
 * Copyright (c) 2014-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djutils.org" target="_blank"> https://djutils.org</a>. The DJUTILS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djutils.org/docs/license.html" target="_blank"> https://djutils.org/docs/license.html</a>.
 * <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public final class GenerateCliConverters
{
    /** Package that contains the quantity classes to discover. */
    private static final String QUANTITY_PACKAGE = "org.djunits.quantity";

    /** Resource path of the quantity package (slash-separated). */
    private static final String QUANTITY_PATH = QUANTITY_PACKAGE.replace('.', '/');

    /** Prevent instantiation of utility class. */
    private GenerateCliConverters()
    {
        // utility class
    }

    /**
     * Main entry point. Discovers quantities and prints the generated {@code CliUnitConverters} source to STDOUT.
     * @param args the command line arguments (unused).
     * @throws IOException if an I/O error occurs while scanning the classpath.
     * @throws URISyntaxException if a URL cannot be converted to a URI while scanning the classpath.
     */
    public static void main(final String[] args) throws IOException, URISyntaxException
    {
        // Discover quantity simple class names (e.g., "Length", "Pressure").
        List<String> quantities = discoverQuantities();

        // Emit a full Java source file for org.djutils.cli.CliUnitConverters with Javadoc.
        emitCliUnitConverters(quantities);
    }

    /**
     * Discover simple class names of all top-level quantity classes (no subpackages). This method handles both exploded
     * directories (e.g., target/classes) and JARs on the classpath.
     * @return an alphabetically sorted list of simple quantity names.
     * @throws UncheckedIOException if an error occurs while scanning the classpath.
     */
    private static List<String> discoverQuantities()
    {
        try
        {
            Set<String> names = new LinkedHashSet<>();
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null)
            {
                cl = GenerateCliConverters.class.getClassLoader();
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
                            if (!shouldSkip(simple))
                            {
                                names.add(simple);
                            }
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
                            if (!shouldSkip(simple))
                            {
                                names.add(simple);
                            }
                        }
                    }
                }
            }

            List<String> list = new ArrayList<>(names);
            Collections.sort(list, String.CASE_INSENSITIVE_ORDER.thenComparing(String::compareTo));
            return list;
        }
        catch (Exception e)
        {
            throw new UncheckedIOException(new IOException("Error discovering quantities under " + QUANTITY_PACKAGE, e));
        }
    }

    /**
     * Determine whether a class file name represents a top-level Java class (not an inner class or metadata).
     * @param classFileName the class file name to evaluate.
     * @return {@code true} if the file name refers to a top-level Java class; {@code false} otherwise.
     */
    private static boolean isTopLevelClass(final String classFileName)
    {
        return !classFileName.contains("$") && !"package-info.class".equals(classFileName)
                && !"module-info.class".equals(classFileName);
    }

    /**
     * Predicate to skip certain class names from the quantity package if needed.
     * @param simpleName the simple class name to evaluate.
     * @return {@code true} if the class should be skipped; {@code false} otherwise.
     */
    private static boolean shouldSkip(final String simpleName)
    {
        // Keep everything by default.
        return false;
    }

    /**
     * Emit the complete source of {@code org.djutils.cli.CliUnitConverters} to STDOUT. The generated source contains
     * Checkstyle-compliant Javadoc for all members.
     * @param quantities the list of discovered quantity simple names to include.
     */
    private static void emitCliUnitConverters(final List<String> quantities)
    {
        String genTime = Instant.now().toString();

        // Package and imports.
        System.out.println("package org.djutils.cli;");
        System.out.println();
        for (String q : quantities)
        {
            System.out.println("import " + QUANTITY_PACKAGE + "." + q + ";");
        }
        System.out.println("import jakarta.annotation.Generated;");
        System.out.println("import picocli.CommandLine;");
        System.out.println("import picocli.CommandLine.ITypeConverter;");
        System.out.println();

        // Class Javadoc and declaration.
        System.out.println("/**");
        System.out.println(" * Command-line converters for all DJUNITS quantities.");
        System.out.println(" * <p>");
        System.out.println(" * This class is generated by " + GenerateCliConverters.class.getName()
                + " and registers a Picocli converter for each");
        System.out.println(" * discovered quantity in {@code " + QUANTITY_PACKAGE + "}. Each converter delegates parsing to");
        System.out.println(" * {@code T.valueOf(String)} for correctness and consistency with the quantity API.");
        System.out.println(" * </p>");
        System.out.println(" */");
        System.out.println("public final class CliUnitConverters");
        System.out.println("{");

        // Private constructor Javadoc.
        System.out.println("  /**");
        System.out.println("   * Constructs a {@code CliUnitConverters} utility class.");
        System.out.println("   */");
        System.out.println("  private CliUnitConverters() { /* utility class */ }");
        System.out.println();

        // registerAll Javadoc and body.
        System.out.println("  /**");
        System.out.println("   * Registers all DJUNITS converters on a Picocli {@link CommandLine} instance.");
        System.out.println("   *");
        System.out.println("   * @param cmd the {@link CommandLine} on which to register all quantity converters.");
        System.out.println("   */");
        System.out
                .println("  @Generated(value = \"" + GenerateCliConverters.class.getName() + "\", date = \"" + genTime + "\")");
        System.out.println("  public static void registerAll(final CommandLine cmd)");
        System.out.println("  {");
        for (String q : quantities)
        {
            System.out.println("    cmd.registerConverter(" + q + ".class, new " + q.toUpperCase() + "());");
        }
        System.out.println("  }");
        System.out.println();

        // One nested converter per quantity with Javadoc and convert() Javadoc.
        for (String q : quantities)
        {
            String title = toSpacedTitle(q);
            String aAnTitle = startsWithVowel(title) ? "an" : "a";
            String aAnType = startsWithVowel(q) ? "an" : "a";

            System.out.println("  /**");
            System.out.println("   * Converter for " + q + " values supplied on the command line.");
            System.out.println("   * <p>");
            System.out.println("   * Converts " + aAnTitle + " " + title.toLowerCase() + " string with unit to " + aAnType
                    + " {@link " + q + "} quantity.");
            System.out.println("   * </p>");
            System.out.println("   */");
            System.out.println("  public static class " + q.toUpperCase() + " implements ITypeConverter<" + q + ">");
            System.out.println("  {");
            System.out.println("    /**");
            System.out.println("     * Parses a textual value-with-unit into a {@link " + q + "} instance.");
            System.out.println("     *");
            System.out.println(
                    "     * @param value the textual representation of the value and unit to parse; e.g., {@code \"1.5 km\"}.");
            System.out.println("     * @return the parsed {@link " + q + "} instance.");
            System.out.println("     * @throws Exception if the value cannot be parsed or the unit is not recognized.");
            System.out.println("     */");
            System.out.println("    @Override");
            System.out.println(
                    "    @Generated(value = \"" + GenerateCliConverters.class.getName() + "\", date = \"" + genTime + "\")");
            System.out.println("    public " + q + " convert(final String value) throws Exception");
            System.out.println("    {");
            System.out.println("      CliUtil.prepareLocale();");
            System.out.println("      var result = " + q + ".valueOf(value);");
            System.out.println("      CliUtil.restoreLocale();");
            System.out.println("      return result;");
            System.out.println("    }");
            System.out.println("  }");
            System.out.println();
        }

        System.out.println("}"); // class end
    }

    /**
     * Determine whether a word starts with a vowel (for article selection in Javadoc text).
     * @param s the word to test.
     * @return {@code true} if the word starts with a vowel character; {@code false} otherwise.
     */
    private static boolean startsWithVowel(final String s)
    {
        if (s == null || s.isEmpty())
        {
            return false;
        }
        return "AEIOUaeiou".indexOf(s.charAt(0)) >= 0;
    }

    /**
     * Convert a simple CamelCase class name to a spaced title (e.g., {@code "AbsoluteTemperature" -> "Absolute Temperature"}).
     * @param camelCase the CamelCase string to transform.
     * @return the spaced representation of the input string.
     */
    private static String toSpacedTitle(final String camelCase)
    {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (char c : camelCase.toCharArray())
        {
            if (Character.isUpperCase(c) && !first)
            {
                sb.append(' ');
            }
            sb.append(c);
            first = false;
        }
        return sb.toString();
    }
}
