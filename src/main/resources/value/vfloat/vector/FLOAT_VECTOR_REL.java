package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import jakarta.annotation.Generated;

import org.djunits.unit.*;
import org.djunits.value.function.DimensionlessFunctions;
import org.djunits.value.vfloat.function.FloatMathFunctions;
import org.djunits.value.vfloat.scalar.*;
import org.djunits.value.vfloat.vector.data.FloatVectorData;
import org.djunits.value.vfloat.vector.base.*;

/**
 * Immutable Float Float%Type%Vector, a vector of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2022 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Float%Type%Vector extends AbstractFloatVectorRel<%Type%Unit, Float%Type%, Float%Type%Vector>
%DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an Float%Type%Vector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit %Type%Unit; the unit
     */
    public Float%Type%Vector(final FloatVectorData data, final %Type%Unit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Float%Type%> getScalarClass()
    {
        return Float%Type%.class;
    }
        
    /** {@inheritDoc} */
    @Override
    public Float%Type%Vector instantiateVector(final FloatVectorData fvd, final %Type%Unit displayUnit)
    {
        return new Float%Type%Vector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Float%Type% instantiateScalarSI(final float valueSI, final %Type%Unit displayUnit)
    {
        Float%Type% result = Float%Type%.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

    %FORMULAS%%Type%%
}


