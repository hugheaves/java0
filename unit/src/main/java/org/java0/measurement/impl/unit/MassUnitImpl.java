package org.java0.measurement.impl.unit;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.Units;
import org.java0.measurement.quantity.Mass;
import org.java0.measurement.unit.MassUnit;

public class MassUnitImpl extends AbstractBaseUnit<Mass> implements MassUnit {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(MassUnitImpl.class);

    public MassUnitImpl(final String symbol, final String name) {
        super(symbol, name);
    }

    public MassUnitImpl(final String symbol, final String name, final Number factor) {
        super(symbol, name, factor);
    }

    @Override
    public MassUnit getSystemUnit() {
        return Units.KILOGRAMS;
    }

}
