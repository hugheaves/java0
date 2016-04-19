package org.java0.measurement.impl.unit;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.Units;
import org.java0.measurement.quantity.Length;
import org.java0.measurement.unit.LengthUnit;
import org.java0.measurement.unit.SpeedUnit;
import org.java0.measurement.unit.TimeUnit;

public class LengthUnitImpl extends AbstractBaseUnit<Length> implements LengthUnit {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(LengthUnitImpl.class);

    public LengthUnitImpl(final String symbol, final String name) {
        super(symbol, name);
    }

    public LengthUnitImpl(final String symbol, final String name, final Number factor) {
        super(symbol, name, factor);
    }

    @Override
    public LengthUnit getSystemUnit() {
        return Units.METERS;
    }

    @Override
    public SpeedUnit divide(final TimeUnit unit) {
        return null;
    }

}
