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

import java.util.Random;

import org.java0.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Hugh Eaves
 *
 */
public class BitUtilTest extends BaseTest {

    @Test
    public void test0() {
        final Random random = new Random();
        for (int i = 0; i < 1000; ++i) {
            final StringBuffer bitString = new StringBuffer();
            for (int j = 0; j < i; ++j) {
                if (random.nextInt(2) == 0) {
                    bitString.append('0');
                } else {
                    bitString.append('1');
                }
            }
            final byte[] array = BitStringUtil.toByteArray(bitString.toString());
            final String newBitString = BitStringUtil.toString(array, i);
            Assert.assertEquals(bitString.toString(), newBitString);
        }
    }

    @Test
    public void test1() {
        Assert.assertEquals(BitStringUtil.toString(0b10100, 5), "10100");
        Assert.assertEquals(BitStringUtil.toString(0b0000000000011100000000000000000100100011110010100000111101010100L),
                "0000000000011100000000000000000100100011110010100000111101010100");
        Assert.assertEquals(BitStringUtil.toString(-1L),
                "1111111111111111111111111111111111111111111111111111111111111111");
        Assert.assertEquals(BitStringUtil.toString(-2L, 64),
                "1111111111111111111111111111111111111111111111111111111111111110");
        Assert.assertEquals(BitStringUtil.toString(-2L, 1), "0");
        Assert.assertEquals(BitStringUtil.toString(-2L, 0), "");

        Assert.assertEquals(BitStringUtil.toString((byte) 128), "10000000");
        Assert.assertEquals(BitStringUtil.toString(-1), "11111111111111111111111111111111");

    }

}
