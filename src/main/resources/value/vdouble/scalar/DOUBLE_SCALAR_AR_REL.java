package org.djunits.value.vdouble.scalar;

import java.util.regex.Matcher;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.value.util.ValueUtil;
import org.djunits.value.vdouble.scalar.base.DoubleScalarRelWithAbs;
import org.djutils.base.NumberParser;
import org.djutils.exceptions.Throw;

/**
 * Easy access methods for the Relative %TypeRel% DoubleScalar.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class %TypeRel% extends DoubleScalarRelWithAbs<%TypeAbsUnit%, %TypeAbs%, %TypeRelUnit%, %TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** Constant with value zero. */
    public static final %TypeRel% ZERO = new %TypeRel%(0.0, %TypeRelUnit%.SI);

    /** Constant with value one. */
    public static final %TypeRel% ONE = new %TypeRel%(1.0, %TypeRelUnit%.SI);

##IF Angle
    /** Constant with value pi. */
    public static final Angle PI = new Angle(Math.PI, AngleUnit.RADIAN);
   
    /** Constant with value pi/2. */
    public static final Angle HALF_PI = new Angle(Math.PI / 2.0, AngleUnit.RADIAN);

    /** Constant with value tau. */
    public static final Angle TAU = new Angle(Math.PI * 2.0, AngleUnit.RADIAN);
##ENDIF

    /** Constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final %TypeRel% NaN = new %TypeRel%(Double.NaN, %TypeRelUnit%.SI);

    /** Constant with value POSITIVE_INFINITY. */
    public static final %TypeRel% POSITIVE_INFINITY = new %TypeRel%(Double.POSITIVE_INFINITY, %TypeRelUnit%.SI);

    /** Constant with value NEGATIVE_INFINITY. */
    public static final %TypeRel% NEGATIVE_INFINITY = new %TypeRel%(Double.NEGATIVE_INFINITY, %TypeRelUnit%.SI);

    /** Constant with value MAX_VALUE. */
    public static final %TypeRel% POS_MAXVALUE = new %TypeRel%(Double.MAX_VALUE, %TypeRelUnit%.SI);

    /** Constant with value -MAX_VALUE. */
    public static final %TypeRel% NEG_MAXVALUE = new %TypeRel%(-Double.MAX_VALUE, %TypeRelUnit%.SI);

    /**
     * Construct %TypeRel% scalar with a unit.
     * @param value the double value, expressed in the given unit
     * @param unit unit for the double value
     */
    public %TypeRel%(final double value, final %TypeRelUnit% unit)
    {
        super(value, unit);
    }

    /**
     * Construct %TypeRel% scalar.
     * @param value Scalar from which to construct this instance
     */
    public %TypeRel%(final %TypeRel% value)
    {
        super(value);
    }

    @Override
    public final %TypeRel% instantiateRel(final double value, final %TypeRelUnit% unit)
    {
        return new %TypeRel%(value, unit);
    }

    @Override
    public final %TypeAbs% instantiateAbs(final double value, final %TypeAbsUnit% unit)
    {
        return new %TypeAbs%(value, unit);
    }

    /**
     * Construct %TypeRel% scalar based on an SI value.
     * @param value the double value in SI units
     * @return the new scalar with the SI value
     */
    public static final %TypeRel% ofSI(final double value)
    {
        return new %TypeRel%(value, %TypeRelUnit%.SI);
    }

    /**
     * Interpolate between two values. Note that the first value does not have to be smaller than the second.
     * @param zero the value at a ratio of zero
     * @param one the value at a ratio of one
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a %TypeRel% at the given ratio between 0 and 1
     */
    public static %TypeRel% interpolate(final %TypeRel% zero, final %TypeRel% one, final double ratio)
    {
        Throw.when(ratio < 0.0 || ratio > 1.0, IllegalArgumentException.class, 
                "ratio for interpolation should be between 0 and 1, but is %f", ratio);
        return new %TypeRel%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio, zero
            .getDisplayUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static %TypeRel% max(final %TypeRel% r1, final %TypeRel% r2)
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
    public static %TypeRel% max(final %TypeRel% r1, final %TypeRel% r2, final %TypeRel%... rn)
    {
        %TypeRel% maxr = r1.gt(r2) ? r1 : r2;
        for (%TypeRel% r : rn)
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
    public static %TypeRel% min(final %TypeRel% r1, final %TypeRel% r2)
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
    public static %TypeRel% min(final %TypeRel% r1, final %TypeRel% r2, final %TypeRel%... rn)
    {
        %TypeRel% minr = r1.lt(r2) ? r1 : r2;
        for (%TypeRel% r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }
    
    /**
     * Returns a %TypeRel% representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by a localized or English abbreviation of the unit. Spaces are allowed,
     * but not required, between the value and the unit.
     * @param text the textual representation to parse into a %TypeRel%
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static %TypeRel% valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing %TypeRel%: text to parse is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing %TypeRel%: empty text to parse");
        try
        {
            NumberParser numberParser = new NumberParser().lenient().trailing();
            double d = numberParser.parseDouble(text);
            String unitString = text.substring(numberParser.getTrailingPosition()).trim();
            %TypeRelUnit% unit = %TypeRelUnit%.BASE.getUnitByAbbreviation(unitString);
            Throw.when(unit == null, IllegalArgumentException.class, "Unit %s not found for quantity %TypeRel%", unitString);
            return new %TypeRel%(d, unit);
	    }
	    catch (Exception exception)
	    {
	        throw new IllegalArgumentException(
	                "Error parsing %TypeRel% from " + text + " using Locale " + Locale.getDefault(Locale.Category.FORMAT),
	                exception);
	    }
    }

    /**
     * Returns a %TypeRel% based on a value and the textual representation of the unit, which can be localized.
     * @param value the value to use
     * @param unitString the textual representation of the unit
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static %TypeRel% of(final double value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing %TypeRel%: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing %TypeRel%: empty unitString");
        %TypeRelUnit% unit = %TypeRelUnit%.BASE.getUnitByAbbreviation(unitString);
        Throw.when(unit == null, IllegalArgumentException.class, "Error parsing %TypeRel% with unit %s", unitString);
        return new %TypeRel%(value, unit);
    }


%FORMULAS%%TypeRel%%
    
}

