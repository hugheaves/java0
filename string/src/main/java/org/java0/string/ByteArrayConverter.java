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
package org.java0.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Hugh Eaves
 *
 */
public class ByteArrayConverter {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory
			.getLogger(ByteArrayConverter.class.getName());

	public static long toLong(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			throw new NumberFormatException("Empty byte array");
		}

		int i = 0;
		long minValue = -Long.MAX_VALUE;

		if (bytes[0] == '-') {
			minValue = Long.MIN_VALUE;
			++i;
		} else if (bytes[0] == '+') {
			++i;

		}

		long preMultiplyMinValue = minValue / 10;

		if (bytes.length == i) {
			throw new NumberFormatException("No digits in input");
		}

		long result = 0;
		while (i < bytes.length) {
			int digit = bytes[i++] - '0';
			if (digit < 0 || digit > 9) {
				throw new NumberFormatException("Invalid digit");
			}
			if (result < preMultiplyMinValue) {
				throw new NumberFormatException("Overflow");
			}
			result *= 10;
			if (result < minValue + digit) {
				throw new NumberFormatException("Overflow");
			}
			result -= digit;
		}

		if (minValue != Long.MIN_VALUE) {
			result = -result;
		}

		return result;
	}

	public static byte[] toArray(long value, int width) {
		int length = numChars(value);
		byte[] buffer;
		if (length < width) {
			buffer = new byte[width];
		} else {
			buffer = new byte[length];
		}
		longToBytes(value, buffer);
		return buffer;
	}

	public static byte[] toArray(long value) {
		byte[] buffer = new byte[numChars(value)];
		longToBytes(value, buffer);
		return buffer;
	}

	private static void longToBytes(long value, byte[] buffer) {
		int pos = buffer.length - 1;
		if (value < 0) {
			buffer[0] = '-';
			while (pos >= 1) {
				buffer[pos] = (byte) ('0' - value % 10);
				value = value / 10;
				--pos;
			}
		} else {
			while (pos >= 0) {
				buffer[pos] = (byte) ('0' + value % 10);
				value = value / 10;
				--pos;
			}
		}
	}

	public static int numChars(long value) {
		if (value == 0) {
			return 1;
		}
		int length = 0;
		if (value < 0) {
			++length;
		}
		while (value != 0) {
			value = value / 10;
			++length;
		}
		return length;
	}

}
