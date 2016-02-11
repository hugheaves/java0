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
package org.java0.util.bits;

/**
 * <p>
 * Contains a bunch of utility methods to convert numeric types to and from
 * their "bit string" representation. A bit string is a string containing just
 * "0" or "1" characters where each character represents one binary bit.
 *
 * <p>
 * All conversions assume big endian bit / byte ordering. (a.k.a. Network byte
 * order) In this ordering, the earlier characters in the string represent the
 * higher order bits of the values)
 *
 * @author Hugh Eaves
 *
 */
public final class BitStringUtil {
    /**
     * Private constructor.
     *
     */
    private BitStringUtil() {
    }

    /**
     * Convert an array of bytes into their bit string representation.
     *
     * @param array
     *            The array to convert
     * @param numBits
     *            The number of bits to convert from the array.
     * @return The bit string
     */
    public static String toString(final byte[] array, final int numBits) {
        assert (numBits <= array.length * Byte.SIZE);

        final StringBuffer buffer = new StringBuffer(numBits);
        int remainingBits = numBits;

        int byteNum = 0;

        final int firstBits = remainingBits % Byte.SIZE;
        if (firstBits != 0) {
            buffer.append(toString(array[byteNum++], firstBits));
            remainingBits -= firstBits;
        }
        while (remainingBits > 0) {
            buffer.append(toString(array[byteNum++], Byte.SIZE));
            remainingBits -= Byte.SIZE;
        }
        return buffer.toString();
    }

    /**
     * Converts a byte array to its bit string representation.
     *
     * @param array
     *            The array to convert.
     * @return The bit string.
     */
    public static String toString(final byte[] array) {
        return toString(array, array.length * Byte.SIZE);
    }

    public static String toString(final long[] array, final int numBits) {
        assert (numBits <= array.length * Long.SIZE);

        final StringBuffer buffer = new StringBuffer(numBits);
        int remainingBits = numBits;
        final int byteNum = 0;

        final int firstBits = remainingBits % Long.SIZE;
        if (firstBits != 0) {
            buffer.append(toString(array[byteNum], firstBits));
            remainingBits -= firstBits;
        }
        while (remainingBits > 0) {
            buffer.append(toString(array[byteNum], Long.SIZE));
            remainingBits -= Long.SIZE;
        }
        return buffer.toString();
    }

    /**
     * Convert a long value into its bit string representation.
     *
     * @param value
     *            The value to convert
     * @param numBitsToConvert
     *            The number of bits (starting at the low order position) to
     *            convert to a bit string
     * @return The bit string
     */
    public static String toString(final long value, final int numBitsToConvert) {
        assert (numBitsToConvert <= Long.SIZE);

        final StringBuffer buffer = new StringBuffer();

        for (int shift = numBitsToConvert - 1; shift >= 0; --shift) {
            final long shiftedValue = value >>> shift;
            final long bitValue = shiftedValue & 1;
            if (bitValue != 0) {
                buffer.append('1');
            } else {
                buffer.append('0');
            }
        }
        return buffer.toString();
    }

    public static String toString(final long[] array) {
        return toString(array, array.length * Long.SIZE);
    }

    /**
     * Convert an int value into its bit string representation.
     *
     * @param value
     *            The value to convert
     * @param numBitsToConvert
     *            The number of bits (starting at the low order position) to
     *            convert to a bit string
     * @return The bit string
     */
    public static String toString(final int value, final int numBitsToConvert) {
        assert (numBitsToConvert <= Integer.SIZE);

        return toString((long) value, numBitsToConvert);
    }

    /**
     * Convert a short value into its bit string representation.
     *
     * @param value
     *            The value to convert
     * @param numBitsToConvert
     *            The number of bits (starting at the low order position) to
     *            convert to a bit string
     * @return The bit string
     */
    public static String toString(final short value, final int numBitsToConvert) {
        assert (numBitsToConvert <= Short.SIZE);

        return toString((long) value, numBitsToConvert);
    }

    /**
     * Convert a char value into its bit string representation.
     *
     * @param value
     *            The value to convert
     * @param numBitsToConvert
     *            The number of bits (starting at the low order position) to
     *            convert to a bit string
     * @return The bit string
     */
    public static String toString(final char value, final int numBitsToConvert) {
        assert (numBitsToConvert <= Character.SIZE);

        return toString((long) value, numBitsToConvert);
    }

    /**
     * Convert a byte value into its bit string representation.
     *
     * @param value
     *            The value to convert
     * @param numBitsToConvert
     *            The number of bits (starting at the low order position) to
     *            convert to a bit string
     * @return The bit string
     */
    public static String toString(final byte value, final int numBitsToConvert) {
        assert (numBitsToConvert <= Byte.SIZE);

        return toString((long) value, numBitsToConvert);
    }

    /**
     * Convert a bit string into a long value. Any non zero or one characters in
     * the string are ignored.
     *
     * @param bitString
     *            The string to convert.
     * @return The converted value.
     */
    public static long toLong(final String bitString) {
        assert (bitString.length() <= Long.SIZE);

        long value = 0;
        for (final char ch : bitString.toCharArray()) {
            if (ch == '1') {
                value = value << 1;
                value = value | 1;
            } else if (ch == '0') {
                value = value << 1;
            }
        }
        return value;
    }

    /**
     * Convert a bit string into an integer value.
     *
     * @see BitStringUtil#toLong(String)
     *
     * @param bitString
     *            The string to convert.
     * @return The converted value.
     */
    public static int toInteger(final String bitString) {
        assert (bitString.length() <= Integer.SIZE);

        return (int) toLong(bitString);
    }

    /**
     * Convert a bit string into a short value.
     *
     * @see BitStringUtil#toLong(String)
     *
     * @param bitString
     *            The string to convert.
     * @return The converted value.
     */
    public static short toShort(final String bitString) {
        assert (bitString.length() <= Short.SIZE);

        return (short) toLong(bitString);
    }

    /**
     * Convert a bit string into a char value.
     *
     * @see BitStringUtil#toLong(String)
     *
     * @param bitString
     *            The string to convert.
     * @return The converted value.
     */
    public static char toChar(final String bitString) {
        assert (bitString.length() <= Character.SIZE);

        return (char) toLong(bitString);
    }

    /**
     * Convert a bit string into an integer value.
     *
     * @see BitStringUtil#toLong(String)
     *
     * @param bitString
     *            The string to convert.
     * @return The converted value.
     */
    public static byte toByte(final String bitString) {
        assert (bitString.length() <= Byte.SIZE);

        return (byte) toLong(bitString);
    }

    /**
     * Convert a bit string into a byte array.
     *
     * @param bitString
     *            The string to convert.
     * @return The converted value.
     */
    public static byte[] toByteArray(final String bitString) {
        final byte[] array = new byte[(bitString.length() + Byte.SIZE - 1) / Byte.SIZE];

        int byteNum = 0;

        final int firstBits = bitString.length() % Byte.SIZE;
        int pos = 0;

        if (firstBits != 0) {
            array[byteNum++] = toByte(bitString.substring(0, firstBits));
            pos = firstBits;
        }
        while (byteNum < array.length) {
            array[byteNum++] = toByte(bitString.substring(pos, pos + Byte.SIZE));
            pos += Byte.SIZE;
        }

        return array;
    }

    public static String toString(final long value) {
        return toString(value, Long.SIZE);
    }

    public static String toString(final int value) {
        return toString(value, Integer.SIZE);
    }

    public static String toString(final char value) {
        return toString(value, Character.SIZE);
    }

    public static String toString(final byte value) {
        return toString(value, Byte.SIZE);
    }
}
