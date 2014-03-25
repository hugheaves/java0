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

import java.io.PrintStream;

/**
 * Contains various bit mask constants.
 *
 * @author Hugh Eaves
 *
 */
public final class Masks {

    /**
     * Private constructor.
     *
     */
    private Masks() {
    }

    /**
     * Mask low order N bits of long
     */
    public static final long[] LOW_ORDER_LONG_MASK = { 0x0000000000000000L,
            0x0000000000000001L, 0x0000000000000003L, 0x0000000000000007L,
            0x000000000000000FL, 0x000000000000001FL, 0x000000000000003FL,
            0x000000000000007FL, 0x00000000000000FFL, 0x00000000000001FFL,
            0x00000000000003FFL, 0x00000000000007FFL, 0x0000000000000FFFL,
            0x0000000000001FFFL, 0x0000000000003FFFL, 0x0000000000007FFFL,
            0x000000000000FFFFL, 0x000000000001FFFFL, 0x000000000003FFFFL,
            0x000000000007FFFFL, 0x00000000000FFFFFL, 0x00000000001FFFFFL,
            0x00000000003FFFFFL, 0x00000000007FFFFFL, 0x0000000000FFFFFFL,
            0x0000000001FFFFFFL, 0x0000000003FFFFFFL, 0x0000000007FFFFFFL,
            0x000000000FFFFFFFL, 0x000000001FFFFFFFL, 0x000000003FFFFFFFL,
            0x000000007FFFFFFFL, 0x00000000FFFFFFFFL, 0x00000001FFFFFFFFL,
            0x00000003FFFFFFFFL, 0x00000007FFFFFFFFL, 0x0000000FFFFFFFFFL,
            0x0000001FFFFFFFFFL, 0x0000003FFFFFFFFFL, 0x0000007FFFFFFFFFL,
            0x000000FFFFFFFFFFL, 0x000001FFFFFFFFFFL, 0x000003FFFFFFFFFFL,
            0x000007FFFFFFFFFFL, 0x00000FFFFFFFFFFFL, 0x00001FFFFFFFFFFFL,
            0x00003FFFFFFFFFFFL, 0x00007FFFFFFFFFFFL, 0x0000FFFFFFFFFFFFL,
            0x0001FFFFFFFFFFFFL, 0x0003FFFFFFFFFFFFL, 0x0007FFFFFFFFFFFFL,
            0x000FFFFFFFFFFFFFL, 0x001FFFFFFFFFFFFFL, 0x003FFFFFFFFFFFFFL,
            0x007FFFFFFFFFFFFFL, 0x00FFFFFFFFFFFFFFL, 0x01FFFFFFFFFFFFFFL,
            0x03FFFFFFFFFFFFFFL, 0x07FFFFFFFFFFFFFFL, 0x0FFFFFFFFFFFFFFFL,
            0x1FFFFFFFFFFFFFFFL, 0x3FFFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFFFL,
            0xFFFFFFFFFFFFFFFFL };

    /**
     * Mask high order N bits of long
     */
    public static final long[] HIGH_ORDER_LONG_MASK = { 0x0000000000000000L,
            0x8000000000000000L, 0xC000000000000000L, 0xE000000000000000L,
            0xF000000000000000L, 0xF800000000000000L, 0xFC00000000000000L,
            0xFE00000000000000L, 0xFF00000000000000L, 0xFF80000000000000L,
            0xFFC0000000000000L, 0xFFE0000000000000L, 0xFFF0000000000000L,
            0xFFF8000000000000L, 0xFFFC000000000000L, 0xFFFE000000000000L,
            0xFFFF000000000000L, 0xFFFF800000000000L, 0xFFFFC00000000000L,
            0xFFFFE00000000000L, 0xFFFFF00000000000L, 0xFFFFF80000000000L,
            0xFFFFFC0000000000L, 0xFFFFFE0000000000L, 0xFFFFFF0000000000L,
            0xFFFFFF8000000000L, 0xFFFFFFC000000000L, 0xFFFFFFE000000000L,
            0xFFFFFFF000000000L, 0xFFFFFFF800000000L, 0xFFFFFFFC00000000L,
            0xFFFFFFFE00000000L, 0xFFFFFFFF00000000L, 0xFFFFFFFF80000000L,
            0xFFFFFFFFC0000000L, 0xFFFFFFFFE0000000L, 0xFFFFFFFFF0000000L,
            0xFFFFFFFFF8000000L, 0xFFFFFFFFFC000000L, 0xFFFFFFFFFE000000L,
            0xFFFFFFFFFF000000L, 0xFFFFFFFFFF800000L, 0xFFFFFFFFFFC00000L,
            0xFFFFFFFFFFE00000L, 0xFFFFFFFFFFF00000L, 0xFFFFFFFFFFF80000L,
            0xFFFFFFFFFFFC0000L, 0xFFFFFFFFFFFE0000L, 0xFFFFFFFFFFFF0000L,
            0xFFFFFFFFFFFF8000L, 0xFFFFFFFFFFFFC000L, 0xFFFFFFFFFFFFE000L,
            0xFFFFFFFFFFFFF000L, 0xFFFFFFFFFFFFF800L, 0xFFFFFFFFFFFFFC00L,
            0xFFFFFFFFFFFFFE00L, 0xFFFFFFFFFFFFFF00L, 0xFFFFFFFFFFFFFF80L,
            0xFFFFFFFFFFFFFFC0L, 0xFFFFFFFFFFFFFFE0L, 0xFFFFFFFFFFFFFFF0L,
            0xFFFFFFFFFFFFFFF8L, 0xFFFFFFFFFFFFFFFCL, 0xFFFFFFFFFFFFFFFEL,
            0xFFFFFFFFFFFFFFFFL };

