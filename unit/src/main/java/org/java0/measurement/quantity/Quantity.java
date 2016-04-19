package org.java0.measurement.quantity;

public interface Quantity<T extends Quantity<?>> extends QuantityBase {
    // Unit unit();
    //
    Quantity<T> add(Quantity<T> value);

    Quantity<T> subtract(Quantity<T> value);

    <U extends Quantity<?>> QuantityProduct<T, U> multiply(Quantity<U> quantity);

    <U extends Quantity<?>> QuantityQuotient<T, U> divide(Quantity<U> quantity);

}
