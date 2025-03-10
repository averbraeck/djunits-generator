package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.Map;

import jakarta.annotation.Generated;

import org.djutils.exceptions.Throw;
import org.djunits.unit.*;
import org.djunits.unit.scale.IdentityScale;
import org.djunits.unit.si.SIDimensions;
import org.djunits.unit.util.UnitRuntimeException;
import org.djunits.value.ValueRuntimeException;
import org.djunits.value.storage.StorageType;
import org.djunits.value.vdouble.scalar.SIScalar;
import org.djunits.value.vfloat.scalar.*;
import org.djunits.value.vfloat.scalar.base.FloatScalarRel;
import org.djunits.value.vfloat.vector.*;
import org.djunits.value.vfloat.vector.base.FloatVectorRel;
import org.djunits.value.vfloat.vector.data.FloatVectorData;

/**
 * Easy access methods for the generic Relative SI FloatVector.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatSIVector extends FloatVectorRel<SIUnit, FloatSIScalar, FloatSIVector>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct a FloatSIVector from an internal data object.
     * @param data the internal data object for the vector
     * @param displayUnit the display unit of the vector data
     */
    public FloatSIVector(final FloatVectorData data, final SIUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /* ****************************** CONSTRUCTORS WITH float[] ****************************** */

    /**
     * Construct a FloatSIVector from a float[] object. The float values are expressed in the displayUnit, and will be printed
     * using the displayUnit.
     * @param data the data for the vector, expressed in the displayUnit
     * @param displayUnit the unit of the values in the data array, and display unit when printing
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public FloatSIVector(final float[] data, final SIUnit displayUnit, final StorageType storageType)
    {
        this(FloatVectorData.instantiate(data, displayUnit.getScale(), storageType), displayUnit);
    }

    /**
     * Construct a FloatSIVector from a float[] object. The float values are expressed in the displayUnit. Assume that the
     * StorageType is DENSE since we offer the data as an array.
     * @param data the data for the vector
     * @param displayUnit the unit of the values in the data array, and display unit when printing
     */
    public FloatSIVector(final float[] data, final SIUnit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /* ****************************** CONSTRUCTORS WITH FloatSIScalar[] ****************************** */

    /**
     * Construct a FloatSIVector from an array of FloatSIScalar objects. The FloatSIScalar values are each expressed in their own unit, but
     * will be internally stored as SI values, all expressed in the displayUnit when printing.
     * @param data the data for the vector
     * @param displayUnit the display unit of the values when printing
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public FloatSIVector(final FloatSIScalar[] data, final SIUnit displayUnit, final StorageType storageType)
    {
        this(FloatVectorData.instantiate(data, storageType), displayUnit);
    }

    /**
     * Construct a FloatSIVector from an array of FloatSIScalar objects. The FloatSIScalar values are each expressed in their own unit, but
     * will be internally stored as SI values, all expressed in the displayUnit when printing. Assume that the StorageType is
     * DENSE since we offer the data as an array.
     * @param data the data for the vector
     * @param displayUnit the display unit of the values when printing
     */
    public FloatSIVector(final FloatSIScalar[] data, final SIUnit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /* ****************************** CONSTRUCTORS WITH List<Float> or List<FloatSIScalar> ****************************** */

    /**
     * Construct a FloatSIVector from a list of Number objects or a list of FloatSIScalar objects. Note that the displayUnit has a
     * different meaning depending on whether the list contains Number objects (e.g., Float objects) or FloatSIScalar objects. In
     * case the list contains Number objects, the displayUnit indicates the unit in which the values in the list are expressed,
     * as well as the unit in which they will be printed. In case the list contains FloatSIScalar objects, each FloatSIScalar has its own
     * unit, and the displayUnit is just used for printing. The values but will always be internally stored as SI values or base
     * values, and expressed using the display unit or base unit when printing.
     * @param data the data for the vector
     * @param displayUnit the display unit of the vector data, and the unit of the data points when the data is
     *            expressed as List&lt;Float&gt; or List&lt;Number&gt; in general
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public FloatSIVector(final List<? extends Number> data, final SIUnit displayUnit, final StorageType storageType)
    {
        this(data.size() == 0 ? FloatVectorData.instantiate(new float[] {}, IdentityScale.SCALE, storageType)
                : data.get(0) instanceof FloatSIScalar ? FloatVectorData.instantiate(data, IdentityScale.SCALE, storageType)
                        : FloatVectorData.instantiate(data, displayUnit.getScale(), storageType),
                displayUnit);
    }

    /**
     * Construct a FloatSIVector from a list of Number objects or a list of FloatSIScalar objects. Note that the displayUnit has a
     * different meaning depending on whether the list contains Number objects (e.g., Float objects) or FloatSIScalar objects. In
     * case the list contains Number objects, the displayUnit indicates the unit in which the values in the list are expressed,
     * as well as the unit in which they will be printed. In case the list contains FloatSIScalar objects, each FloatSIScalar has its own
     * unit, and the displayUnit is just used for printing. The values but will always be internally stored as SI values or base
     * values, and expressed using the display unit or base unit when printing. Assume the storage type is DENSE since we offer
     * the data as a List.
     * @param data the data for the vector
     * @param displayUnit the display unit of the vector data, and the unit of the data points when the data is
     *            expressed as List&lt;Float&gt; or List&lt;Number&gt; in general
     */
    public FloatSIVector(final List<? extends Number> data, final SIUnit displayUnit)
    {
        this(data, displayUnit, StorageType.DENSE);
    }

    /* ******************** CONSTRUCTORS WITH Map<Integer, Float> or Map<Integer, FloatSIScalar> ******************** */

    /**
     * Construct a FloatSIVector from a (sparse) map of index values to Number objects or a (sparse) map of index values to of
     * FloatSIScalar objects. Using index values is particularly useful for sparse vectors. The size parameter indicates the size of
     * the vector, since the largest index does not have to be part of the map. Note that the displayUnit has a different
     * meaning depending on whether the map contains Number objects (e.g., Float objects) or FloatSIScalar objects. In case the map
     * contains Number objects, the displayUnit indicates the unit in which the values in the map are expressed, as well as the
     * unit in which they will be printed. In case the map contains FloatSIScalar objects, each FloatSIScalar has its own unit, and the
     * displayUnit is just used for printing. The values but will always be internally stored as SI values or base values, and
     * expressed using the display unit or base unit when printing.
     * @param data the data for the vector
     * @param size the size off the vector, i.e., the highest index
     * @param displayUnit the display unit of the vector data, and the unit of the data points when the data is
     *            expressed as List&lt;Float&gt; or List&lt;Number&gt; in general
     * @param storageType the StorageType (SPARSE or DENSE) to use for constructing the Vector
     */
    public FloatSIVector(final Map<Integer, ? extends Number> data, final int size, final SIUnit displayUnit,
            final StorageType storageType)
    {
        this(data.size() == 0 ? FloatVectorData.instantiate(data, size, IdentityScale.SCALE, storageType)
                : data.values().iterator().next() instanceof FloatSIScalar
                        ? FloatVectorData.instantiate(data, size, IdentityScale.SCALE, storageType)
                        : FloatVectorData.instantiate(data, size, displayUnit.getScale(), storageType),
                displayUnit);
    }

    /**
     * Construct a FloatSIVector from a (sparse) map of index values to Number objects or a (sparse) map of index values to of
     * FloatSIScalar objects. Using index values is particularly useful for sparse vectors. The size parameter indicates the size of
     * the vector, since the largest index does not have to be part of the map. Note that the displayUnit has a different
     * meaning depending on whether the map contains Number objects (e.g., Float objects) or FloatSIScalar objects. In case the map
     * contains Number objects, the displayUnit indicates the unit in which the values in the map are expressed, as well as the
     * unit in which they will be printed. In case the map contains FloatSIScalar objects, each FloatSIScalar has its own unit, and the
     * displayUnit is just used for printing. The values but will always be internally stored as SI values or base values, and
     * expressed using the display unit or base unit when printing. Assume the storage type is SPARSE since we offer the data as
     * a Map.
     * @param data the data for the vector
     * @param size the size off the vector, i.e., the highest index
     * @param displayUnit the display unit of the vector data, and the unit of the data points when the data is
     *            expressed as List&lt;Float&gt; or List&lt;Number&gt; in general
     */
    public FloatSIVector(final Map<Integer, ? extends Number> data, final int size, final SIUnit displayUnit)
    {
        this(data, size, displayUnit, StorageType.SPARSE);
    }

    /* ****************************** Other methods ****************************** */

    @Override
    public Class<FloatSIScalar> getScalarClass()
    {
        return FloatSIScalar.class;
    }

    /**
     * Returns a FloatSIVector based on an array of values and the textual representation of the unit.
     * @param value the values to use
     * @param unitString the textual representation of the unit
     * @param storageType the storage type to use
     * @return the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIVector of(final float[] value, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(value, "Error parsing FloatSIVector: value is null");
        Throw.whenNull(unitString, "Error parsing FloatSIVector: unitString is null");
        Throw.whenNull(storageType, "Error parsing FloatSIVector: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return new FloatSIVector(value, unit, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing FloatSIVector with unit " + unitString);
    }

    /**
     * Returns a FloatSIVector based on an array of values and the textual representation of the unit.
     * @param valueList the values to use
     * @param unitString the textual representation of the unit
     * @param storageType the storage type to use
     * @return the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIVector of(final List<Float> valueList, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(valueList, "Error parsing FloatSIVector: valueList is null");
        Throw.whenNull(unitString, "Error parsing FloatSIVector: unitString is null");
        Throw.whenNull(storageType, "Error parsing FloatSIVector: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return new FloatSIVector(valueList, unit, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing FloatSIVector with unit " + unitString);
    }

    /**
     * Returns a FloatSIVector based on a (sparse) map of values and the textual representation of the unit.
     * @param valueMap the values to use
     * @param unitString the textual representation of the unit
     * @param length the size of the vector
     * @param storageType the storage type to use
     * @return the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIVector of(final Map<Integer, Float> valueMap, final String unitString, final int length,
            final StorageType storageType)
    {
        Throw.whenNull(valueMap, "Error parsing FloatSIVector: valueMap is null");
        Throw.whenNull(unitString, "Error parsing FloatSIVector: unitString is null");
        Throw.whenNull(storageType, "Error parsing FloatSIVector: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return new FloatSIVector(valueMap, length, unit, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing FloatSIVector with unit " + unitString);
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
