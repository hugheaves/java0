package org.java0.measurement;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.measurement.quantity.Quantity;
import org.java0.measurement.unit.BaseUnit;

public class QuantityFactory {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(QuantityFactory.class);

    public static <T extends Quantity<T>> T getQuantity(final BaseUnit<T> unit, final Number quantity) {
        return null;
    }
}
