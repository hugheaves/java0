package org.java0.measurement.impl.unit;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.Units;
import org.java0.measurement.quantity.Time;
import org.java0.measurement.unit.TimeUnit;

public class TimeUnitImpl extends AbstractBaseUnit<Time> implements TimeUnit {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(TimeUnitImpl.class);

    final java.util.concurrent.TimeUnit javaTimeUnit;

    public TimeUnitImpl(final String symbol, final String name, final java.util.concurrent.TimeUnit javaTimeUnit) {
        super(symbol, name);
        this.javaTimeUnit = javaTimeUnit;
    }

    public TimeUnitImpl(final String symbol, final String name, final java.util.concurrent.TimeUnit javaTimeUnit,
            final Number factor) {
        super(symbol, name, factor);
        this.javaTimeUnit = javaTimeUnit;
    }

    @Override
    public TimeUnit getSystemUnit() {
        return Units.SECONDS;
    }

    @Override
    public java.util.concurrent.TimeUnit convertFromTimeUnit() {
        return javaTimeUnit;
    }

}
