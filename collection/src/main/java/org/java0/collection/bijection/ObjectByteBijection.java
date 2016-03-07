package org.java0.collection.bijection;

public interface ObjectByteBijection<T> extends Bijection<T, Byte> {
    byte getByte(T value);

    T inverseGetByte(byte value);

    void put(T value1, byte value2);

    void inversePut(byte value1, T value2);

    @Override
    ByteObjectBijection<T> inverse();
}
