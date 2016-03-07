package org.java0.collection.bijection;

public interface ByteObjectBijection<T> extends Bijection<Byte, T> {
    T get(byte value);

    byte inverseGetByte(T value);

    void put(byte value1, T value2);

    void inversePut(T value1, byte value2);

    @Override
    ObjectByteBijection<T> inverse();
}
