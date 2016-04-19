package org.java0.measurement.quantity;

public interface Area extends Quantity<Area> {
    Length divide(Length length);

    Volume multiply(Length volume);
}
