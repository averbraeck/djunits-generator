package org.djunits.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import jakarta.annotation.Generated;

import org.djutils.exceptions.Throw;
import org.djunits.unit.*;
import org.djunits.unit.si.SIDimensions;
import org.djunits.unit.util.UnitRuntimeException;
import org.djunits.value.ValueRuntimeException;
import org.djunits.value.storage.StorageType;
import org.djunits.value.vdouble.matrix.*;
import org.djunits.value.vdouble.matrix.base.DoubleMatrixRel;
import org.djunits.value.vdouble.matrix.base.DoubleMatrix;
import org.djunits.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits.value.vdouble.scalar.*;
import org.djunits.value.vdouble.scalar.SIScalar;
import org.djunits.value.vdouble.scalar.base.DoubleScalarRel;
import org.djunits.value.vdouble.vector.*;
import org.djunits.value.vdouble.vector.SIVector;
import org.djunits.value.vdouble.vector.base.DoubleVectorRel;
import org.djunits.value.vdouble.vector.data.DoubleVectorData;

/**
 * Easy access methods for the generic Relative SI DoubleMatrix.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class SIMatrix extends DoubleMatrixRel<SIUnit, SIScalar, SIVector, SIMatrix>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct a new Relative Double SIMatrix on the basis of a data object.
     * @param data an internal data object
     * @param unit the unit
     */
    public SIMatrix(final DoubleMatrixData data, final SIUnit unit)
    {
        super(data, unit);
    }

    /**
     * Construct a new Relative Double SIMatrix with a unit for the float values that will also be used for the displayUnit.
     * @param values the values of the entries in the new Relative Double SIMatrix
     * @param unit the unit of the new Relative Double SIMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public SIMatrix(final double[][] values, final SIUnit unit, final StorageType storageType) throws ValueRuntimeException
    {
        this(DoubleMatrixData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative Double SIMatrix with a unit for the float values that will also be used for the displayUnit.
     * Assume the StorageType is DENSE since we offer the content as an array.
     * @param values the values of the entries in the new Relative Double SIMatrix
     * @param unit the unit of the new Relative Double SIMatrix
     * @throws ValueRuntimeException when values is null
     */
    public SIMatrix(final double[][] values, final SIUnit unit) throws ValueRuntimeException
    {
        this(values, unit, StorageType.DENSE);
    }

    @Override
    public Class<SIScalar> getScalarClass()
    {
        return SIScalar.class;
    }

    @Override
    public Class<SIVector> getVectorClass()
    {
        return SIVector.class;
    }

    /**
     * Returns an SIMatrix based on an array of values and the textual representation of the unit.
     * @param values the values to use
     * @param unitString the textual representation of the unit
     * @param storageType the storage type to use
     * @return the matrix representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static SIMatrix of(final double[][] values, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(values, "Error parsing SIMatrix: value is null");
        Throw.whenNull(unitString, "Error parsing SIMatrix: unitString is null");
        Throw.whenNull(storageType, "Error parsing SIMatrix: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return new SIMatrix(values, unit, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing SIMatrix with unit " + unitString);
    }

    @Override
    public SIMatrix instantiateMatrix(final DoubleMatrixData dmd, final SIUnit unit)
    {
        return new SIMatrix(dmd, unit);
    }

    @Override
    public SIVector instantiateVector(final DoubleVectorData dvd, final SIUnit unit)
    {
        return new SIVector(dvd, unit);
    }

    @Override
    public SIScalar instantiateScalarSI(final double valueSI, final SIUnit unit)
    {
        return new SIScalar(valueSI, unit);
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
