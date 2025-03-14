package org.djunits.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import jakarta.annotation.Generated;

import org.djutils.exceptions.Throw;
import org.djunits.unit.*;
import org.djunits.unit.SIUnit;
import org.djunits.unit.Unit;
import org.djunits.unit.si.SIDimensions;
import org.djunits.unit.util.UnitRuntimeException;
import org.djunits.value.ValueRuntimeException;
import org.djunits.value.storage.StorageType;
import org.djunits.value.vfloat.scalar.*;
import org.djunits.value.vfloat.scalar.base.FloatScalarRel;
import org.djunits.value.vfloat.vector.*;
import org.djunits.value.vfloat.vector.base.FloatVectorRel;
import org.djunits.value.vfloat.vector.data.FloatVectorData;
import org.djunits.value.vfloat.matrix.*;
import org.djunits.value.vfloat.matrix.base.FloatMatrixRel;
import org.djunits.value.vfloat.matrix.base.FloatMatrix;
import org.djunits.value.vfloat.matrix.data.FloatMatrixData;

/**
 * Easy access methods for the generic Relative SI FloatMatrix.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatSIMatrix extends FloatMatrixRel<SIUnit, FloatSIScalar, FloatSIVector, FloatSIMatrix>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct a new Relative FloatSIMatrix on the basis of a data object.
     * @param data an internal data object
     * @param displayUnit the display unit
     */
    public FloatSIMatrix(final FloatMatrixData data, final SIUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /**
     * Construct a new Relative FloatSIMatrix with a unit for the float values that will also be used for the displayUnit.
     * @param values the values of the entries in the new Relative FloatSIMatrix
     * @param unit the unit of the new Relative FloatSIMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatSIMatrix(final float[][] values, final SIUnit unit, final StorageType storageType) throws ValueRuntimeException
    {
        this(FloatMatrixData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative FloatSIMatrix with a unit for the float values that will also be used for the displayUnit.
     * Assume the StorageType is DENSE since we offer the content as an array.
     * @param values the values of the entries in the new Relative FloatSIMatrix
     * @param unit the unit of the new Relative FloatSIMatrix
     * @throws ValueRuntimeException when values is null
     */
    public FloatSIMatrix(final float[][] values, final SIUnit unit) throws ValueRuntimeException
    {
        this(values, unit, StorageType.DENSE);
    }

    @Override
    public Class<FloatSIScalar> getScalarClass()
    {
        return FloatSIScalar.class;
    }

    @Override
    public Class<FloatSIVector> getVectorClass()
    {
        return FloatSIVector.class;
    }

    /**
     * Returns an FloatSIMatrix based on an array of values and the textual representation of the unit.
     * @param values the values to use
     * @param unitString the textual representation of the unit
     * @param storageType the storage type to use
     * @return the matrix representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIMatrix of(final float[][] values, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(values, "Error parsing FloatSIMatrix: value is null");
        Throw.whenNull(unitString, "Error parsing FloatSIMatrix: unitString is null");
        Throw.whenNull(storageType, "Error parsing FloatSIMatrix: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return new FloatSIMatrix(values, unit, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing FloatSIMatrix with unit " + unitString);
    }

    @Override
    public FloatSIMatrix instantiateMatrix(final FloatMatrixData fmd, final SIUnit unit)
    {
        return new FloatSIMatrix(fmd, unit);
    }

    @Override
    public FloatSIVector instantiateVector(final FloatVectorData fvd, final SIUnit unit)
    {
        return new FloatSIVector(fvd, unit);
    }

    @Override
    public FloatSIScalar instantiateScalarSI(final float valueSI, final SIUnit unit)
    {
        return new FloatSIScalar(valueSI, unit);
    }

    @Override
    public String toString(final SIUnit displayUnit, final boolean verbose, final boolean withUnit)
    {
        return super.toString(displayUnit, verbose, withUnit).replaceAll("!", "");
    }

    /**********************************************************************************/
    /******************************** 'CAST AS' METHODS *******************************/
    /**********************************************************************************/

    %%ASMETHODS%%
}
