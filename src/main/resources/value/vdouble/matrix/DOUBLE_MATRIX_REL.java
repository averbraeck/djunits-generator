package org.djunits.value.vdouble.matrix;

import java.util.Collection;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.value.function.DimensionlessFunctions;
import org.djunits.value.storage.StorageType;
import org.djunits.value.vdouble.function.DoubleMathFunctions;
import org.djunits.value.vdouble.matrix.base.DoubleMatrixRel;
import org.djunits.value.vdouble.matrix.base.DoubleSparseValue;
import org.djunits.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits.value.vdouble.vector.*;
import org.djunits.value.vdouble.vector.data.DoubleVectorData;
import org.djunits.value.vdouble.scalar.*;


/**
 * Immutable Double %Type%Matrix, a matrix of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2024 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class %Type%Matrix extends DoubleMatrixRel<%Type%Unit, %Type%, %Type%Vector, %Type%Matrix>
%DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a %Type%Matrix from an internal data object.
     * @param data DoubleMatrixData; the internal data object for the matrix
     * @param displayUnit %Type%Unit; the display unit of the matrix data
     */
    public %Type%Matrix(final DoubleMatrixData data, final %Type%Unit displayUnit)
    {
        super(data, displayUnit);
    }

    /* CONSTRUCTORS WITH double[][] */

    /**
     * Construct a %Type%Matrix from a double[][] object. The double values are expressed in the displayUnit, and will be printed
     * using the displayUnit.
     * @param data double[][]; the data for the matrix, expressed in the displayUnit
     * @param displayUnit %Type%Unit; the unit of the values in the data array, and display unit when printing
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %Type%Matrix(final double[][] data, final %Type%Unit displayUnit, final StorageType storageType)
    {
        this(DoubleMatrixData.instantiate(data, displayUnit.getScale(), storageType), displayUnit);
    }

    /**
     * Construct a %Type%Matrix from a double[][] object. The double values are expressed in the displayUnit. Assume that the
     * StorageType is DENSE since we offer the data as an array of an array.
     * @param data double[][]; the data for the matrix
     * @param displayUnit %Type%Unit; the unit of the values in the data array, and display unit when printing
     */
    public %Type%Matrix(final double[][] data, final %Type%Unit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a %Type%Matrix from a double[][] object with SI-unit values.
     * @param data double[][]; the data for the matrix, in SI units
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %Type%Matrix(final double[][] data, final StorageType storageType)
    {
        this(data, %Type%Unit.SI, storageType);
    }

    /**
     * Construct a %Type%Matrix from a double[][] object with SI-unit values. Assume that the StorageType is DENSE since we offer
     * the data as an array of an array.
     * @param data double[][]; the data for the matrix, in SI units
     */
    public %Type%Matrix(final double[][] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH %Type%[][] */

    /**
     * Construct a %Type%Matrix from an array of an array of %Type% objects. The %Type% values are each expressed in their own unit,
     * but will be internally stored as SI values, all expressed in the displayUnit when printing.
     * @param data %Type%[][]; the data for the matrix
     * @param displayUnit %Type%Unit; the display unit of the values when printing
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %Type%Matrix(final %Type%[][] data, final %Type%Unit displayUnit, final StorageType storageType)
    {
        this(DoubleMatrixData.instantiate(data, storageType), displayUnit);
    }

    /**
     * Construct a %Type%Matrix from an array of an array of %Type% objects. The %Type% values are each expressed in their own unit,
     * but will be internally stored as SI values, all expressed in the displayUnit when printing. Assume that the StorageType
     * is DENSE since we offer the data as an array of an array.
     * @param data %Type%[][]; the data for the matrix
     * @param displayUnit %Type%Unit; the display unit of the values when printing
     */
    public %Type%Matrix(final %Type%[][] data, final %Type%Unit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a %Type%Matrix from an array of an array of %Type% objects. The %Type% values are each expressed in their own unit,
     * but will be internally stored as SI values, and expressed using SI units when printing. since we offer the data as an
     * array of an array.
     * @param data %Type%[][]; the data for the matrix
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %Type%Matrix(final %Type%[][] data, final StorageType storageType)
    {
        this(data, %Type%Unit.SI, storageType);
    }

    /**
     * Construct a %Type%Matrix from an array of an array of %Type% objects. The %Type% values are each expressed in their own unit,
     * but will be internally stored as SI values, and expressed using SI units when printing. Assume that the StorageType is
     * DENSE since we offer the data as an array of an array.
     * @param data %Type%[][]; the data for the matrix
     */
    public %Type%Matrix(final %Type%[][] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH Collection<DoubleSparseValue> */

    /**
     * Construct a %Type%Matrix from a (sparse) collection of DoubleSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed.
     * @param data Collection&lt;DoubleSparseValue&gt;; the data for the matrix
     * @param displayUnit %Type%Unit; the display unit of the matrix data, and the unit of the data points
     * @param rows int; the number of rows of the matrix
     * @param cols int; the number of columns of the matrix
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %Type%Matrix(final Collection<DoubleSparseValue<%Type%Unit, %Type%>> data, final %Type%Unit displayUnit, final int rows,
            final int cols, final StorageType storageType)
    {
        this(DoubleMatrixData.instantiate(data, rows, cols, storageType), displayUnit);
    }

    /**
     * Construct a %Type%Matrix from a (sparse) collection of DoubleSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Assume the storage
     * type is SPARSE, since we offer the data as a collection.
     * @param data Collection&lt;DoubleSparseValue&gt;; the data for the matrix
     * @param displayUnit %Type%Unit; the display unit of the matrix data, and the unit of the data points
     * @param rows int; the number of rows of the matrix
     * @param cols int; the number of columns of the matrix
     */
    public %Type%Matrix(final Collection<DoubleSparseValue<%Type%Unit, %Type%>> data, final %Type%Unit displayUnit, final int rows,
            final int cols)
    {
        this(data, displayUnit, rows, cols, StorageType.SPARSE);
    }

    /**
     * Construct a %Type%Matrix from a (sparse) collection of DoubleSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Use the SI unit or
     * base unit as the displayUnit.
     * @param data Collection&lt;DoubleSparseValue&gt;; the data for the matrix
     * @param rows int; the number of rows of the matrix
     * @param cols int; the number of columns of the matrix
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %Type%Matrix(final Collection<DoubleSparseValue<%Type%Unit, %Type%>> data, final int rows, final int cols,
            final StorageType storageType)
    {
        this(data, %Type%Unit.SI, rows, cols, storageType);
    }

    /**
     * Construct a %Type%Matrix from a (sparse) collection of DoubleSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Use the SI unit or
     * base unit as the displayUnit. Assume the storage type is SPARSE, since we offer the data as a collection.
     * @param data Collection&lt;DoubleSparseValue&gt;; the data for the matrix
     * @param rows int; the number of rows of the matrix
     * @param cols int; the number of columns of the matrix
     */
    public %Type%Matrix(final Collection<DoubleSparseValue<%Type%Unit, %Type%>> data, final int rows, final int cols)
    {
        this(data, %Type%Unit.SI, rows, cols, StorageType.SPARSE);
    }

    @Override
    public Class<%Type%> getScalarClass()
    {
        return %Type%.class;
    }

    @Override
    public Class<%Type%Vector> getVectorClass()
    {
        return %Type%Vector.class;
    }

    @Override
    public %Type%Matrix instantiateMatrix(final DoubleMatrixData dmd, final %Type%Unit displayUnit)
    {
        return new %Type%Matrix(dmd, displayUnit);
    }

    @Override
    public %Type%Vector instantiateVector(final DoubleVectorData dvd, final %Type%Unit displayUnit)
    {
        return new %Type%Vector(dvd, displayUnit);
    }

    @Override
    public %Type% instantiateScalarSI(final double valueSI, final %Type%Unit displayUnit)
    {
        %Type% result = %Type%.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }
    
%FORMULAS%%Type%%
}

