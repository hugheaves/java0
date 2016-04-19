package org.java0.measurement.quantity;

import org.java0.measurement.unit.Unit;

public interface QuantityBase {
    Number value();

    Number value(Unit unit);
}
