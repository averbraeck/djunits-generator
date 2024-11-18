package org.djunits.value.vfloat.matrix;

import java.util.Collection;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.value.storage.StorageType;
import org.djunits.value.function.DimensionlessFunctions;
import org.djunits.value.vfloat.function.FloatMathFunctions;
import org.djunits.value.vfloat.matrix.base.*;
import org.djunits.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits.value.vfloat.scalar.*;
import org.djunits.value.vfloat.vector.*;
import org.djunits.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloat%Type%Matrix, a matrix of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2024 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%Type%Matrix extends FloatMatrixRel<%Type%Unit, Float%Type%, Float%Type%Vector, Float%Type%Matrix>
%DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a Float%Type%Matrix from an internal data object.
     * @param data the internal data object for the matrix
     * @param displayUnit %Type%Unit; the display unit of the matrix data
     */
    public Float%Type%Matrix(final FloatMatrixData data, final %Type%Unit displayUnit)
    {
        super(data, displayUnit);
    }

    /* CONSTRUCTORS WITH float[][] */

    /**
     * Construct a Float%Type%Matrix from a float[][] object. The float values are expressed in the displayUnit, and will be printed
     * using the displayUnit.
     * @param data the data for the matrix, expressed in the displayUnit
     * @param displayUnit %Type%Unit; the unit of the values in the data array, and display unit when printing
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%Type%Matrix(final float[][] data, final %Type%Unit displayUnit, final StorageType storageType)
    {
        this(FloatMatrixData.instantiate(data, displayUnit.getScale(), storageType), displayUnit);
    }

    /**
     * Construct a Float%Type%Matrix from a float[][] object. The float values are expressed in the displayUnit. Assume that the
     * StorageType is DENSE since we offer the data as an array of an array.
     * @param data the data for the matrix
     * @param displayUnit %Type%Unit; the unit of the values in the data array, and display unit when printing
     */
    public Float%Type%Matrix(final float[][] data, final %Type%Unit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a Float%Type%Matrix from a float[][] object with SI-unit values.
     * @param data the data for the matrix, in SI units
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%Type%Matrix(final float[][] data, final StorageType storageType)
    {
        this(data, %Type%Unit.SI, storageType);
    }

    /**
     * Construct a Float%Type%Matrix from a float[][] object with SI-unit values. Assume that the StorageType is DENSE since we offer
     * the data as an array of an array.
     * @param data the data for the matrix, in SI units
     */
    public Float%Type%Matrix(final float[][] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH %Type%[][] */

    /**
     * Construct a Float%Type%Matrix from an array of an array of Float%Type% objects. The Float%Type% values are each expressed in their own unit,
     * but will be internally stored as SI values, all expressed in the displayUnit when printing.
     * @param data Float%Type%[][]; the data for the matrix
     * @param displayUnit %Type%Unit; the display unit of the values when printing
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%Type%Matrix(final Float%Type%[][] data, final %Type%Unit displayUnit, final StorageType storageType)
    {
        this(FloatMatrixData.instantiate(data, storageType), displayUnit);
    }

    /**
     * Construct a Float%Type%Matrix from an array of an array of Float%Type% objects. The Float%Type% values are each expressed in their own unit,
     * but will be internally stored as SI values, all expressed in the displayUnit when printing. Assume that the StorageType
     * is DENSE since we offer the data as an array of an array.
     * @param data Float%Type%[][]; the data for the matrix
     * @param displayUnit %Type%Unit; the display unit of the values when printing
     */
    public Float%Type%Matrix(final Float%Type%[][] data, final %Type%Unit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a Float%Type%Matrix from an array of an array of Float%Type% objects. The Float%Type% values are each expressed in their own unit,
     * but will be internally stored as SI values, and expressed using SI units when printing. since we offer the data as an
     * array of an array.
     * @param data Float%Type%[][]; the data for the matrix
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%Type%Matrix(final Float%Type%[][] data, final StorageType storageType)
    {
        this(data, %Type%Unit.SI, storageType);
    }

    /**
     * Construct a Float%Type%Matrix from an array of an array of Float%Type% objects. The Float%Type% values are each expressed in their own unit,
     * but will be internally stored as SI values, and expressed using SI units when printing. Assume that the StorageType is
     * DENSE since we offer the data as an array of an array.
     * @param data Float%Type%[][]; the data for the matrix
     */
    public Float%Type%Matrix(final Float%Type%[][] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH Collection<FloatSparseValue> */

    /**
     * Construct a Float%Type%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed.
     * @param data the data for the matrix
     * @param displayUnit %Type%Unit; the display unit of the matrix data, and the unit of the data points
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%Type%Matrix(final Collection<FloatSparseValue<%Type%Unit, Float%Type%>> data, final %Type%Unit displayUnit, final int rows,
            final int cols, final StorageType storageType)
    {
        this(FloatMatrixData.instantiate(data, rows, cols, storageType), displayUnit);
    }

    /**
     * Construct a Float%Type%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Assume the storage
     * type is SPARSE, since we offer the data as a collection.
     * @param data the data for the matrix
     * @param displayUnit %Type%Unit; the display unit of the matrix data, and the unit of the data points
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     */
    public Float%Type%Matrix(final Collection<FloatSparseValue<%Type%Unit, Float%Type%>> data, final %Type%Unit displayUnit, final int rows,
            final int cols)
    {
        this(data, displayUnit, rows, cols, StorageType.SPARSE);
    }

    /**
     * Construct a Float%Type%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Use the SI unit or
     * base unit as the displayUnit.
     * @param data the data for the matrix
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%Type%Matrix(final Collection<FloatSparseValue<%Type%Unit, Float%Type%>> data, final int rows, final int cols,
            final StorageType storageType)
    {
        this(data, %Type%Unit.SI, rows, cols, storageType);
    }

    /**
     * Construct a Float%Type%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Use the SI unit or
     * base unit as the displayUnit. Assume the storage type is SPARSE, since we offer the data as a collection.
     * @param data the data for the matrix
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     */
    public Float%Type%Matrix(final Collection<FloatSparseValue<%Type%Unit, Float%Type%>> data, final int rows, final int cols)
    {
        this(data, %Type%Unit.SI, rows, cols, StorageType.SPARSE);
    }

    @Override
    public Class<Float%Type%> getScalarClass()
    {
        return Float%Type%.class;
    }

    @Override
    public Class<Float%Type%Vector> getVectorClass()
    {
        return Float%Type%Vector.class;
    }

    @Override
    public Float%Type%Matrix instantiateMatrix(final FloatMatrixData fmd, final %Type%Unit displayUnit)
    {
        return new Float%Type%Matrix(fmd, displayUnit);
    }

    @Override
    public Float%Type%Vector instantiateVector(final FloatVectorData fvd, final %Type%Unit displayUnit)
    {
        return new Float%Type%Vector(fvd, displayUnit);
    }

    @Override
    public Float%Type% instantiateScalarSI(final float valueSI, final %Type%Unit displayUnit)
    {
        Float%Type% result = Float%Type%.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

%FORMULAS%%Type%%
}

