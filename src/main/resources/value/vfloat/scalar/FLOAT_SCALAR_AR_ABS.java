package org.djunits.value.vfloat.scalar;

import java.util.regex.Matcher;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.value.util.ValueUtil;
import org.djunits.value.vfloat.scalar.base.FloatScalarAbs;
import org.djutils.base.NumberParser;
import org.djutils.exceptions.Throw;

/**
 * Easy access methods for the Float%TypeAbs% FloatScalar.
##IF Time
 * <p>
 * Note that when the offset of a stored absolute FloatTime becomes large, precision of a float might not be enough for the required
 * resolution of a Time. A float has around 7 significant digits (23 bit mantissa). This means that when we need to have a float
 * time that is precise to microseconds, the FloatTime value should not go above 2^22 = 4.0E6. This is <b>not</b> enough to store
 * Epoch values that are in the order of magnitude of 2E12 ms! So feeding System.TimeInMillis() to a FloatTime with
 * TimeUnit.BASE as its unit is not having the required precision. At best, a FloatTime can store TimeUnit.BASE or
 * TimeUnit.EPOCH values with real calendar values with a precision of several minutes.
 * </p>
##ENDIF
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%TypeAbs% extends FloatScalarAbs<%TypeAbsUnit%, Float%TypeAbs%, %TypeRelUnit%, Float%TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** Constant with value zero. */
    public static final Float%TypeAbs% ZERO = new Float%TypeAbs%(0.0f, %TypeAbsUnit%.DEFAULT);

    /**
     * Construct Float%TypeAbs% scalar with a unit.
     * @param value the float value, expressed in the given unit
     * @param unit unit for the float value
     */
    public Float%TypeAbs%(final float value, final %TypeAbsUnit% unit)
    {
        super(value, unit);
    }

    /**
     * Construct Float%TypeAbs% scalar with a unit using a double value.
     * @param value the double value, expressed in the given unit
     * @param unit unit for the resulting float value
     */
    public Float%TypeAbs%(final double value, final %TypeAbsUnit% unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct Float%TypeAbs% scalar.
     * @param value Scalar from which to construct this instance
     */
    public Float%TypeAbs%(final Float%TypeAbs% value)
    {
        super(value);
    }

    @Override
    public final Float%TypeAbs% instantiateAbs(final float value, final %TypeAbsUnit% unit)
    {
        return new Float%TypeAbs%(value, unit);
    }

    @Override
    public final Float%TypeRel% instantiateRel(final float value, final %TypeRelUnit% unit)
    {
        return new Float%TypeRel%(value, unit);
    }

    /**
     * Construct Float%TypeAbs% scalar based on an BASE unit.
     * @param value the float value in BASE units
     * @return the new scalar with the BASE value
     */
    public static final Float%TypeAbs% ofSI(final float value)
    {
        return new Float%TypeAbs%(value, %TypeAbsUnit%.DEFAULT);
    }

    /**
     * Interpolate between two values. Note that the first value does not have to be smaller than the second.
     * @param zero the value at a ratio of zero
     * @param one the value at a ratio of one
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Float%TypeAbs% at the given ratio between 0 and 1
     */
    public static Float%TypeAbs% interpolate(final Float%TypeAbs% zero, final Float%TypeAbs% one, final float ratio)
    {
        Throw.when(ratio < 0.0 || ratio > 1.0, IllegalArgumentException.class, 
                "ratio for interpolation should be between 0 and 1, but is %f", ratio);
        return new Float%TypeAbs%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio, zero
            .getDisplayUnit());
    }
    
    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static Float%TypeAbs% max(final Float%TypeAbs% a1, final Float%TypeAbs% a2)
    {
        return a1.gt(a2) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @param an the other scalars
     * @return the maximum value of more than two absolute scalars
     */
    public static Float%TypeAbs% max(final Float%TypeAbs% a1, final Float%TypeAbs% a2, final Float%TypeAbs%... an)
    {
        Float%TypeAbs% maxa = a1.gt(a2) ? a1 : a2;
        for (Float%TypeAbs% a : an)
        {
            if (a.gt(maxa))
            {
                maxa = a;
            }
        }
        return maxa;
    }

    /**
     * Return the minimum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static Float%TypeAbs% min(final Float%TypeAbs% a1, final Float%TypeAbs% a2)
    {
        return a1.lt(a2) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @param an the other scalars
     * @return the minimum value of more than two absolute scalars
     */
    public static Float%TypeAbs% min(final Float%TypeAbs% a1, final Float%TypeAbs% a2, final Float%TypeAbs%... an)
    {
        Float%TypeAbs% mina = a1.lt(a2) ? a1 : a2;
        for (Float%TypeAbs% a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

    /**
     * Returns a Float%TypeAbs% representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by a localized or English abbreviation of the unit. Spaces are allowed,
     * but not required, between the value and the unit.
     * @param text the textual representation to parse into a Float%TypeAbs%
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static Float%TypeAbs% valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing Float%TypeAbs%: text to parse is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing Float%TypeAbs%: empty text to parse");
        try
        {
            NumberParser numberParser = new NumberParser().lenient().trailing();
            float f = numberParser.parseFloat(text);
            String unitString = text.substring(numberParser.getTrailingPosition()).trim();
            %TypeAbsUnit% unit = %TypeAbsUnit%.BASE.getUnitByAbbreviation(unitString);
            Throw.when(unit == null, IllegalArgumentException.class, "Unit %s not found for quantity %TypeAbs%", unitString);
            return new Float%TypeAbs%(f, unit);
	    }
	    catch (Exception exception)
	    {
	        throw new IllegalArgumentException(
	                "Error parsing Float%TypeAbs% from " + text + " using Locale " + Locale.getDefault(Locale.Category.FORMAT),
	                exception);
	    }
    }

    /**
     * Returns a Float%TypeAbs% based on a value and the textual representation of the unit, which can be localized.
     * @param value the value to use
     * @param unitString the textual representation of the unit
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static Float%TypeAbs% of(final float value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing Float%TypeAbs%: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing Float%TypeAbs%: empty unitString");
        %TypeAbsUnit% unit = %TypeAbsUnit%.BASE.getUnitByAbbreviation(unitString);
        Throw.when(unit == null, IllegalArgumentException.class, "Error parsing Float%TypeAbs% with unit %s", unitString);
        return new Float%TypeAbs%(value, unit);
    }


%FORMULAS%%TypeAbs%%
}

