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
package org.java0.io;

import org.java0.collection.Buffer;

/**
 * @author Hugh Eaves
 * 
 */
public interface ReadableChannel<T> extends ObjectChannel {
    /**
     * Read a single value from the {@code ReadableIOChannel}. The read may or
     * may not block depending on whether this is a blocking or non-blocking
     * source.
     * 
     * @return null is no value is available (in non-blocking mode), otherwise
     *         returns a value
     */
    public T read();

    /**
     * Read a series of values from the {@code ReadableIOChannel} into the given
     * {@code buffer}. At most {@code maxValues} will be added to the buffer. In
     * non-blocking mode, at least one value will be added to the buffer.
     * 
     * @param buffer
     *            the buffer into which values should be read
     * @param maxValues
     *            the maximum number of values to read / add to the buffer
     * @return the number of values actually read
     */
    public int read(Buffer<T> buffer, int maxValues);

    /**
     * Read a series of values from the {@code ReadableIOChannel} into the given
     * {@code buffer}. The number of values read will be up to the remaining
     * capacity of the buffer. In non-blocking mode, at least one value will be
     * added to the buffer.
     * 
     * @param buffer
     *            the buffer into which values should be read
     * @return the number of values actually read
     */
    public int read(Buffer<T> buffer);
}
