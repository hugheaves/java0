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

/**
 * @author Hugh Eaves
 *
 */
public class ByteCharSequence implements CharSequence {
	private final byte[] data;

	public ByteCharSequence(final byte[] data) {
		this.data = data;
	}

	/**
	 * @see java.lang.CharSequence#length()
	 */
	@Override
	public int length() {
		return data.length;
	}

	/**
	 * @see java.lang.CharSequence#charAt(int)
	 */
	@Override
	public char charAt(final int index) {
		return (char) data[index];
	}

	/**
	 * @see java.lang.CharSequence#subSequence(int, int)
	 */
	@Override
	public CharSequence subSequence(final int start, final int end) {
		return new ByteCharSubSequence(data, start, end);
	}

	public byte[] getBytes() {
		return data;
	}

	@Override
	public String toString() {
		final StringBuilder buffer = new StringBuilder(data.length);
		for (final byte ch : data) {
			buffer.append((char) ch);
		}
		return buffer.toString();
	}
}
