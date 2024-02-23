package org.djunits.value.vfloat.scalar;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.unit.si.SIDimensions;
import org.djunits.unit.util.UnitRuntimeException;
import org.djunits.value.util.ValueUtil;
import org.djunits.value.vdouble.scalar.Dimensionless;
import org.djunits.value.vdouble.scalar.SIScalar;
import org.djunits.value.vdouble.scalar.base.DoubleScalarRel;
import org.djunits.value.vdouble.scalar.base.DoubleScalar;
import org.djunits.value.vfloat.scalar.base.FloatScalarRel;
import org.djunits.value.vfloat.scalar.base.FloatScalar;
import org.djutils.base.NumberParser;
import org.djutils.exceptions.Throw;

/**
 * Easy access methods for the generic Relative SI FloatScalar.
 * <p>
 * Copyright (c) 2013-2024 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatSIScalar extends FloatScalarRel<SIUnit, FloatSIScalar>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct SI scalar.
     * @param value float; the float value
     * @param unit SIUnit; unit for the float value
     */
    public FloatSIScalar(final float value, final SIUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct SI scalar.
     * @param value FloatSIScalar; Scalar from which to construct this instance
     */
    public FloatSIScalar(final FloatSIScalar value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSIScalar instantiateRel(final float value, final SIUnit unit)
    {
        return new FloatSIScalar(value, unit);
    }

    /**
     * Construct SI scalar.
     * @param value float; the float value in SI units
     * @param unit SIUnit; the unit to use for the SI scalar
     * @return FloatSIScalar; the new scalar with the SI value
     */
    public static final FloatSIScalar instantiateSI(final float value, final SIUnit unit)
    {
        return new FloatSIScalar(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatSIScalar; the low value
     * @param one FloatSIScalar; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return FloatSIScalar; a Scalar at the ratio between
     */
    public static FloatSIScalar interpolate(final FloatSIScalar zero, final FloatSIScalar one, final float ratio)
    {
        return new FloatSIScalar(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio, zero.getDisplayUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @return FloatSIScalar; the maximum value of two relative scalars
     */
    public static FloatSIScalar max(final FloatSIScalar r1, final FloatSIScalar r2)
    {
        return r1.gt(r2) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @param rn FloatSIScalar...; the other scalars
     * @return FloatSIScalar; the maximum value of more than two relative scalars
     */
    public static FloatSIScalar max(final FloatSIScalar r1, final FloatSIScalar r2, final FloatSIScalar... rn)
    {
        FloatSIScalar maxr = r1.gt(r2) ? r1 : r2;
        for (FloatSIScalar r : rn)
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
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @return FloatSIScalar; the minimum value of two relative scalars
     */
    public static FloatSIScalar min(final FloatSIScalar r1, final FloatSIScalar r2)
    {
        return r1.lt(r2) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @param rn FloatSIScalar...; the other scalars
     * @return FloatSIScalar; the minimum value of more than two relative scalars
     */
    public static FloatSIScalar min(final FloatSIScalar r1, final FloatSIScalar r2, final FloatSIScalar... rn)
    {
        FloatSIScalar minr = r1.lt(r2) ? r1 : r2;
        for (FloatSIScalar r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /** {@inheritDoc} */
    @Override
    public FloatSIScalar reciprocal()
    {
        return FloatScalar.divide(FloatDimensionless.ONE, this);
    }

    /**
     * Returns an FloatSIScalar representation of a textual representation of a value with a unit. The String representation that can
     * be parsed is the float value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatSIScalar
     * @return FloatSIScalar; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static FloatSIScalar valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing SIScalar: unitString is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing SIScalar: empty string");
        try
        {
            NumberParser numberParser = new NumberParser().lenient().trailing();
            float f = numberParser.parseFloat(text);
            String unitString = text.substring(numberParser.getTrailingPosition()).trim();
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit == null)
                throw new IllegalArgumentException("Unit " + unitString + " for FloatSIScalar not found");
            return new FloatSIScalar(f, unit);
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException(
                    "Error parsing FloatSIScalar from " + text + " using Locale " + Locale.getDefault(Locale.Category.FORMAT),
                    exception);
        }
    }

    /**
     * Returns an FloatSIScalar based on a value and the textual representation of the unit.
     * @param value float; the value to use
     * @param unitString String; the textual representation of the unit
     * @return FloatSIScalar; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIScalar of(final float value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing FloatSIScalar: unitString is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return new FloatSIScalar(value, unit);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing FloatSIScalar with unit " + unitString);
    }

    /** {@inheritDoc} */
    @Override
    public String toString(final SIUnit displayUnit, final boolean verbose, final boolean withUnit)
    {
        return super.toString(displayUnit, verbose, withUnit).replaceAll("!", "");
    }

    /**********************************************************************************/
    /******************************** 'CAST AS' METHODS *******************************/
    /**********************************************************************************/

    /**
     * Return the current scalar transformed to a scalar in the given unit. Of course the SI dimensionality has to match,
     * otherwise the scalar cannot be transformed. The compiler will check the alignment between the return value and the unit.
     * @param displayUnit KU; the unit in which the scalar needs to be expressed
     * @return S; the scalar that has been transformed into the right scalar type and unit
     * @param <U> the unit type
     * @param <S> the scalar type
     */
    public final <U extends Unit<U>, S extends FloatScalarRel<U, S>> S as(final U displayUnit)
    {
        Throw.when(!(getDisplayUnit().getQuantity().getSiDimensions().equals(displayUnit.getQuantity().getSiDimensions())),
                UnitRuntimeException.class, "FloatSIScalar with unit %s cannot be converted to a scalar with unit %s", getDisplayUnit(),
                displayUnit);
        S result = FloatScalar.instantiate(this.si, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    %%ASMETHODS%%

}
