package org.java0.measurement.impl.unit;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.quantity.Numeric;
import org.java0.measurement.unit.NumericUnit;
import org.java0.measurement.unit.BaseUnit;
import org.java0.measurement.unit.Unit;

public class NumericUnitImpl extends AbstractBaseUnit<Numeric> implements NumericUnit {
    public NumericUnitImpl(final String symbol, final String name, final Number factor) {
        super(symbol, name, factor);

    }

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(NumericUnitImpl.class);

    @Override
    public BaseUnit<?> multiply(final Unit unit) {
        return null;
    }

    @Override
    public BaseUnit<?> divide(final Unit unit) {
        return null;
    }

    @Override
    public BaseUnit<Numeric> getSystemUnit() {
        return null;
    }

    @Override
    public <T extends BaseUnit<?>> T multiply(final T unit) {
        return null;
    }
}
