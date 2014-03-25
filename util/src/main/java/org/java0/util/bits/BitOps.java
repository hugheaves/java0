/*
 * Copyright (C) 2014  Hugh Eaves
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
 * Contains various low level bit manipulation operations.
 *
 * @author Hugh Eaves
 *
 */
public final class BitOps {
    /**
     * "Full" mask for a byte sized value.
     */
    private static final int BYTE_MASK = Masks.LOW_ORDER_BYTE_MASK[Byte.SIZE];

    /**
     * Private constructor.
     *
     */
    private BitOps() {
    }

    /**
     * Unsigned left shift of a byte. Handles negative shift values.
     *
     * @param val
     *            Value to shift
     * @param shift
     *            Number of bits to shift
     *
     * @return The shifted value
     */
    public static byte lshift(final byte val, final int shift) {
        if (shift > 0) {
            return (byte) (val << shift);
        } else {
            return (byte) ((val & BYTE_MASK) >>> shift);
        }
    }

    /**
     * Unsigned right shift of a byte. Handles negative shift values.
     *
     * @param val
     *            Value to shift
     * @param shift
     *            Number of bits to shift
     *
     * @return The shifted value
     */
    public static byte rshift(final byte val, final int shift) {
        if (shift > 0) {
            return (byte) ((val & BYTE_MASK) >>> shift);
        } else {
            return (byte) (val << shift);
        }
    }
}
