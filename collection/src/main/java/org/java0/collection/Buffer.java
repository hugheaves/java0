/*
 * robotjava
 *
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
 *
 */
package org.java0.collection;

import java.util.List;
import java.util.Queue;

/**
 * Combines certain elements of a Queue, BlockingQueue, List, and java.nio.Buffer.
 *
 * @author Hugh Eaves
 *
 */
public interface Buffer<T> extends Queue<T>, List<T> {
    /**
     * @see java.util.Queue#add(java.lang.Object)
     */
    @Override
    public boolean add(T element);

	/**
	 * @see java.util.concurrent.BlockingQueue#remainingCapacity()
	 *
	 * @return
	 */
	public int remainingCapacity();

    /**
	 * @see java.nio.Buffer#array()
	 *
     * @return
     */
    public T[] array();

    /**
     * Returns the array that backs this {@code Buffer}. Note that the first element in the array
     * may not be the first element in the {@code Buffer}.
     *
 	 * @see java.nio.Buffer#hasArray()
 	 *
     * @return
     */
    public boolean hasArray();

    /**
 	 * @see java.nio.Buffer#arrayOffset()
 	 *
     * @return
     */
    public int arrayOffset();

    /**
     * Returns an array containing all the elements in this {@code Buffer}, with
     * the first element in the {@code Buffer} stored in the first element of the array.
     *
     * @return
     */
    public T[] getArray();

    /**
     * Returns true if this is a read-only buffer
     *
     * @return
     */
    public boolean isReadOnly();
}
