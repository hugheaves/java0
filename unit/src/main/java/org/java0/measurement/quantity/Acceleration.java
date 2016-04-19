package org.java0.measurement.quantity;

// m / s^2
public interface Acceleration extends Quantity<Acceleration> {
    Speed multiply(Time time);

}
