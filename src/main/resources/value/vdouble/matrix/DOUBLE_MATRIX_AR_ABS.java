package org.djunits.value.vdouble.matrix;

import java.util.Collection;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.value.storage.StorageType;
import org.djunits.value.vdouble.matrix.base.DoubleMatrixRelWithAbs;
import org.djunits.value.vdouble.matrix.base.DoubleMatrixAbs;
import org.djunits.value.vdouble.matrix.base.DoubleSparseValue;
import org.djunits.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits.value.vdouble.vector.*;
import org.djunits.value.vdouble.vector.data.DoubleVectorData;
import org.djunits.value.vdouble.scalar.*;

/**
 * Immutable %TypeAbs% Matrix.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class %TypeAbs%Matrix extends DoubleMatrixAbs<%TypeAbsUnit%, %TypeAbs%, %TypeAbs%Vector, %TypeAbs%Matrix,
    %TypeRelUnit%, %TypeRel%, %TypeRel%Vector, %TypeRel%Matrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a %TypeAbs%Matrix from an internal data object.
     * @param data the internal data object for the matrix
     * @param displayUnit the display unit of the matrix data
     */
    public %TypeAbs%Matrix(final DoubleMatrixData data, final %TypeAbsUnit% displayUnit)
    {
        super(data, displayUnit);
    }

    /* CONSTRUCTORS WITH double[][] */

    /**
     * Construct a %TypeAbs%Matrix from a double[][] object. The double values are expressed in the displayUnit, and will be printed
     * using the displayUnit.
     * @param data the data for the matrix, expressed in the displayUnit
     * @param displayUnit the unit of the values in the data array, and display unit when printing
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %TypeAbs%Matrix(final double[][] data, final %TypeAbsUnit% displayUnit, final StorageType storageType)
    {
        this(DoubleMatrixData.instantiate(data, displayUnit.getScale(), storageType), displayUnit);
    }

    /**
     * Construct a %TypeAbs%Matrix from a double[][] object. The double values are expressed in the displayUnit. Assume that the
     * StorageType is DENSE since we offer the data as an array of an array.
     * @param data the data for the matrix
     * @param displayUnit the unit of the values in the data array, and display unit when printing
     */
    public %TypeAbs%Matrix(final double[][] data, final %TypeAbsUnit% displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a %TypeAbs%Matrix from a double[][] object with SI-unit values.
     * @param data the data for the matrix, in SI units
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %TypeAbs%Matrix(final double[][] data, final StorageType storageType)
    {
        this(data, %TypeAbsUnit%.BASE.getStandardUnit(), storageType);
    }

    /**
     * Construct a %TypeAbs%Matrix from a double[][] object with SI-unit values. Assume that the StorageType is DENSE since we offer
     * the data as an array of an array.
     * @param data the data for the matrix, in SI units
     */
    public %TypeAbs%Matrix(final double[][] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH %TypeAbs%[][] */

    /**
     * Construct a %TypeAbs%Matrix from an array of an array of %TypeAbs% objects. The %TypeAbs% values are each expressed in their own unit,
     * but will be internally stored as SI values, all expressed in the displayUnit when printing.
     * @param data the data for the matrix
     * @param displayUnit the display unit of the values when printing
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %TypeAbs%Matrix(final %TypeAbs%[][] data, final %TypeAbsUnit% displayUnit, final StorageType storageType)
    {
        this(DoubleMatrixData.instantiate(data, storageType), displayUnit);
    }

    /**
     * Construct a %TypeAbs%Matrix from an array of an array of %TypeAbs% objects. The %TypeAbs% values are each expressed in their own unit,
     * but will be internally stored as SI values, all expressed in the displayUnit when printing. Assume that the StorageType
     * is DENSE since we offer the data as an array of an array.
     * @param data the data for the matrix
     * @param displayUnit the display unit of the values when printing
     */
    public %TypeAbs%Matrix(final %TypeAbs%[][] data, final %TypeAbsUnit% displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a %TypeAbs%Matrix from an array of an array of %TypeAbs% objects. The %TypeAbs% values are each expressed in their own unit,
     * but will be internally stored as SI values, and expressed using SI units when printing. since we offer the data as an
     * array of an array.
     * @param data the data for the matrix
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %TypeAbs%Matrix(final %TypeAbs%[][] data, final StorageType storageType)
    {
        this(data, %TypeAbsUnit%.BASE.getStandardUnit(), storageType);
    }

    /**
     * Construct a %TypeAbs%Matrix from an array of an array of %TypeAbs% objects. The %TypeAbs% values are each expressed in their own unit,
     * but will be internally stored as SI values, and expressed using SI units when printing. Assume that the StorageType is
     * DENSE since we offer the data as an array of an array.
     * @param data the data for the matrix
     */
    public %TypeAbs%Matrix(final %TypeAbs%[][] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH Collection<DoubleSparseValue> */

    /**
     * Construct a %TypeAbs%Matrix from a (sparse) collection of DoubleSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed.
     * @param data the data for the matrix
     * @param displayUnit the display unit of the matrix data, and the unit of the data points
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %TypeAbs%Matrix(final Collection<DoubleSparseValue<%TypeAbsUnit%, %TypeAbs%>> data, final %TypeAbsUnit% displayUnit, final int rows,
            final int cols, final StorageType storageType)
    {
        this(DoubleMatrixData.instantiate(data, rows, cols, storageType), displayUnit);
    }

    /**
     * Construct a %TypeAbs%Matrix from a (sparse) collection of DoubleSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Assume the storage
     * type is SPARSE, since we offer the data as a collection.
     * @param data the data for the matrix
     * @param displayUnit the display unit of the matrix data, and the unit of the data points
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     */
    public %TypeAbs%Matrix(final Collection<DoubleSparseValue<%TypeAbsUnit%, %TypeAbs%>> data, final %TypeAbsUnit% displayUnit, final int rows,
            final int cols)
    {
        this(data, displayUnit, rows, cols, StorageType.SPARSE);
    }

    /**
     * Construct a %TypeAbs%Matrix from a (sparse) collection of DoubleSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Use the SI unit or
     * base unit as the displayUnit.
     * @param data the data for the matrix
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Matrix
     */
    public %TypeAbs%Matrix(final Collection<DoubleSparseValue<%TypeAbsUnit%, %TypeAbs%>> data, final int rows, final int cols,
            final StorageType storageType)
    {
        this(data, %TypeAbsUnit%.BASE.getStandardUnit(), rows, cols, storageType);
    }

    /**
     * Construct a %TypeAbs%Matrix from a (sparse) collection of DoubleSparseValue objects. The displayUnit indicates the unit in
     * which the values in the collection are expressed, as well as the unit in which they will be printed. Use the SI unit or
     * base unit as the displayUnit. Assume the storage type is SPARSE, since we offer the data as a collection.
     * @param data the data for the matrix
     * @param rows the number of rows of the matrix
     * @param cols the number of columns of the matrix
     */
    public %TypeAbs%Matrix(final Collection<DoubleSparseValue<%TypeAbsUnit%, %TypeAbs%>> data, final int rows, final int cols)
    {
        this(data, %TypeAbsUnit%.BASE.getStandardUnit(), rows, cols, StorageType.SPARSE);
    }

    @Override
    public Class<%TypeAbs%> getScalarClass()
    {
        return %TypeAbs%.class;
    }

    @Override
    public Class<%TypeAbs%Vector> getVectorClass()
    {
        return %TypeAbs%Vector.class;
    }

    @Override
    public %TypeAbs%Matrix instantiateMatrix(final DoubleMatrixData dmd, final %TypeAbsUnit% displayUnit)
    {
        return new %TypeAbs%Matrix(dmd, displayUnit);
    }

    @Override
    public %TypeAbs%Vector instantiateVector(final DoubleVectorData dvd, final %TypeAbsUnit% displayUnit)
    {
        return new %TypeAbs%Vector(dvd, displayUnit);
    }

    @Override
    public %TypeAbs% instantiateScalarSI(final double valueSI, final %TypeAbsUnit% displayUnit)
    {
        %TypeAbs% result = %TypeAbs%.ofSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

    @Override
    public %TypeRel%Matrix instantiateMatrixRel(final DoubleMatrixData dmd, final %TypeRelUnit% displayUnit)
    {
        return new %TypeRel%Matrix(dmd, displayUnit);
    }

    @Override
    public %TypeRel%Vector instantiateVectorRel(final DoubleVectorData dvd, final %TypeRelUnit% displayUnit)
    {
        return new %TypeRel%Vector(dvd, displayUnit);
    }

    @Override
    public %TypeRel% instantiateScalarRelSI(final double valueSI, final %TypeRelUnit% displayUnit)
    {
        %TypeRel% result = %TypeRel%.ofSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

%FORMULAS%%TypeAbs%%
}
