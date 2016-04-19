package org.java0.measurement.unit;

public interface Unit {

    Unit multiply(Unit unit);

    Unit divide(Unit unit);

    public Unit getSystemUnit();

    default boolean isSystemUnit() {
        return getSystemUnit().equals(this);
    }

    default Number getOffset() {
        return 0d;
    }

    default Number getFactor() {
        return 1d;
    }
}
