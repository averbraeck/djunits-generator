package org.djunits.value.vfloat.scalar;

import java.util.Locale;
import java.util.regex.Matcher;

import org.djunits.value.Relative;
import org.djunits.value.util.ValueUtil;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.value.function.DimensionlessFunctions;
import org.djunits.value.util.ValueUtil;
import org.djunits.value.vfloat.scalar.base.*;
import org.djutils.base.NumberParser;
import org.djutils.exceptions.Throw;

/**
 * Easy access methods for the Float%Type% FloatScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%Type% extends FloatScalarRel<%Type%Unit, Float%Type%> %DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** Constant with value zero. */
    public static final Float%Type% ZERO = new Float%Type%(0.0f, %Type%Unit.SI);

    /** Constant with value one. */
    public static final Float%Type% ONE = new Float%Type%(1.0f, %Type%Unit.SI);

    /** Constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Float%Type% NaN = new Float%Type%(Float.NaN, %Type%Unit.SI);

    /** Constant with value POSITIVE_INFINITY. */
    public static final Float%Type% POSITIVE_INFINITY = new Float%Type%(Float.POSITIVE_INFINITY, %Type%Unit.SI);

    /** Constant with value NEGATIVE_INFINITY. */
    public static final Float%Type% NEGATIVE_INFINITY = new Float%Type%(Float.NEGATIVE_INFINITY, %Type%Unit.SI);

    /** Constant with value MAX_VALUE. */
    public static final Float%Type% POS_MAXVALUE = new Float%Type%(Float.MAX_VALUE, %Type%Unit.SI);

    /** Constant with value -MAX_VALUE. */
    public static final Float%Type% NEG_MAXVALUE = new Float%Type%(-Float.MAX_VALUE, %Type%Unit.SI);

    /**
     * Construct Float%Type% scalar with a unit.
     * @param value the float value, expressed in the given unit
     * @param unit unit for the float value
     */
    public Float%Type%(final float value, final %Type%Unit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Float%Type% scalar.
     * @param value Scalar from which to construct this instance
     */
    public Float%Type%(final Float%Type% value)
    {
        super(value);
    }

    /**
     * Construct Float%Type% scalar with a unit using a double value.
     * @param value the double value, expressed in the given unit
     * @param unit unit for the resulting float value
     */
    public Float%Type%(final double value, final %Type%Unit unit)
    {
        super((float) value, unit);
    }

    @Override
    public final Float%Type% instantiateRel(final float value, final %Type%Unit unit)
    {
        return new Float%Type%(value, unit);
    }

    /**
     * Construct Float%Type% scalar based on an SI value.
     * @param value the float value in SI units
     * @return the new scalar with the SI value
     */
    public static final Float%Type% ofSI(final float value)
    {
        return new Float%Type%(value, %Type%Unit.SI);
    }

    /**
     * Interpolate between two values. Note that the first value does not have to be smaller than the second.
     * @param zero the value at a ratio of zero
     * @param one the value at a ratio of one
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Float%Type% at the given ratio between 0 and 1
     */
    public static Float%Type% interpolate(final Float%Type% zero, final Float%Type% one, final float ratio)
    {
        Throw.when(ratio < 0.0 || ratio > 1.0, IllegalArgumentException.class, 
                "ratio for interpolation should be between 0 and 1, but is %f", ratio);
        return new Float%Type%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio, zero
            .getDisplayUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Float%Type% max(final Float%Type% r1, final Float%Type% r2)
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
    public static Float%Type% max(final Float%Type% r1, final Float%Type% r2, final Float%Type%... rn)
    {
        Float%Type% maxr = r1.gt(r2) ? r1 : r2;
        for (Float%Type% r : rn)
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
    public static Float%Type% min(final Float%Type% r1, final Float%Type% r2)
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
    public static Float%Type% min(final Float%Type% r1, final Float%Type% r2, final Float%Type%... rn)
    {
        Float%Type% minr = r1.lt(r2) ? r1 : r2;
        for (Float%Type% r : rn)
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
     * Returns a Float%Type% representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by a localized or English abbreviation of the unit. Spaces are allowed,
     * but not required, between the value and the unit.
     * @param text the textual representation to parse into a Float%Type%
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static Float%Type% valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing Float%Type%: text to parse is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing Float%Type%: empty text to parse");
        try
        {
            NumberParser numberParser = new NumberParser().lenient().trailing();
            float f = numberParser.parseFloat(text);
            String unitString = text.substring(numberParser.getTrailingPosition()).trim();
            %Type%Unit unit = %Type%Unit.BASE.getUnitByAbbreviation(unitString);
            Throw.when(unit == null, IllegalArgumentException.class, "Unit %s not found for quantity %Type%", unitString);
            return new Float%Type%(f, unit);
	    }
	    catch (Exception exception)
	    {
	        throw new IllegalArgumentException(
	                "Error parsing Float%Type% from " + text + " using Locale " + Locale.getDefault(Locale.Category.FORMAT),
	                exception);
	    }
    }
    
    /**
     * Returns a Float%Type% based on a value and the textual representation of the unit, which can be localized.
     * @param value the value to use
     * @param unitString the textual representation of the unit
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static Float%Type% of(final float value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing Float%Type%: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing Float%Type%: empty unitString");
        %Type%Unit unit = %Type%Unit.BASE.getUnitByAbbreviation(unitString);
        Throw.when(unit == null, IllegalArgumentException.class, "Error parsing Float%Type% with unit %s", unitString);
        return new Float%Type%(value, unit);
    }
##ENDIF

##IF Dimensionless
	/**
	 * Returns a FloatDimensionless representation of a textual representation of a value with a unit. The String representation
	 * that can be parsed is the double value in the unit, followed by a localized or English abbreviation of the unit. Spaces
	 * are allowed, but not required, between the value and the unit.
	 * @param text the textual representation to parse into a FloatDimensionless
	 * @return the Scalar representation of the value in its unit
	 * @throws IllegalArgumentException when the text cannot be parsed
	 * @throws NullPointerException when the text argument is null
	 */
	public static FloatDimensionless valueOf(final String text)
	{
	    Throw.whenNull(text, "Error parsing FloatDimensionless: text to parse is null");
	    Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing FloatDimensionless: empty text to parse");
	    try
	    {
	        NumberParser numberParser = new NumberParser().lenient().trailing();
	        float f = numberParser.parseFloat(text);
	        String unitString = text.substring(numberParser.getTrailingPosition()).trim();
            Throw.when(unitString.length() != 0, IllegalArgumentException.class, "Dimensionless should not have unit %s", unitString);
	        return new FloatDimensionless(f, DimensionlessUnit.SI);
	    }
	    catch (Exception exception)
	    {
	        throw new IllegalArgumentException("Error parsing FloatDimensionless from " + text + " using Locale "
	                + Locale.getDefault(Locale.Category.FORMAT), exception);
	    }
	}
	
	/**
	 * Returns a FloatDimensionless based on a value and the textual representation of the unit, which can be localized.
	 * @param value the value to use
	 * @param unitString the textual representation of the unit
	 * @return the Scalar representation of the value in its unit
	 * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
	 * @throws NullPointerException when the unitString argument is null
	 */
	public static FloatDimensionless of(final float value, final String unitString)
	{
	    Throw.whenNull(unitString, "Error parsing FloatDimensionless: unitString is null");
	    Throw.when(unitString.trim().length() != 0, IllegalArgumentException.class,
	            "Error parsing FloatDimensionless: non-empty unitString");
	    DimensionlessUnit unit = DimensionlessUnit.SI;
	    return new FloatDimensionless(value, unit);
	}
##ENDIF

##IF Mass
	@Override
	public String toStringSIPrefixed(final int smallestPower, final int biggestPower)
	{
	    if (!Float.isFinite(this.si))
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
	        return String.format(this.si >= 0 ? "%10.4E" : "%10.3E", this.si) + " " + getDisplayUnit().getStandardUnit().getId();
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


