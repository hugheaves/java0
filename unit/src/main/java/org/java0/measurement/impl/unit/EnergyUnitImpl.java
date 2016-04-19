package org.java0.measurement.impl.unit;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.Units;
import org.java0.measurement.quantity.Energy;
import org.java0.measurement.unit.EnergyUnit;

public class EnergyUnitImpl extends AbstractBaseUnit<Energy> implements EnergyUnit {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(EnergyUnitImpl.class);

    public EnergyUnitImpl(final String symbol, final String name) {
        super(symbol, name);
    }

    public EnergyUnitImpl(final String symbol, final String name, final Number factor) {
        super(symbol, name, factor);
    }

    @Override
    public EnergyUnit getSystemUnit() {
        return Units.JOULES;
    }

}
