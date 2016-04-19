package org.java0.measurement.unit;

import org.java0.measurement.quantity.Quantity;

public interface BaseUnit<T extends Quantity<?>> extends Unit {

    /**
     * Returns the system unit compatible with this Unit.
     *
     * @return the system unit compatible with this Unit.
     */
    @Override
    public BaseUnit<T> getSystemUnit();

}
