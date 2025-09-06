package org.djunits.value.vfloat.scalar;

import java.util.regex.Matcher;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.value.util.ValueUtil;
import org.djunits.value.vfloat.scalar.base.FloatScalarRelWithAbs;
import org.djutils.base.NumberParser;
import org.djutils.exceptions.Throw;

/**
 * Easy access methods for the Float%TypeRel% FloatScalar.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%TypeRel% extends FloatScalarRelWithAbs<%TypeAbsUnit%, Float%TypeAbs%, %TypeRelUnit%, Float%TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** Constant with value zero. */
    public static final Float%TypeRel% ZERO = new Float%TypeRel%(0.0f, %TypeRelUnit%.SI);

    /** Constant with value one. */
    public static final Float%TypeRel% ONE = new Float%TypeRel%(1.0f, %TypeRelUnit%.SI);

##IF Angle
    /** Constant with value pi. */
    public static final FloatAngle PI = new FloatAngle((float) Math.PI, AngleUnit.RADIAN);
   
    /** Constant with value pi/2. */
    public static final FloatAngle HALF_PI = new FloatAngle((float) (Math.PI / 2.0), AngleUnit.RADIAN);

    /** Constant with value tau. */
    public static final FloatAngle TAU = new FloatAngle((float) (Math.PI * 2.0), AngleUnit.RADIAN);
##ENDIF

    /** Constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Float%TypeRel% NaN = new Float%TypeRel%(Float.NaN, %TypeRelUnit%.SI);

    /** Constant with value POSITIVE_INFINITY. */
    public static final Float%TypeRel% POSITIVE_INFINITY = new Float%TypeRel%(Float.POSITIVE_INFINITY, %TypeRelUnit%.SI);

    /** Constant with value NEGATIVE_INFINITY. */
    public static final Float%TypeRel% NEGATIVE_INFINITY = new Float%TypeRel%(Float.NEGATIVE_INFINITY, %TypeRelUnit%.SI);

    /** Constant with value MAX_VALUE. */
    public static final Float%TypeRel% POS_MAXVALUE = new Float%TypeRel%(Float.MAX_VALUE, %TypeRelUnit%.SI);

    /** Constant with value -MAX_VALUE. */
    public static final Float%TypeRel% NEG_MAXVALUE = new Float%TypeRel%(-Float.MAX_VALUE, %TypeRelUnit%.SI);

    /**
     * Construct Float%TypeRel% scalar.
     * @param value the float value
     * @param unit unit for the float value
     */
    public Float%TypeRel%(final float value, final %TypeRelUnit% unit)
    {
        super(value, unit);
    }

    /**
     * Construct Float%TypeRel% scalar.
     * @param value Scalar from which to construct this instance
     */
    public Float%TypeRel%(final Float%TypeRel% value)
    {
        super(value);
    }

    /**
     * Construct Float%TypeRel% scalar using a double value.
     * @param value the double value
     * @param unit unit for the resulting float value
     */
    public Float%TypeRel%(final double value, final %TypeRelUnit% unit)
    {
        super((float) value, unit);
    }

    @Override
    public final Float%TypeRel% instantiateRel(final float value, final %TypeRelUnit% unit)
    {
        return new Float%TypeRel%(value, unit);
    }

    /**
     * Construct Float%TypeRel% scalar.
     * @param value the float value in SI units
     * @return the new scalar with the SI value
     */
    public static final Float%TypeRel% ofSI(final float value)
    {
        return new Float%TypeRel%(value, %TypeRelUnit%.SI);
    }

    @Override
    public final Float%TypeAbs% instantiateAbs(final float value, final %TypeAbsUnit% unit)
    {
        return new Float%TypeAbs%(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Float%TypeRel% interpolate(final Float%TypeRel% zero, final Float%TypeRel% one, final float ratio)
    {
        return new Float%TypeRel%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio, zero
            .getDisplayUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Float%TypeRel% max(final Float%TypeRel% r1, final Float%TypeRel% r2)
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
    public static Float%TypeRel% max(final Float%TypeRel% r1, final Float%TypeRel% r2, final Float%TypeRel%... rn)
    {
        Float%TypeRel% maxr = r1.gt(r2) ? r1 : r2;
        for (Float%TypeRel% r : rn)
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
    public static Float%TypeRel% min(final Float%TypeRel% r1, final Float%TypeRel% r2)
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
    public static Float%TypeRel% min(final Float%TypeRel% r1, final Float%TypeRel% r2, final Float%TypeRel%... rn)
    {
        Float%TypeRel% minr = r1.lt(r2) ? r1 : r2;
        for (Float%TypeRel% r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a Float%TypeRel% representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by a localized or English abbreviation of the unit. Spaces are allowed,
     * but not required, between the value and the unit.
     * @param text the textual representation to parse into a Float%TypeRel%
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static Float%TypeRel% valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing Float%TypeRel%: text to parse is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing Float%TypeRel%: empty text to parse");
        try
        {
            NumberParser numberParser = new NumberParser().lenient().trailing();
            float f = numberParser.parseFloat(text);
            String unitString = text.substring(numberParser.getTrailingPosition()).trim();
            %TypeRelUnit% unit = %TypeRelUnit%.BASE.getUnitByAbbreviation(unitString);
            Throw.when(unit == null, IllegalArgumentException.class, "Unit %s not found for quantity %TypeRel%", unitString);
            return new Float%TypeRel%(f, unit);
	    }
	    catch (Exception exception)
	    {
	        throw new IllegalArgumentException(
	                "Error parsing Float%TypeRel% from " + text + " using Locale " + Locale.getDefault(Locale.Category.FORMAT),
	                exception);
	    }
    }

    /**
     * Returns a Float%TypeRel% based on a value and the textual representation of the unit, which can be localized.
     * @param value the value to use
     * @param unitString the textual representation of the unit
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static Float%TypeRel% of(final float value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing Float%TypeRel%: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing Float%TypeRel%: empty unitString");
        %TypeRelUnit% unit = %TypeRelUnit%.BASE.getUnitByAbbreviation(unitString);
        Throw.when(unit == null, IllegalArgumentException.class, "Error parsing Float%TypeRel% with unit %s", unitString);
        return new Float%TypeRel%(value, unit);
    }


%FORMULAS%%TypeRel%%
}

