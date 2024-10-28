package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.Map;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.unit.scale.IdentityScale;
import org.djunits.value.function.DimensionlessFunctions;
import org.djunits.value.storage.StorageType;
import org.djunits.value.vfloat.function.FloatMathFunctions;
import org.djunits.value.vfloat.scalar.*;
import org.djunits.value.vfloat.vector.data.FloatVectorData;
import org.djunits.value.vfloat.vector.base.*;

/**
 * Immutable Float Float%Type%Vector, a vector of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2024 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%Type%Vector extends FloatVectorRel<%Type%Unit, Float%Type%, Float%Type%Vector>
%DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct a Float%Type%Vector from an internal data object.
     * @param data FloatVectorData; the internal data object for the vector
     * @param displayUnit %Type%Unit; the display unit of the vector data
     */
    public Float%Type%Vector(final FloatVectorData data, final %Type%Unit displayUnit)
    {
        super(data, displayUnit);
    }

    /* CONSTRUCTORS WITH float[] */

    /**
     * Construct a Float%Type%Vector from a float[] object. The Float values are expressed in the displayUnit, and will be
     * printed using the displayUnit.
     * @param data float[]; the data for the vector, expressed in the displayUnit
     * @param displayUnit %Type%Unit; the unit of the values in the data array, and display unit when printing
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public Float%Type%Vector(final float[] data, final %Type%Unit displayUnit, final StorageType storageType)
    {
        this(FloatVectorData.instantiate(data, displayUnit.getScale(), storageType), displayUnit);
    }

    /**
     * Construct a Float%Type%Vector from a float[] object. The Float values are expressed in the displayUnit. Assume that the
     * StorageType is DENSE since we offer the data as an array.
     * @param data float[]; the data for the vector
     * @param displayUnit %Type%Unit; the unit of the values in the data array, and display unit when printing
     */
    public Float%Type%Vector(final float[] data, final %Type%Unit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a Float%Type%Vector from a float[] object with SI-unit values.
     * @param data float[]; the data for the vector, in SI units
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public Float%Type%Vector(final float[] data, final StorageType storageType)
    {
        this(data, %Type%Unit.SI, storageType);
    }

    /**
     * Construct a Float%Type%Vector from a float[] object with SI-unit values. Assume that the StorageType is DENSE since we
     * offer the data as an array.
     * @param data float[]; the data for the vector, in SI units
     */
    public Float%Type%Vector(final float[] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH Float%Type%[] */

    /**
     * Construct a Float%Type%Vector from an array of Float%Type% objects. The Float%Type% values are each expressed in their own
     * unit, but will be internally stored as SI values, all expressed in the displayUnit when printing.
     * @param data Float%Type%[]; the data for the vector
     * @param displayUnit %Type%Unit; the display unit of the values when printing
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public Float%Type%Vector(final Float%Type%[] data, final %Type%Unit displayUnit, final StorageType storageType)
    {
        this(FloatVectorData.instantiate(data, storageType), displayUnit);
    }

    /**
     * Construct a Float%Type%Vector from an array of Float%Type% objects. The Float%Type% values are each expressed in their own
     * unit, but will be internally stored as SI values, all expressed in the displayUnit when printing. Assume that the
     * StorageType is DENSE since we offer the data as an array.
     * @param data Float%Type%[]; the data for the vector
     * @param displayUnit %Type%Unit; the display unit of the values when printing
     */
    public Float%Type%Vector(final Float%Type%[] data, final %Type%Unit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a Float%Type%Vector from an array of Float%Type% objects. The Float%Type% values are each expressed in their own
     * unit, but will be internally stored as SI values, and expressed using SI units when printing. since we offer the data as
     * an array.
     * @param data Float%Type%[]; the data for the vector
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public Float%Type%Vector(final Float%Type%[] data, final StorageType storageType)
    {
        this(data, %Type%Unit.SI, storageType);
    }

    /**
     * Construct a Float%Type%Vector from an array of Float%Type% objects. The Float%Type% values are each expressed in their own
     * unit, but will be internally stored as SI values, and expressed using SI units when printing. Assume that the StorageType
     * is DENSE since we offer the data as an array.
     * @param data Float%Type%[]; the data for the vector
     */
    public Float%Type%Vector(final Float%Type%[] data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH List<Float> or List<%Type%> */

    /**
     * Construct a Float%Type%Vector from a list of Number objects or a list of Float%Type% objects. Note that the displayUnit has
     * a different meaning depending on whether the list contains Number objects (e.g., Float objects) or Float%Type% objects. In
     * case the list contains Number objects, the displayUnit indicates the unit in which the values in the list are expressed,
     * as well as the unit in which they will be printed. In case the list contains Float%Type% objects, each Float%Type% has its
     * own unit, and the displayUnit is just used for printing. The values but will always be internally stored as SI values or
     * base values, and expressed using the display unit or base unit when printing.
     * @param data List&lt;Float&gt; or List&lt;%Type%&gt;; the data for the vector
     * @param displayUnit %Type%Unit; the display unit of the vector data, and the unit of the data points when the data is
     *            expressed as List&lt;Float&gt; or List&lt;Number&gt; in general
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public Float%Type%Vector(final List<? extends Number> data, final %Type%Unit displayUnit, final StorageType storageType)
    {
        this(data.size() == 0 ? FloatVectorData.instantiate(new float[] {}, IdentityScale.SCALE, storageType)
                : data.get(0) instanceof Float%Type% ? FloatVectorData.instantiate(data, IdentityScale.SCALE, storageType)
                        : FloatVectorData.instantiate(data, displayUnit.getScale(), storageType),
                displayUnit);
    }

    /**
     * Construct a Float%Type%Vector from a list of Number objects or a list of Float%Type% objects. Note that the displayUnit has
     * a different meaning depending on whether the list contains Number objects (e.g., Float objects) or Float%Type% objects. In
     * case the list contains Number objects, the displayUnit indicates the unit in which the values in the list are expressed,
     * as well as the unit in which they will be printed. In case the list contains Float%Type% objects, each Float%Type% has its
     * own unit, and the displayUnit is just used for printing. The values but will always be internally stored as SI values or
     * base values, and expressed using the display unit or base unit when printing. Assume the storage type is DENSE since we
     * offer the data as a List.
     * @param data List&lt;Float&gt; or List&lt;%Type%&gt;; the data for the vector
     * @param displayUnit %Type%Unit; the display unit of the vector data, and the unit of the data points when the data is
     *            expressed as List&lt;Float&gt; or List&lt;Number&gt; in general
     */
    public Float%Type%Vector(final List<? extends Number> data, final %Type%Unit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /**
     * Construct a Float%Type%Vector from a list of Number objects or a list of Float%Type% objects. When data contains numbers
     * such as Float, assume that they are expressed using SI units. When the data consists of Float%Type% objects, they each have
     * their own unit, but will be printed using SI units or base units. The values but will always be internally stored as SI
     * values or base values, and expressed using the display unit or base unit when printing.
     * @param data List&lt;Float&gt; or List&lt;%Type%&gt;; the data for the vector
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public Float%Type%Vector(final List<? extends Number> data, final StorageType storageType)
    {
        this(data, %Type%Unit.SI, storageType);
    }

    /**
     * Construct a Float%Type%Vector from a list of Number objects or a list of Float%Type% objects. When data contains numbers
     * such as Float, assume that they are expressed using SI units. When the data consists of Float%Type% objects, they each have
     * their own unit, but will be printed using SI units or base units. The values but will always be internally stored as SI
     * values or base values, and expressed using the display unit or base unit when printing. Assume the storage type is DENSE
     * since we offer the data as a List.
     * @param data List&lt;Float&gt; or List&lt;%Type%&gt;; the data for the vector
     */
    public Float%Type%Vector(final List<? extends Number> data)
    {
        this(data, StorageType.DENSE);
    }

    /* CONSTRUCTORS WITH Map<Integer, Float> or Map<Integer, Float%Type%> */

    /**
     * Construct a Float%Type%Vector from a (sparse) map of index values to Number objects or a (sparse) map of index values to
     * of Float%Type% objects. Using index values is particularly useful for sparse vectors. The size parameter indicates the size
     * of the vector, since the largest index does not have to be part of the map. Note that the displayUnit has a different
     * meaning depending on whether the map contains Number objects (e.g., Float objects) or Float%Type% objects. In case the map
     * contains Number objects, the displayUnit indicates the unit in which the values in the map are expressed, as well as the
     * unit in which they will be printed. In case the map contains Float%Type% objects, each Float%Type% has its own unit, and the
     * displayUnit is just used for printing. The values but will always be internally stored as SI values or base values, and
     * expressed using the display unit or base unit when printing.
     * @param data Map&lt;Integer, Float&gt; or Map&lt;Integer, Float%Type%&gt;; the data for the vector
     * @param size int; the size off the vector, i.e., the highest index
     * @param displayUnit %Type%Unit; the display unit of the vector data, and the unit of the data points when the data is
     *            expressed as List&lt;Float&gt; or List&lt;Number&gt; in general
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public Float%Type%Vector(final Map<Integer, ? extends Number> data, final int size, final %Type%Unit displayUnit,
            final StorageType storageType)
    {
        this(data.size() == 0 ? FloatVectorData.instantiate(data, size, IdentityScale.SCALE, storageType)
                : data.values().iterator().next() instanceof Float%Type%
                        ? FloatVectorData.instantiate(data, size, IdentityScale.SCALE, storageType)
                        : FloatVectorData.instantiate(data, size, displayUnit.getScale(), storageType),
                displayUnit);
    }

    /**
     * Construct a Float%Type%Vector from a (sparse) map of index values to Number objects or a (sparse) map of index values to
     * of Float%Type% objects. Using index values is particularly useful for sparse vectors. The size parameter indicates the size
     * of the vector, since the largest index does not have to be part of the map. Note that the displayUnit has a different
     * meaning depending on whether the map contains Number objects (e.g., Float objects) or Float%Type% objects. In case the map
     * contains Number objects, the displayUnit indicates the unit in which the values in the map are expressed, as well as the
     * unit in which they will be printed. In case the map contains Float%Type% objects, each Float%Type% has its own unit, and the
     * displayUnit is just used for printing. The values but will always be internally stored as SI values or base values, and
     * expressed using the display unit or base unit when printing. Assume the storage type is SPARSE since we offer the data as
     * a Map.
     * @param data Map&lt;Integer, Float&gt; or Map&lt;Integer, Float%Type%&gt;; the data for the vector
     * @param size int; the size off the vector, i.e., the highest index
     * @param displayUnit %Type%Unit; the display unit of the vector data, and the unit of the data points when the data is
     *            expressed as List&lt;Float&gt; or List&lt;Number&gt; in general
     */
    public Float%Type%Vector(final Map<Integer, ? extends Number> data, final int size, final %Type%Unit displayUnit)
    {
        this(data, size, displayUnit, StorageType.SPARSE);
    }

    /**
     * Construct a Float%Type%Vector from a (sparse) map of index values to Number objects or a (sparse) map of index values to
     * of Float%Type% objects. Using index values is particularly useful for sparse vectors. The size parameter indicates the size
     * of the vector, since the largest index does not have to be part of the map. When data contains numbers such as Float,
     * assume that they are expressed using SI units. When the data consists of Float%Type% objects, they each have their own
     * unit, but will be printed using SI units or base units. The values but will always be internally stored as SI values or
     * base values, and expressed using the display unit or base unit when printing.
     * @param data Map&lt;Integer, Float&gt; or Map&lt;Integer, Float%Type%&gt;; the data for the vector
     * @param size int; the size off the vector, i.e., the highest index
     * @param storageType StorageType; the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public Float%Type%Vector(final Map<Integer, ? extends Number> data, final int size, final StorageType storageType)
    {
        this(data, size, %Type%Unit.SI, storageType);
    }

    /**
     * Construct a Float%Type%Vector from a (sparse) map of index values to Number objects or a (sparse) map of index values to
     * of Float%Type% objects. Using index values is particularly useful for sparse vectors. The size parameter indicates the size
     * of the vector, since the largest index does not have to be part of the map. When data contains numbers such as Float,
     * assume that they are expressed using SI units. When the data consists of Float%Type% objects, they each have their own
     * unit, but will be printed using SI units or base units. The values but will always be internally stored as SI values or
     * base values, and expressed using the display unit or base unit when printing. Assume the storage type is SPARSE since we
     * offer the data as a Map.
     * @param data Map&lt;Integer, Float&gt; or Map&lt;Integer, Float%Type%&gt;; the data for the vector
     * @param size int; the size off the vector, i.e., the highest index
     */
    public Float%Type%Vector(final Map<Integer, ? extends Number> data, final int size)
    {
        this(data, size, StorageType.SPARSE);
    }

    /* ****************************** Other methods ****************************** */

    @Override
    public Class<Float%Type%> getScalarClass()
    {
        return Float%Type%.class;
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


