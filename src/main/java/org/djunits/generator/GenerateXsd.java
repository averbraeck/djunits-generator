package org.djunits.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
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
 * GenerateXSD builds an XSD that lists, for every quantity, (1) the set of allowed units (QUNITTYPE), (2) a value-with-unit
 * type allowing optional sign (QTYPE), and (3) a value-with-unit type for positive values (POSITIVEQTYPE).
 * <p>
 * Discovery is based on {@link Units#registeredUnits()} (Option B). Because Units registers lazily, we first force-load all
 * classes in {@code org.djunits.quantity} so their static initializers run and register all units.
 * <p>
 * Numeric patterns accept integers, decimals (with or without leading/trailing digits), and scientific notation; and we allow
 * optional spaces between number and unit (matching quantity parsers).
 * <p>
 * Output path: {@code <project-root>/generated-code/resources/djunits.xsd}.
 * <p>
 * Copyright (c) 2003-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved.
 * BSD-style license. See https://djunits.org/docs/license.html.
 * @author Alexander Verbraeck
 */
public class GenerateXsd
{
    /** The output folder of the writer -- will be written in Eclipse project-root/generated-code/resources folder. */
    private static final String GENERATED_CODE_RELATIVE_PATH = "/generated-code";

    /**
     * Calculated absolute output path (root of the executable or Jar). In Eclipse run, ../../ is added to place in project
     * root.
     */
    private static String absoluteRootPath;

    /** XSD output file name (inside resources/). */
    private static final String XSD_FILE = "djunits.xsd";

    /** Package to scan for quantity classes. */
    private static final String QUANTITY_PKG = "org.djunits.quantity";

    /** Force consistent default locale while writing (we output US textual abbreviations). */
    static
    {
        Locale.setDefault(Locale.US);
    }

    /**
     * Main program.
     * @param args not used.
     * @throws FileNotFoundException in case
     */
    public static void main(final String[] args) throws FileNotFoundException
    {
        makeAbsolutePath();
        makeXsd();
    }

    /** Build the XSD using Units.registeredUnits(), after force-loading all quantity classes. */
    private static void makeXsd()
    {
        try
        {
            // 1) Force-load all quantity classes so their static unit fields initialize and register with Units
            int loaded = forceLoadAllQuantities();
            System.out.println("Loaded quantity classes: " + loaded);

            // 2) Now pull the registry: quantityKey -> (unitAbbr -> unit)
            Map<String, Map<String, UnitInterface<?, ?>>> all = Units.registeredUnits(); // lazy map, now filled after loading
            if (all.isEmpty())
            {
                System.err.println("WARNING: Units.registeredUnits() is empty after force-loading. "
                        + "Check that quantity classes reside in package " + QUANTITY_PKG + " and define static unit fields.");
            }

            // 3) Sort for stable output; also map registry keys to base quantity names (strip nested class suffix)
            Map<String, TreeSet<String>> quantityToAbbrs = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

            // Comparator that sorts case-insensitively but keeps case differences so "mm" and "Mm" are distinct
            Comparator<String> orderButCaseDistinct = (a, b) ->
            {
                int ci = String.CASE_INSENSITIVE_ORDER.compare(a, b);
                return (ci != 0) ? ci : a.compareTo(b); // tie-break with natural (case-sensitive) order
            };

            for (var entry : all.entrySet())
            {
                String key = entry.getKey(); // e.g. "Length$Unit" (nested class)
                String baseQuantity = baseQuantityName(key); // -> "Length"

                var set = quantityToAbbrs.computeIfAbsent(baseQuantity, k -> new TreeSet<>(orderButCaseDistinct));

                set.addAll(entry.getValue().keySet()); // now preserves "mm" AND "Mm"
            }

            // 4) Prepare output
            File outPath = new File(absoluteRootPath + "/resources");
            outPath.mkdirs();
            File xsdFile = new File(outPath, XSD_FILE);

            try (PrintWriter pw = new PrintWriter(xsdFile, StandardCharsets.UTF_8))
            {
                writeHeader(pw);

                for (var qEntry : quantityToAbbrs.entrySet())
                {
                    String quantity = qEntry.getKey(); // e.g., "Length"
                    String qUpper = quantity.toUpperCase(Locale.ROOT);
                    String unitTypeName = qUpper + "UNITTYPE";
                    String typeName = qUpper + "TYPE";
                    String posTypeName = "POSITIVE" + qUpper + "TYPE";

                    TreeSet<String> unitAbbrs = qEntry.getValue();

                    // 1) UNITTYPE: enumeration of unit abbreviations (including empty string if present)
                    writeUnitType(pw, unitTypeName, unitAbbrs);

                    // 2) TYPE: [+-]? NUMBER SPACES? UNIT (or number-only if empty unit exists)
                    writeValueWithUnitType(pw, typeName, /* allowSign */ true, unitAbbrs);

                    // 3) POSITIVETYPE: NUMBER SPACES? UNIT (or number-only if empty unit exists)
                    writeValueWithUnitType(pw, posTypeName, /* allowSign */ false, unitAbbrs);
                }

                writeFooter(pw);
            }

            System.out.println("built: " + xsdFile.getAbsolutePath());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    // -------------------------------------------------------------------------------------------------
    // FORCE LOADING OF QUANTITIES
    // -------------------------------------------------------------------------------------------------

    /**
     * Force-load all top-level classes in {@code org.djunits.quantity} (no recursion into subpackages). This triggers static
     * initializers that register units in {@link Units}.
     * @return number of successfully loaded classes
     */
    private static int forceLoadAllQuantities()
    {
        int count = 0;
        try
        {
            String path = QUANTITY_PKG.replace('.', '/');
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null)
            {
                cl = GenerateXsd.class.getClassLoader();
            }

            Enumeration<URL> urls = cl.getResources(path);
            while (urls.hasMoreElements())
            {
                URL url = urls.nextElement();
                String protocol = url.getProtocol();

                if ("file".equals(protocol))
                {
                    // Directory in classes output (e.g., target/classes/org/djunits/quantity)
                    File dir = new File(url.toURI());
                    File[] files = dir.listFiles((
                            d, name
                    ) -> name.endsWith(".class") && isTopLevelClassName(name));
                    if (files != null)
                    {
                        for (File f : files)
                        {
                            String simple = f.getName().substring(0, f.getName().length() - ".class".length());
                            String fqcn = QUANTITY_PKG + "." + simple;
                            count += tryLoad(fqcn, cl);
                        }
                    }
                }
                else if ("jar".equals(protocol))
                {
                    // Inside a JAR
                    JarURLConnection conn = (JarURLConnection) url.openConnection();
                    try (JarFile jar = conn.getJarFile())
                    {
                        String prefix = path + "/";
                        Enumeration<JarEntry> entries = jar.entries();
                        while (entries.hasMoreElements())
                        {
                            JarEntry je = entries.nextElement();
                            String name = je.getName();
                            if (!name.startsWith(prefix) || !name.endsWith(".class"))
                                continue;

                            // Only top-level classes directly in org/djunits/quantity (no deeper '/')
                            String rest = name.substring(prefix.length());
                            if (rest.contains("/")) // subpackage
                                continue;
                            if (!isTopLevelClassName(rest))
                                continue;

                            String simple = rest.substring(0, rest.length() - ".class".length());
                            String fqcn = QUANTITY_PKG + "." + simple;
                            count += tryLoad(fqcn, cl);
                        }
                    }
                }
                else
                {
                    // Fallback: attempt a best-effort file-based resolution
                    // (some exotic classloader protocols might still resolve via toURI())
                    try
                    {
                        File maybeDir = new File(url.toURI());
                        if (maybeDir.isDirectory())
                        {
                            File[] files = maybeDir.listFiles((
                                    d, name
                            ) -> name.endsWith(".class") && isTopLevelClassName(name));
                            if (files != null)
                            {
                                for (File f : files)
                                {
                                    String simple = f.getName().substring(0, f.getName().length() - ".class".length());
                                    String fqcn = QUANTITY_PKG + "." + simple;
                                    count += tryLoad(fqcn, cl);
                                }
                            }
                        }
                    }
                    catch (Exception ignore)
                    {
                        // Ignore; not critical
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.err.println("Error during quantity class scanning: " + e.getMessage());
        }
        return count;
    }

    /**
     * Try to load a class by name with initialization.
     * @param fqcn the fully qualified class name
     * @param cl the classloader to use
     * @return 1 or 0 based on success
     */
    private static int tryLoad(final String fqcn, final ClassLoader cl)
    {
        try
        {
            Class.forName(fqcn, true, cl); // initialize=true triggers static fields and registrations
            return 1;
        }
        catch (Throwable t)
        {
            System.err.println("Could not load " + fqcn + ": " + t.getClass().getSimpleName() + " - " + t.getMessage());
            return 0;
        }
    }

    /**
     * Accept only top-level .class entries (exclude inner classes and metadata).
     * @param classFileName the class file name to test
     * @return true if top-level
     */
    private static boolean isTopLevelClassName(final String classFileName)
    {
        // Exclude inner classes ($), package/module infos, and test classes by convention
        if (classFileName.contains("$"))
            return false;
        if ("package-info.class".equals(classFileName) || "module-info.class".equals(classFileName))
            return false;
        return true;
    }

    /**
     * From a Units registry key like "Length.Unit" → return "Length". If there is no dot, return the key as-is.
     * @param unitsRegistryKey the key
     * @return the unit
     */
    private static String baseQuantityName(final String unitsRegistryKey)
    {
        int dot = unitsRegistryKey.indexOf('.');
        return dot >= 0 ? unitsRegistryKey.substring(0, dot) : unitsRegistryKey;
    }

    // =========================================================================================================
    // XSD writers
    // =========================================================================================================

    /**
     * Write schema header.
     * @param pw writer for output
     */
    private static void writeHeader(final PrintWriter pw)
    {
        pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        pw.println("<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"");
        pw.println("           elementFormDefault=\"qualified\" attributeFormDefault=\"unqualified\">");
        pw.println();
        pw.println("  <!-- This file is generated by GenerateXSD.java. Do not edit by hand. -->");
        pw.println();
    }

    /**
     * Write schema footer.
     * @param pw writer for output
     */
    private static void writeFooter(final PrintWriter pw)
    {
        pw.println("</xs:schema>");
    }

    /**
     * Write the simpleType with enumerated unit abbreviations. If the set contains the empty string, an empty enumeration is
     * written as well.
     * @param pw writer for output
     * @param typeName quantity type to write
     * @param unitAbbrs collection of unit abbreviations
     */
    private static void writeUnitType(final PrintWriter pw, final String typeName, final Iterable<String> unitAbbrs)
    {
        pw.printf("  <xs:simpleType name=\"%s\">%n", escapeXml(typeName));
        pw.println("    <xs:restriction base=\"xs:string\">");
        boolean wroteAny = false;
        for (String abbr : unitAbbrs)
        {
            // Keep duplicates out by using a set in the caller. We still guard here:
            if (abbr == null)
                continue;
            String value = escapeXml(abbr);
            pw.printf("      <xs:enumeration value=\"%s\"/>%n", value);
            wroteAny = true;
        }
        // If no units at all (unlikely), still allow empty string
        if (!wroteAny)
        {
            pw.println("      <xs:enumeration value=\"\"/>");
        }
        pw.println("    </xs:restriction>");
        pw.println("  </xs:simpleType>");
        pw.println();
    }

    /**
     * Write the simpleType with value + unit patterns. If the set of units contains the empty string, a number-only pattern is
     * added as well.
     * @param pw writer for output
     * @param typeName quantity type to write
     * @param allowSign positive/negative or positive only
     * @param unitAbbrs collection of unit abbreviations
     */
    private static void writeValueWithUnitType(final PrintWriter pw, final String typeName, final boolean allowSign,
            final Iterable<String> unitAbbrs)
    {
        pw.printf("  <xs:simpleType name=\"%s\">%n", escapeXml(typeName));
        pw.println("    <xs:restriction base=\"xs:string\">");

        // Base numeric regex (XML Schema regex dialect; no non-capturing groups).
        // NUMBER := ([0-9]+(\.[0-9]*)?|\.[0-9]+)([eE][+-]?[0-9]+)?
        final String NUMBER = "([0-9]+(\\.[0-9]*)?|\\.[0-9]+)([eE][+-]?[0-9]+)?";
        final String SIGN = allowSign ? "[+-]?" : "";
        final String SPACE = "[ ]*"; // accept spaces between value and unit

        boolean wroteAny = false;
        boolean hasEmpty = false;

        // First pass to detect empty unit explicitly (dimensionless or “unitless” abbreviations)
        List<String> list = new ArrayList<>();
        for (String abbr : unitAbbrs)
        {
            if (abbr == null)
                continue;
            if (abbr.isEmpty())
                hasEmpty = true;
            else
                list.add(abbr);
        }

        // Patterns with appended non-empty units
        for (String abbr : list)
        {
            String unitEscapedRegex = escapeForRegex(abbr);
            String pattern = SIGN + NUMBER + SPACE + unitEscapedRegex;
            pw.printf("      <xs:pattern value=\"%s\"/>%n", escapeXml(pattern));
            wroteAny = true;
        }

        // If there is an empty unit abbreviation, add a number-only pattern too
        if (hasEmpty)
        {
            String pattern = SIGN + NUMBER;
            pw.printf("      <xs:pattern value=\"%s\"/>%n", escapeXml(pattern));
            wroteAny = true;
        }

        // Extreme edge-case: if there were no units at all (defensive)
        if (!wroteAny)
        {
            String pattern = SIGN + NUMBER; // number-only
            pw.printf("      <xs:pattern value=\"%s\"/>%n", escapeXml(pattern));
        }

        pw.println("    </xs:restriction>");
        pw.println("  </xs:simpleType>");
        pw.println();
    }

    // =========================================================================================================
    // Utilities
    // =========================================================================================================

    /** Characters that must be escaped for regex safety inside a pattern token. */
    private static final String REGEX_META = "[}.*+?$^|#\\-\\\\"; // also escape dash and backslash

    /**
     * Escape a unit token for use inside an XSD regex pattern.
     * @param s String to test for escaping
     * @return escaped string
     */
    private static String escapeForRegex(final String s)
    {
        StringBuilder out = new StringBuilder(s.length() * 2);
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (REGEX_META.indexOf(c) >= 0)
            {
                out.append('\\');
            }
            out.append(c);
        }
        return out.toString();
    }

    /**
     * Escape text for XML attribute context.
     * @param s String to test for escaping
     * @return escaped string
     */
    private static String escapeXml(final String s)
    {
        StringBuilder out = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            switch (c)
            {
                case '&':
                    out.append("&amp;");
                    break;
                case '<':
                    out.append("&lt;");
                    break;
                case '>':
                    out.append("&gt;");
                    break;
                case '"':
                    out.append("&quot;");
                    break;
                case '\'':
                    out.append("&apos;");
                    break;
                default:
                    out.append(c);
            }
        }
        return out.toString();
    }

    /**
     * Determine calculated absolute output path (root of the executable or Jar file). In case of an Eclipse run, ../../ is
     * added to place the results in the root of the project, rather than in target/classes.
     * @throws FileNotFoundException when path creation fails
     */
    private static void makeAbsolutePath() throws FileNotFoundException
    {
        URL mainURL = URLResource.getResource("/");
        String path;
        try
        {
            path = mainURL.toURI().getPath();
        }
        catch (URISyntaxException exception)
        {
            path = mainURL.getPath();
        }
        if (path.endsWith("/target/classes/"))
        {
            path = path.substring(0, path.length() - "/target/classes/".length());
        }
        path += GENERATED_CODE_RELATIVE_PATH;
        if (!new File(path).exists())
        {
            new File(path).mkdirs();
        }
        absoluteRootPath = path;
        System.out.println("writing into: " + path);
    }
}
