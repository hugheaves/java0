package org.java0.measurement.impl.unit;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.Units;
import org.java0.measurement.quantity.Power;
import org.java0.measurement.unit.PowerUnit;

public class PowerUnitImpl extends AbstractBaseUnit<Power> implements PowerUnit {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(PowerUnitImpl.class);

    public PowerUnitImpl(final String symbol, final String name) {
        super(symbol, name);
    }

    public PowerUnitImpl(final String symbol, final String name, final Number factor) {
        super(symbol, name, factor);
    }

    @Override
    public PowerUnit getSystemUnit() {
        return Units.WATTS;
    }

}
