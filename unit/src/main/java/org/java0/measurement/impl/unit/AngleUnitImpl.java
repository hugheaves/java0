package org.java0.measurement.impl.unit;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.Units;
import org.java0.measurement.quantity.Angle;
import org.java0.measurement.unit.AngleUnit;
import org.java0.measurement.unit.AngularSpeedUnit;
import org.java0.measurement.unit.TimeUnit;

public class AngleUnitImpl extends AbstractBaseUnit<Angle> implements AngleUnit {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(AngleUnitImpl.class);

    public AngleUnitImpl(final String symbol, final String name) {
        super(symbol, name);
    }

    public AngleUnitImpl(final String symbol, final String name, final Number factor) {
        super(symbol, name, factor);
    }

    @Override
    public AngleUnit getSystemUnit() {
        return Units.RADIANS;
    }

    @Override
    public AngularSpeedUnit divide(final TimeUnit unit) {
        return null;
    }

}
