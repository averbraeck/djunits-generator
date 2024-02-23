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
 * Immutable Float%TypeRel% Matrix.
 * <p>
 * Copyright (c) 2013-2024 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%TypeRel%Matrix extends FloatMatrixRelWithAbs<%TypeAbsUnit%, Float%TypeAbs%, Float%TypeAbs%Vector, Float%TypeAbs%Matrix,
%TypeRelUnit%, Float%TypeRel%, Float%TypeRel%Vector, Float%TypeRel%Matrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;
    
    /**
     * Construct a Float%TypeRel%Matrix from an internal data object.
     * @param data FloatMatrixData; the internal data object for the matrix
     * @param displayUnit %TypeRel%Unit; the display unit of the matrix data
     */
    public Float%TypeRel%Matrix(final FloatMatrixData data, final %TypeRel%Unit displayUnit)
    {
        super(data, displayUnit);
    }

    /* CONSTRUCTORS WITH float[][] */

    /**
     * Construct a Float%TypeRel%Matrix from a float[][] object. The float values are expressed in the displayUnit, and will be printed
     * using the displayUnit.
     * @param data float[][]; the data for the matrix, expressed in the displayUnit
     * @param displayUnit %TypeRel%Unit; the unit of the values in the data array, and display unit when printing
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeRel%Matrix(final float[][] data, final %TypeRel%Unit displayUnit, final StorageType storageType)
    {
        this(FloatMatrixData.instantiate(data, displayUnit.getScale(), storageType), displayUnit);
    }

    /**
     * Construct a Float%TypeRel%Matrix from a float[][] object. The float values are expressed in the displayUnit. Assume that the
     * StorageType is DENSE since we offer the data as an array of an array.
     * @param data float[][]; the data for the matrix
     * @param displayUnit %TypeRel%Unit; the unit of the values in the data array, and display unit when printing
     */
    public Float%TypeRel%Matrix(final float[][] data, final %TypeRel%Unit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a Float%TypeRel%Matrix from a float[][] object with SI-unit values.
     * @param data float[][]; the data for the matrix, in SI units
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeRel%Matrix(final float[][] data, final StorageType storageType)
    {
        this(data, %TypeRel%Unit.SI, storageType);
    }

    /**
     * Construct a Float%TypeRel%Matrix from a float[][] object with SI-unit values. Assume that the StorageType is DENSE since we offer
     * the data as an array of an array.
     * @param data float[][]; the data for the matrix, in SI units
     */
    public Float%TypeRel%Matrix(final float[][] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH Float%TypeRel%[][] */

    /**
     * Construct a Float%TypeRel%Matrix from an array of an array of Float%TypeRel% objects. The Float%TypeRel% values are each expressed in their own unit,
     * but will be internally stored as SI values, all expressed in the displayUnit when printing.
     * @param data Float%TypeRel%[][]; the data for the matrix
     * @param displayUnit %TypeRel%Unit; the display unit of the values when printing
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeRel%Matrix(final Float%TypeRel%[][] data, final %TypeRel%Unit displayUnit, final StorageType storageType)
    {
        this(FloatMatrixData.instantiate(data, storageType), displayUnit);
    }

    /**
     * Construct a Float%TypeRel%Matrix from an array of an array of Float%TypeRel% objects. The Float%TypeRel% values are each expressed in their own unit,
     * but will be internally stored as SI values, all expressed in the displayUnit when printing. Assume that the StorageType
     * is DENSE since we offer the data as an array of an array.
     * @param data Float%TypeRel%[][]; the data for the matrix
     * @param displayUnit %TypeRel%Unit; the display unit of the values when printing
     */
    public Float%TypeRel%Matrix(final Float%TypeRel%[][] data, final %TypeRel%Unit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a Float%TypeRel%Matrix from an array of an array of Float%TypeRel% objects. The Float%TypeRel% values are each expressed in their own unit,
     * but will be internally stored as SI values, and expressed using SI units when printing. since we offer the data as an
     * array of an array.
     * @param data Float%TypeRel%[][]; the data for the matrix
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeRel%Matrix(final Float%TypeRel%[][] data, final StorageType storageType)
    {
        this(data, %TypeRel%Unit.SI, storageType);
    }

    /**
     * Construct a Float%TypeRel%Matrix from an array of an array of Float%TypeRel% objects. The Float%TypeRel% values are each expressed in their own unit,
     * but will be internally stored as SI values, and expressed using SI units when printing. Assume that the StorageType is
     * DENSE since we offer the data as an array of an array.
     * @param data Float%TypeRel%[][]; the data for the matrix
     */
    public Float%TypeRel%Matrix(final Float%TypeRel%[][] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH Collection<FloatSparseValue> */

    /**
     * Construct a Float%TypeRel%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed.
     * @param data Collection&lt;FloatSparseValue&gt;; the data for the matrix
     * @param displayUnit %TypeRel%Unit; the display unit of the matrix data, and the unit of the data points
     * @param rows int; the number of rows of the matrix
     * @param cols int; the number of columns of the matrix
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeRel%Matrix(final Collection<FloatSparseValue<%TypeRel%Unit, Float%TypeRel%>> data, final %TypeRel%Unit displayUnit, final int rows,
            final int cols, final StorageType storageType)
    {
        this(FloatMatrixData.instantiate(data, rows, cols, storageType), displayUnit);
    }

    /**
     * Construct a Float%TypeRel%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Assume the storage
     * type is SPARSE, since we offer the data as a collection.
     * @param data Collection&lt;FloatSparseValue&gt;; the data for the matrix
     * @param displayUnit %TypeRel%Unit; the display unit of the matrix data, and the unit of the data points
     * @param rows int; the number of rows of the matrix
     * @param cols int; the number of columns of the matrix
     */
    public Float%TypeRel%Matrix(final Collection<FloatSparseValue<%TypeRel%Unit, Float%TypeRel%>> data, final %TypeRel%Unit displayUnit, final int rows,
            final int cols)
    {
        this(data, displayUnit, rows, cols, StorageType.SPARSE);
    }

    /**
     * Construct a Float%TypeRel%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Use the SI unit or
     * base unit as the displayUnit.
     * @param data Collection&lt;FloatSparseValue&gt;; the data for the matrix
     * @param rows int; the number of rows of the matrix
     * @param cols int; the number of columns of the matrix
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public Float%TypeRel%Matrix(final Collection<FloatSparseValue<%TypeRel%Unit, Float%TypeRel%>> data, final int rows, final int cols,
            final StorageType storageType)
    {
        this(data, %TypeRel%Unit.SI, rows, cols, storageType);
    }

    /**
     * Construct a Float%TypeRel%Matrix from a (sparse) collection of FloatSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Use the SI unit or
     * base unit as the displayUnit. Assume the storage type is SPARSE, since we offer the data as a collection.
     * @param data Collection&lt;FloatSparseValue&gt;; the data for the matrix
     * @param rows int; the number of rows of the matrix
     * @param cols int; the number of columns of the matrix
     */
    public Float%TypeRel%Matrix(final Collection<FloatSparseValue<%TypeRel%Unit, Float%TypeRel%>> data, final int rows, final int cols)
    {
        this(data, %TypeRel%Unit.SI, rows, cols, StorageType.SPARSE);
    }
    
    /** {@inheritDoc} */
    @Override
    public Class<Float%TypeRel%> getScalarClass()
    {
        return Float%TypeRel%.class;
    }
    
    /** {@inheritDoc} */
    @Override
    public Class<Float%TypeRel%Vector> getVectorClass()
    {
        return Float%TypeRel%Vector.class;
    }
        
    /** {@inheritDoc} */
    @Override
    public Float%TypeRel%Matrix instantiateMatrix(final FloatMatrixData fmd, final %TypeRelUnit% displayUnit)
    {
        return new Float%TypeRel%Matrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Float%TypeRel%Vector instantiateVector(final FloatVectorData fvd, final %TypeRelUnit% displayUnit)
    {
        return new Float%TypeRel%Vector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Float%TypeRel% instantiateScalarSI(final float valueSI, final %TypeRelUnit% displayUnit)
    {
        Float%TypeRel% result = Float%TypeRel%.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Float%TypeAbs%Matrix instantiateMatrixAbs(final FloatMatrixData fmd, final %TypeAbsUnit% displayUnit)
    {
        return new Float%TypeAbs%Matrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Float%TypeAbs%Vector instantiateVectorAbs(final FloatVectorData fvd, final %TypeAbsUnit% displayUnit)
    {
        return new Float%TypeAbs%Vector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Float%TypeAbs% instantiateScalarAbsSI(final float valueSI, final %TypeAbsUnit% displayUnit)
    {
        Float%TypeAbs% result = Float%TypeAbs%.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

    %FORMULAS%%TypeRel%%
}
