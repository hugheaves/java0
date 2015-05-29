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
package org.java0.core.type;

import java.nio.ByteBuffer;

/**
 * @author Hugh Eaves
 *
 */
public interface Constants {
	/**
	 * Magic number used to indicate uninitialized hashCode() values. This
	 * number is used instead of zero because many objects end up with a
	 * calculated hashCode() value of zero.
	 */
	public static final int HASHCODE_MAGIC_NUM = 0xe9dc736b;

	public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

	public static final String EMPTY_STRING = "";

	public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

	public static final ByteBuffer EMPTY_BYTE_BUFFER = ByteBuffer.allocate(0);

}
