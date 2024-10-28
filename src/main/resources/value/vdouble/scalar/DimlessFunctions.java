    @Override
    public String toStringSIPrefixed(final int smallestPower, final int biggestPower)
    {
        return toString();
    }
    
    @Override
    public final Dimensionless acos()
    {
        return instantiateRel(Math.acos(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless asin()
    {
        return instantiateRel(Math.asin(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless atan()
    {
        return instantiateRel(Math.atan(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless cbrt()
    {
        return instantiateRel(Math.cbrt(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless cos()
    {
        return instantiateRel(Math.cos(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless cosh()
    {
        return instantiateRel(Math.cosh(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless exp()
    {
        return instantiateRel(Math.exp(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless expm1()
    {
        return instantiateRel(Math.expm1(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless log()
    {
        return instantiateRel(Math.log(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless log10()
    {
        return instantiateRel(Math.log10(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless log1p()
    {
        return instantiateRel(Math.log1p(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless pow(final double x)
    {
        return instantiateRel(Math.pow(getInUnit(), x), getDisplayUnit());
    }

    @Override
    public final Dimensionless signum()
    {
        return instantiateRel(Math.signum(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless sin()
    {
        return instantiateRel(Math.sin(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless sinh()
    {
        return instantiateRel(Math.sinh(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless sqrt()
    {
        return instantiateRel(Math.sqrt(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless tan()
    {
        return instantiateRel(Math.tan(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless tanh()
    {
        return instantiateRel(Math.tanh(getInUnit()), getDisplayUnit());
    }

    @Override
    public final Dimensionless inv()
    {
        return instantiateRel(1.0 / getInUnit(), getDisplayUnit());
    }