    /**
     * Mask individual bit of long at bit position N
     */
    public static final long[] SINGLE_BIT_LONG_MASK = { 0x0000000000000001L,
            0x0000000000000002L, 0x0000000000000004L, 0x0000000000000008L,
            0x0000000000000010L, 0x0000000000000020L, 0x0000000000000040L,
            0x0000000000000080L, 0x0000000000000100L, 0x0000000000000200L,
            0x0000000000000400L, 0x0000000000000800L, 0x0000000000001000L,
            0x0000000000002000L, 0x0000000000004000L, 0x0000000000008000L,
            0x0000000000010000L, 0x0000000000020000L, 0x0000000000040000L,
            0x0000000000080000L, 0x0000000000100000L, 0x0000000000200000L,
            0x0000000000400000L, 0x0000000000800000L, 0x0000000001000000L,
            0x0000000002000000L, 0x0000000004000000L, 0x0000000008000000L,
            0x0000000010000000L, 0x0000000020000000L, 0x0000000040000000L,
            0x0000000080000000L, 0x0000000100000000L, 0x0000000200000000L,
            0x0000000400000000L, 0x0000000800000000L, 0x0000001000000000L,
            0x0000002000000000L, 0x0000004000000000L, 0x0000008000000000L,
            0x0000010000000000L, 0x0000020000000000L, 0x0000040000000000L,
            0x0000080000000000L, 0x0000100000000000L, 0x0000200000000000L,
            0x0000400000000000L, 0x0000800000000000L, 0x0001000000000000L,
            0x0002000000000000L, 0x0004000000000000L, 0x0008000000000000L,
            0x0010000000000000L, 0x0020000000000000L, 0x0040000000000000L,
            0x0080000000000000L, 0x0100000000000000L, 0x0200000000000000L,
            0x0400000000000000L, 0x0800000000000000L, 0x1000000000000000L,
            0x2000000000000000L, 0x4000000000000000L, 0x8000000000000000L };

    /**
     * Mask low order N bits of int
     */
    public static final int[] LOW_ORDER_INT_MASK = { 0x00000000, 0x00000001,
            0x00000003, 0x00000007, 0x0000000F, 0x0000001F, 0x0000003F,
            0x0000007F, 0x000000FF, 0x000001FF, 0x000003FF, 0x000007FF,
            0x00000FFF, 0x00001FFF, 0x00003FFF, 0x00007FFF, 0x0000FFFF,
            0x0001FFFF, 0x0003FFFF, 0x0007FFFF, 0x000FFFFF, 0x001FFFFF,
            0x003FFFFF, 0x007FFFFF, 0x00FFFFFF, 0x01FFFFFF, 0x03FFFFFF,
            0x07FFFFFF, 0x0FFFFFFF, 0x1FFFFFFF, 0x3FFFFFFF, 0x7FFFFFFF,
            0xFFFFFFFF };

    /**
     * Mask high order N bits of int
     */
    public static final int[] HIGH_ORDER_INT_MASK = { 0x00000000, 0x80000000,
            0xC0000000, 0xE0000000, 0xF0000000, 0xF8000000, 0xFC000000,
            0xFE000000, 0xFF000000, 0xFF800000, 0xFFC00000, 0xFFE00000,
            0xFFF00000, 0xFFF80000, 0xFFFC0000, 0xFFFE0000, 0xFFFF0000,
            0xFFFF8000, 0xFFFFC000, 0xFFFFE000, 0xFFFFF000, 0xFFFFF800,
            0xFFFFFC00, 0xFFFFFE00, 0xFFFFFF00, 0xFFFFFF80, 0xFFFFFFC0,
            0xFFFFFFE0, 0xFFFFFFF0, 0xFFFFFFF8, 0xFFFFFFFC, 0xFFFFFFFE,
            0xFFFFFFFF };

