package org.java0.measurement.unit;

import org.java0.measurement.quantity.Numeric;

public interface NumericUnit extends BaseUnit<Numeric> {

    <T extends BaseUnit<?>> T multiply(T unit);
}
