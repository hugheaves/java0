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
package org.java0.string;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Hugh Eaves
 *
 */
public class LongConverterTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory
			.getLogger(LongConverterTest.class.getName());

	@Test
	public void longConverterTest() {
		testAll(0);
		testAll(1);
		testAll(-1);
		testAll(Long.MAX_VALUE);
		testAll(Long.MIN_VALUE);
		for (long i = -1000; i < 1000; ++i) {
			testAll(i);
		}
	}

	public void testAll(long value) {
		testBytesToLong(value);
		testLongToBytes(value);
		testLongLength(value);
		testLongToBytesWidth(value, 20);
	}

	protected void testBytesToLong(long value) {
		assertEquals(value,
				ByteArrayConverter.toLong(Long.toString(value).getBytes()));
	}

	protected void testLongLength(long value) {
		assertEquals(Long.toString(value).length(),
				ByteArrayConverter.numChars(value));
	}

	protected void testLongToBytesWidth(long value, int width) {
		byte[] expected = Long.toString(value).getBytes();
		byte[] result = ByteArrayConverter.toArray(value, width);
		assertEquals(expected[expected.length - 1], result[result.length - 1]);
		assertEquals(width, result.length);
		if (value < 0) {
			assertEquals('-', result[0]);
		}
	}

	protected void testLongToBytes(long value) {
		assertArrayEquals(Long.toString(value).getBytes(),
				ByteArrayConverter.toArray(value));
	}
}
