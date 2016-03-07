package org.java0.collection.bijection;

public interface IntegerByteBijection extends Bijection<Integer, Byte> {
    byte get(int value);

    int inverseGet(byte value);

    void put(int value1, byte value2);

    void inversePut(byte value1, int value2);

    @Override
    ByteIntegerBijection inverse();
}
