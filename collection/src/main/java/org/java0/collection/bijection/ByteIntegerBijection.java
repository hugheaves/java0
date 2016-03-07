package org.java0.collection.bijection;

public interface ByteIntegerBijection extends Bijection<Byte, Integer> {
    int get(byte value);

    byte inverseGet(int value);

    void put(byte value1, int value2);

    void inversePut(int value1, byte value2);

    @Override
    IntegerByteBijection inverse();
}
