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

/**
 * @author Hugh Eaves
 *
 */
public class ByteCharSubSequence implements CharSequence {
	private byte[] data;
	private int start;
	private int end;

	public ByteCharSubSequence(byte[] data) {
		this(data, 0, data.length);
	}

	public ByteCharSubSequence(byte[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	/**
	 * @see java.lang.CharSequence#length()
	 */
	@Override
	public int length() {
		return end - start;
	}

	/**
	 * @see java.lang.CharSequence#charAt(int)
	 */
	@Override
	public char charAt(int index) {
		return (char) data[start + index];
	}

	/**
	 * @see java.lang.CharSequence#subSequence(int, int)
	 */
	@Override
	public CharSequence subSequence(int start, int end) {
		return new ByteCharSubSequence(data, this.start + start, this.start
				+ end);
	}
}
