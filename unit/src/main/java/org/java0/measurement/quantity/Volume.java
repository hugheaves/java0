package org.java0.measurement.quantity;

public interface Volume extends Quantity<Volume> {
    Area divide(Length length);
}
