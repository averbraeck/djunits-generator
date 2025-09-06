package org.djunits.value.vdouble.scalar;

import java.util.Locale;
import java.util.regex.Matcher;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.value.util.ValueUtil;
import org.djunits.value.vdouble.scalar.base.DoubleScalarRel;
import org.djunits.value.function.DimensionlessFunctions;
import org.djutils.base.NumberParser;
import org.djutils.exceptions.Throw;

/**
 * Easy access methods for the %Type% DoubleScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class %Type% extends DoubleScalarRel<%Type%Unit, %Type%> %DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** Constant with value zero. */
    public static final %Type% ZERO = new %Type%(0.0, %Type%Unit.SI);

    /** Constant with value one. */
    public static final %Type% ONE = new %Type%(1.0, %Type%Unit.SI);

    /** Constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final %Type% NaN = new %Type%(Double.NaN, %Type%Unit.SI);

    /** Constant with value POSITIVE_INFINITY. */
    public static final %Type% POSITIVE_INFINITY = new %Type%(Double.POSITIVE_INFINITY, %Type%Unit.SI);

    /** Constant with value NEGATIVE_INFINITY. */
    public static final %Type% NEGATIVE_INFINITY = new %Type%(Double.NEGATIVE_INFINITY, %Type%Unit.SI);

    /** Constant with value MAX_VALUE. */
    public static final %Type% POS_MAXVALUE = new %Type%(Double.MAX_VALUE, %Type%Unit.SI);

    /** Constant with value -MAX_VALUE. */
    public static final %Type% NEG_MAXVALUE = new %Type%(-Double.MAX_VALUE, %Type%Unit.SI);

    /**
     * Construct %Type% scalar.
     * @param value the double value
     * @param unit unit for the double value
     */
    public %Type%(final double value, final %Type%Unit unit)
    {
        super(value, unit);
    }

    /**
     * Construct %Type% scalar.
     * @param value Scalar from which to construct this instance
     */
    public %Type%(final %Type% value)
    {
        super(value);
    }

    @Override
    public final %Type% instantiateRel(final double value, final %Type%Unit unit)
    {
        return new %Type%(value, unit);
    }

    /**
     * Construct %Type% scalar.
     * @param value the double value in SI units
     * @return the new scalar with the SI value
     */
    public static final %Type% ofSI(final double value)
    {
        return new %Type%(value, %Type%Unit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static %Type% interpolate(final %Type% zero, final %Type% one, final double ratio)
    {
        return new %Type%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio, zero.getDisplayUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static %Type% max(final %Type% r1, final %Type% r2)
    {
        return r1.gt(r2) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static %Type% max(final %Type% r1, final %Type% r2, final %Type%... rn)
    {
        %Type% maxr = r1.gt(r2) ? r1 : r2;
        for (%Type% r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two relative scalars
     */
    public static %Type% min(final %Type% r1, final %Type% r2)
    {
        return r1.lt(r2) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static %Type% min(final %Type% r1, final %Type% r2, final %Type%... rn)
    {
        %Type% minr = r1.lt(r2) ? r1 : r2;
        for (%Type% r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

##IF !Dimensionless
    /**
     * Returns a %Type% representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by a localized or English abbreviation of the unit. Spaces are allowed,
     * but not required, between the value and the unit.
     * @param text the textual representation to parse into a %Type%
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static %Type% valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing %Type%: text to parse is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing %Type%: empty text to parse");
        try
        {
            NumberParser numberParser = new NumberParser().lenient().trailing();
            double d = numberParser.parseDouble(text);
            String unitString = text.substring(numberParser.getTrailingPosition()).trim();
            %Type%Unit unit = %Type%Unit.BASE.getUnitByAbbreviation(unitString);
            Throw.when(unit == null, IllegalArgumentException.class, "Unit %s not found for quantity %Type%", unitString);
            return new %Type%(d, unit);
	    }
	    catch (Exception exception)
	    {
	        throw new IllegalArgumentException(
	                "Error parsing %Type% from " + text + " using Locale " + Locale.getDefault(Locale.Category.FORMAT),
	                exception);
	    }
    }

    /**
     * Returns a %Type% based on a value and the textual representation of the unit, which can be localized.
     * @param value the value to use
     * @param unitString the textual representation of the unit
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static %Type% of(final double value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing %Type%: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing %Type%: empty unitString");
        %Type%Unit unit = %Type%Unit.BASE.getUnitByAbbreviation(unitString);
        Throw.when(unit == null, IllegalArgumentException.class, "Error parsing %Type% with unit %s", unitString);
        return new %Type%(value, unit);
    }
##ENDIF

##IF Dimensionless
	/**
	 * Returns a Dimensionless representation of a textual representation of a value with a unit. The String representation that
	 * can be parsed is the double value in the unit, followed by a localized or English abbreviation of the unit. Spaces are
	 * allowed, but not required, between the value and the unit.
	 * @param text the textual representation to parse into a Dimensionless
	 * @return the Scalar representation of the value in its unit
	 * @throws IllegalArgumentException when the text cannot be parsed
	 * @throws NullPointerException when the text argument is null
	 */
	public static Dimensionless valueOf(final String text)
	{
	    Throw.whenNull(text, "Error parsing Dimensionless: text to parse is null");
	    Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing Dimensionless: empty text to parse");
	    try
	    {
	        NumberParser numberParser = new NumberParser().lenient().trailing();
	        double d = numberParser.parseDouble(text);
	        String unitString = text.substring(numberParser.getTrailingPosition()).trim();
	        Throw.when(unitString.length() != 0, IllegalArgumentException.class, "Dimensionless should not have unit %s", unitString);
	        return new Dimensionless(d, DimensionlessUnit.SI);
	    }
	    catch (Exception exception)
	    {
	        throw new IllegalArgumentException(
	                "Error parsing Dimensionless from " + text + " using Locale " + Locale.getDefault(Locale.Category.FORMAT),
	                exception);
	    }
	}
	
	/**
	 * Returns a Dimensionless based on a value and the textual representation of the unit, which can be localized.
	 * @param value the value to use
	 * @param unitString the textual representation of the unit
	 * @return the Scalar representation of the value in its unit
	 * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
	 * @throws NullPointerException when the unitString argument is null
	 */
	public static Dimensionless of(final double value, final String unitString)
	{
	    Throw.whenNull(unitString, "Error parsing Dimensionless: unitString is null");
        Throw.when(unitString.trim().length() != 0, IllegalArgumentException.class,
                "Error parsing Dimensionless: non-empty unitString");
	    DimensionlessUnit unit = DimensionlessUnit.SI;
	    return new Dimensionless(value, unit);
	}
##ENDIF

##IF Mass
	@Override
	public String toStringSIPrefixed(final int smallestPower, final int biggestPower)
	{
	    if (!Double.isFinite(this.si))
	    {
	        return toString(getDisplayUnit().getStandardUnit());
	    }
	    // PK: I can't think of an easier way to figure out what the exponent will be; rounding of the mantissa to the available
	    // width makes this hard; This feels like an expensive way.
	    String check = String.format(this.si >= 0 ? "%10.8E" : "%10.7E", this.si);
	    int exponent = Integer.parseInt(check.substring(check.indexOf("E") + 1));
	    if (exponent < -27 || exponent < smallestPower || exponent > 21 + 2 || exponent > biggestPower)
	    {
	        // Out of SI prefix range; do not scale.
	        return String.format(this.si >= 0 ? "%10.4E" : "%10.3E", this.si) + " "
	                + getDisplayUnit().getStandardUnit().getId();
	    }
	    Integer roundedExponent = (int) Math.ceil((exponent - 2.0) / 3) * 3 + 3;
	    // System.out.print(String.format("exponent=%d; roundedExponent=%d ", exponent, roundedExponent));
	    String key = SIPrefixes.FACTORS.get(roundedExponent).getDefaultTextualPrefix() + "g";
	    MassUnit displayUnit = getDisplayUnit().getQuantity().getUnitByAbbreviation(key);
	    return toString(displayUnit);
	}
##ENDIF
    
%FORMULAS%%Type%%
}


