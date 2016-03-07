package org.java0.collection.bijection;

public interface ByteByteBijection extends Bijection<Byte, Byte> {
    byte get(byte value);

    byte inverseGet(byte value);

    void put(byte value1, byte value2);

    void inversePut(byte value1, byte value2);

    @Override
    ByteByteBijection inverse();

}
