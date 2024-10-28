    @Override
    public String toStringSIPrefixed(final int smallestPower, final int biggestPower)
    {
        return toString();
    }
    
    @Override
    public final FloatDimensionless acos()
    {
        return instantiateRel((float) Math.acos(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless asin()
    {
        return instantiateRel((float) Math.asin(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless atan()
    {
        return instantiateRel((float) Math.atan(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless cbrt()
    {
        return instantiateRel((float) Math.cbrt(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless cos()
    {
        return instantiateRel((float) Math.cos(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless cosh()
    {
        return instantiateRel((float) Math.cosh(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless exp()
    {
        return instantiateRel((float) Math.exp(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless expm1()
    {
        return instantiateRel((float) Math.expm1(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless log()
    {
        return instantiateRel((float) Math.log(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless log10()
    {
        return instantiateRel((float) Math.log10(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless log1p()
    {
        return instantiateRel((float) Math.log1p(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless pow(final double x)
    {
        return instantiateRel((float) Math.pow(getInUnit(), x), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless signum()
    {
        return instantiateRel(Math.signum(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless sin()
    {
        return instantiateRel((float) Math.sin(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless sinh()
    {
        return instantiateRel((float) Math.sinh(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless sqrt()
    {
        return instantiateRel((float) Math.sqrt(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless tan()
    {
        return instantiateRel((float) Math.tan(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless tanh()
    {
        return instantiateRel((float) Math.tanh(getInUnit()), getDisplayUnit());
    }

    @Override
    public final FloatDimensionless inv()
    {
        return instantiateRel(1.0f / getInUnit(), getDisplayUnit());
    }
