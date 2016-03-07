package org.java0.collection.bijection;

public interface Bijection<T1, T2> {
    T2 get(T1 value);

    T1 inverseGet(T2 value);

    void put(T1 value1, T2 value2);

    void inversePut(T1 value1, T2 value2);

    Bijection<T2, T1> inverse();
}
