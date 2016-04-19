package org.java0.measurement.impl.unit;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.Units;
import org.java0.measurement.quantity.Force;
import org.java0.measurement.unit.EnergyUnit;
import org.java0.measurement.unit.ForceUnit;
import org.java0.measurement.unit.LengthUnit;

public class ForceUnitImpl extends AbstractBaseUnit<Force> implements ForceUnit {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ForceUnitImpl.class);

    public ForceUnitImpl(final String symbol, final String name) {
        super(symbol, name);
    }

    public ForceUnitImpl(final String symbol, final String name, final Number factor) {
        super(symbol, name, factor);
    }

    @Override
    public ForceUnit getSystemUnit() {
        return Units.NEWTONS;
    }

    @Override
    public EnergyUnit multiply(final LengthUnit unit) {
        return null;
    }

}
