package org.java0.measurement.impl.unit;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.unit.Unit;

public abstract class AbstractUnit implements Unit {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(AbstractUnit.class);

    @Override
    public Unit multiply(final Unit unit) {
        return null;
    }

    @Override
    public Unit divide(final Unit unit) {
        return null;
    }
}