    /**
     * Mask individual bit of int at bit position N
     */
    public static final int[] SINGLE_BIT_INT_MASK = { 0x00000001, 0x00000002,
            0x00000004, 0x00000008, 0x00000010, 0x00000020, 0x00000040,
            0x00000080, 0x00000100, 0x00000200, 0x00000400, 0x00000800,
            0x00001000, 0x00002000, 0x00004000, 0x00008000, 0x00010000,
            0x00020000, 0x00040000, 0x00080000, 0x00100000, 0x00200000,
            0x00400000, 0x00800000, 0x01000000, 0x02000000, 0x04000000,
            0x08000000, 0x10000000, 0x20000000, 0x40000000, 0x80000000 };

    /**
     * Mask low order N bits of byte
     */
    public static final byte[] LOW_ORDER_BYTE_MASK = { (byte) 0x00,
            (byte) 0x01, (byte) 0x03, (byte) 0x07, (byte) 0x0F, (byte) 0x1F,
            (byte) 0x3F, (byte) 0x7F, (byte) 0xFF };

    /**
     * Mask high order N bits of byte
     */
    public static final byte[] HIGH_ORDER_BYTE_MASK = { (byte) 0x00,
            (byte) 0x80, (byte) 0xC0, (byte) 0xE0, (byte) 0xF0, (byte) 0xF8,
            (byte) 0xFC, (byte) 0xFE, (byte) 0xFF };

    /**
     * Mask individual bit of byte at bit position N
     */
    public static final byte[] SINGLE_BIT_BYTE_MASK = { (byte) 0x01,
            (byte) 0x02, (byte) 0x04, (byte) 0x08, (byte) 0x10, (byte) 0x20,
            (byte) 0x40, (byte) 0x80 };

    /**
     * Generates Java code above
     *
     * @param args
     */
    public static void main(final String[] args) {
        genMasks("long", Long.SIZE, "", "L");
        genMasks("int", Integer.SIZE, "", "");
        genMasks("byte", Byte.SIZE, "(byte)", "");
    }

    /**
     * Internal code generator function.
     *
     * @param nativeType
     * @param bits
     * @param prefix
     * @param suffix
     */
    private static void genMasks(String nativeType, int bits, String prefix,
            String suffix) {
        PrintStream out = System.out;

        String uppercaseType = nativeType.toUpperCase();
        String formatString = "0x%0" + bits / 4 + "X";

        out.println();
        out.println("/**");
        out.println(" * Mask low order N bits of " + nativeType);
        out.println(" */");
        out.print("public static final " + nativeType + "[] LOW_ORDER_"
                + uppercaseType + "_MASK = { ");

        long val = 0;

        for (int i = 0; i <= bits; ++i) {
            if (i > 0) {
                out.print(", ");
            }
            out.print(prefix + String.format(formatString, val) + suffix);
            val = val << 1;
            val = val | 1;
        }
        out.println("}; ");
        out.println();

        long firstBit = 1;
        for (int i = 0; i < bits - 1; ++i) {
            firstBit = firstBit << 1;
        }

        out.println();
        out.println("/**");
        out.println(" * Mask high order N bits of " + nativeType);
        out.println(" */");
        out.print("public static final " + nativeType + "[] HIGH_ORDER_"
                + uppercaseType + "_MASK = { ");
        val = 0;
        for (int i = 0; i <= bits; ++i) {
            if (i > 0) {
                out.print(", ");
            }
            out.print(prefix + String.format(formatString, val) + suffix);
            val = val >> 1;
            val = val | firstBit;
        }
        out.println("}; ");
        out.println();

        out.println();
        out.println("/**");
        out.println(" * Mask individual bit of " + nativeType
                + " at bit position N");
        out.println(" */");
        out.print("public static final " + nativeType + "[] SINGLE_BIT_"
                + uppercaseType + "_MASK = { ");
        val = 1;
        for (int i = 0; i < bits; ++i) {
            if (i > 0) {
                out.print(", ");
            }
            out.print(prefix + String.format(formatString, val) + suffix);
            val = val << 1;
        }
        out.println("}; ");
        out.println();
    }
}
