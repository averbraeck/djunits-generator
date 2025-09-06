package org.djunits.value.vfloat.matrix;

import java.util.Collection;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.value.storage.StorageType;
import org.djunits.value.vfloat.matrix.base.*;
import org.djunits.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits.value.vfloat.scalar.*;
import org.djunits.value.vfloat.vector.*;
import org.djunits.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float%TypeAbs% Matrix.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%TypeAbs%Matrix extends FloatMatrixAbs<%TypeAbsUnit%, Float%TypeAbs%, Float%TypeAbs%Vector, Float%TypeAbs%Matrix,
%TypeRelUnit%, Float%TypeRel%, Float%TypeRel%Vector, Float%TypeRel%Matrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;
    
    /**
     * Construct a %TypeAbs%Matrix from an internal data object.
     * @param data the internal data object for the matrix
     * @param displayUnit the display unit of the matrix data
     */
    public Float%TypeAbs%Matrix(final FloatMatrixData data, final %TypeAbsUnit% displayUnit)
    {
        super(data, displayUnit);
    }

    /* CONSTRUCTORS WITH float[][] */

    /**
     * Construct a Float%TypeAbs%Matrix from a float[][] object. The float values are expressed in the displayUnit, and will be printed
     * using the displayUnit.
     * @param data the data for the matrix, expressed in the displayUnit
     * @param displayUnit the unit of the values in the data array, and display unit when printing
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeAbs%Matrix(final float[][] data, final %TypeAbsUnit% displayUnit, final StorageType storageType)
    {
        this(FloatMatrixData.instantiate(data, displayUnit.getScale(), storageType), displayUnit);
    }

    /**
     * Construct a Float%TypeAbs%Matrix from a float[][] object. The float values are expressed in the displayUnit. Assume that the
     * StorageType is DENSE since we offer the data as an array of an array.
     * @param data the data for the matrix
     * @param displayUnit the unit of the values in the data array, and display unit when printing
     */
    public Float%TypeAbs%Matrix(final float[][] data, final %TypeAbsUnit% displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a Float%TypeAbs%Matrix from a float[][] object with SI-unit values.
     * @param data the data for the matrix, in SI units
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeAbs%Matrix(final float[][] data, final StorageType storageType)
    {
        this(data, %TypeAbsUnit%.BASE.getStandardUnit(), storageType);
    }

    /**
     * Construct a Float%TypeAbs%Matrix from a float[][] object with SI-unit values. Assume that the StorageType is DENSE since we offer
     * the data as an array of an array.
     * @param data the data for the matrix, in SI units
     */
    public Float%TypeAbs%Matrix(final float[][] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH Float%TypeAbs%[][] */

    /**
     * Construct a Float%TypeAbs%Matrix from an array of an array of Float%TypeAbs% objects. The Float%TypeAbs% values are each expressed in their own unit,
     * but will be internally stored as SI values, all expressed in the displayUnit when printing.
     * @param data the data for the matrix
     * @param displayUnit the display unit of the values when printing
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeAbs%Matrix(final Float%TypeAbs%[][] data, final %TypeAbsUnit% displayUnit, final StorageType storageType)
    {
        this(FloatMatrixData.instantiate(data, storageType), displayUnit);
    }

    /**
     * Construct a Float%TypeAbs%Matrix from an array of an array of Float%TypeAbs% objects. The Float%TypeAbs% values are each expressed in their own unit,
     * but will be internally stored as SI values, all expressed in the displayUnit when printing. Assume that the StorageType
     * is DENSE since we offer the data as an array of an array.
     * @param data the data for the matrix
     * @param displayUnit the display unit of the values when printing
     */
    public Float%TypeAbs%Matrix(final Float%TypeAbs%[][] data, final %TypeAbsUnit% displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a Float%TypeAbs%Matrix from an array of an array of Float%TypeAbs% objects. The Float%TypeAbs% values are each expressed in their own unit,
     * but will be internally stored as SI values, and expressed using SI units when printing. since we offer the data as an
     * array of an array.
     * @param data the data for the matrix
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeAbs%Matrix(final Float%TypeAbs%[][] data, final StorageType storageType)
    {
        this(data, %TypeAbsUnit%.BASE.getStandardUnit(), storageType);
    }

    /**
     * Construct a Float%TypeAbs%Matrix from an array of an array of Float%TypeAbs% objects. The Float%TypeAbs% values are each expressed in their own unit,
     * but will be internally stored as SI values, and expressed using SI units when printing. Assume that the StorageType is
     * DENSE since we offer the data as an array of an array.
     * @param data the data for the matrix
     */
    public Float%TypeAbs%Matrix(final Float%TypeAbs%[][] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH Collection<FloatSparseValue> */

    /**
     * Construct a Float%TypeAbs%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed.
     * @param data the data for the matrix
     * @param displayUnit the display unit of the matrix data, and the unit of the data points
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeAbs%Matrix(final Collection<FloatSparseValue<%TypeAbsUnit%, Float%TypeAbs%>> data, final %TypeAbsUnit% displayUnit, final int rows,
            final int cols, final StorageType storageType)
    {
        this(FloatMatrixData.instantiate(data, rows, cols, storageType), displayUnit);
    }

    /**
     * Construct a Float%TypeAbs%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Assume the storage
     * type is SPARSE, since we offer the data as a collection.
     * @param data the data for the matrix
     * @param displayUnit the display unit of the matrix data, and the unit of the data points
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     */
    public Float%TypeAbs%Matrix(final Collection<FloatSparseValue<%TypeAbsUnit%, Float%TypeAbs%>> data, final %TypeAbsUnit% displayUnit, final int rows,
            final int cols)
    {
        this(data, displayUnit, rows, cols, StorageType.SPARSE);
    }

    /**
     * Construct a Float%TypeAbs%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Use the SI unit or
     * base unit as the displayUnit.
     * @param data the data for the matrix
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeAbs%Matrix(final Collection<FloatSparseValue<%TypeAbsUnit%, Float%TypeAbs%>> data, final int rows, final int cols,
            final StorageType storageType)
    {
        this(data, %TypeAbsUnit%.BASE.getStandardUnit(), rows, cols, storageType);
    }

    /**
     * Construct a Float%TypeAbs%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Use the SI unit or
     * base unit as the displayUnit. Assume the storage type is SPARSE, since we offer the data as a collection.
     * @param data the data for the matrix
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     */
    public Float%TypeAbs%Matrix(final Collection<FloatSparseValue<%TypeAbsUnit%, Float%TypeAbs%>> data, final int rows, final int cols)
    {
        this(data, %TypeAbsUnit%.BASE.getStandardUnit(), rows, cols, StorageType.SPARSE);
    }
    
    @Override
    public Class<Float%TypeAbs%> getScalarClass()
    {
        return Float%TypeAbs%.class;
    }
    
    @Override
    public Class<Float%TypeAbs%Vector> getVectorClass()
    {
        return Float%TypeAbs%Vector.class;
    }

    @Override
    public Float%TypeAbs%Matrix instantiateMatrix(final FloatMatrixData fmd, final %TypeAbsUnit% displayUnit)
    {
        return new Float%TypeAbs%Matrix(fmd, displayUnit);
    }

    @Override
    public Float%TypeAbs%Vector instantiateVector(final FloatVectorData fvd, final %TypeAbsUnit% displayUnit)
    {
        return new Float%TypeAbs%Vector(fvd, displayUnit);
    }

    @Override
    public Float%TypeAbs% instantiateScalarSI(final float valueSI, final %TypeAbsUnit% displayUnit)
    {
        Float%TypeAbs% result = Float%TypeAbs%.ofSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

    @Override
    public Float%TypeRel%Matrix instantiateMatrixRel(final FloatMatrixData fmd, final %TypeRelUnit% displayUnit)
    {
        return new Float%TypeRel%Matrix(fmd, displayUnit);
    }

    @Override
    public Float%TypeRel%Vector instantiateVectorRel(final FloatVectorData fvd, final %TypeRelUnit% displayUnit)
    {
        return new Float%TypeRel%Vector(fvd, displayUnit);
    }

    @Override
    public Float%TypeRel% instantiateScalarRelSI(final float valueSI, final %TypeRelUnit% displayUnit)
    {
        Float%TypeRel% result = Float%TypeRel%.ofSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

%FORMULAS%%TypeAbs%%
}
