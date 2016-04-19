package org.java0.measurement.impl.unit;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.Units;
import org.java0.measurement.quantity.Temperature;
import org.java0.measurement.unit.TemperatureUnit;

public class TemperatureUnitImpl extends AbstractBaseUnit<Temperature> implements TemperatureUnit {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(TemperatureUnitImpl.class);

    public TemperatureUnitImpl(final String symbol, final String name) {
        super(symbol, name);
    }

    public TemperatureUnitImpl(final String symbol, final String name, final Number factor, final Number offset) {
        super(symbol, name, factor);
    }

    @Override
    public TemperatureUnit getSystemUnit() {
        return Units.KELVIN;
    }

}
