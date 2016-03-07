package org.java0.unsafe;
/*
 * Copyright (C) 2015  Hugh Eaves
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.lang.reflect.Field;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

import sun.misc.Unsafe;

/**
 * Utility to get a reference to the Unsafe class.
 * 
 * @author Hugh Eaves
 *
 */
@SuppressWarnings("restriction")
public class UnsafeUtil {
    private static final Logger logger = LoggerFactory.getLogger(UnsafeUtil.class.getName());

    private static final Unsafe theUnsafe;
    private static final long byteArrayBaseOffset;

    static {
        Unsafe unsafe = null;
        try {
            final Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (final Exception e) {
            logger.error("Unable to retrieve instance of Unsafe class");
        }
        theUnsafe = unsafe;
        byteArrayBaseOffset = theUnsafe.arrayBaseOffset(byte[].class);
    }

    /**
     * Gets a reference to the Unsafe.
     *
     * @return the unsafe
     */
    public static Unsafe get() {
        return theUnsafe;
    }

    /**
     * Copy byte array.
     * 
     * @param src
     * @param srcPos
     * @param dest
     * @param destPos
     * @param length
     */
    public static void arrayCopy(final byte[] src, final int srcPos, final byte[] dest, final int destPos,
            final int length) {
        theUnsafe.copyMemory(src, byteArrayBaseOffset + srcPos, dest, byteArrayBaseOffset + destPos, length);
    }

    /**
     * Make a copy of an existing array, resizing as necessary.
     * 
     * @param original
     * @param newLength
     * @return
     */
    public static byte[] copyOf(final byte[] original, final int newLength) {
        final byte[] copy = new byte[newLength];
        arrayCopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static void copyMemory(final long sourceAddress, final long destinationAddress, final long size) {
        theUnsafe.copyMemory(sourceAddress, destinationAddress, size);
    }

    public static long copyOf(final long sourceAddress, final long sourceLength, final long newLength) {
        final long newAddress = allocateMemory(newLength);
        theUnsafe.copyMemory(sourceAddress, newAddress, Math.min(sourceLength, newLength));
        return newAddress;
    }

    public static long allocateMemory(final long size) {
        final long address = theUnsafe.allocateMemory(size);
        return address;
    }

    public static long allocateAndClearMemory(final long size) {
        final long address = theUnsafe.allocateMemory(size);
        theUnsafe.setMemory(address, size, (byte) 0);
        return address;
    }

    public static void freeMemory(final long address) {
        theUnsafe.freeMemory(address);

    }
}