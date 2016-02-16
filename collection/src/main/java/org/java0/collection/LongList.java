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
package org.java0.collection;

import java.util.List;
import java.util.ListIterator;

/**
 * Follows the same contract as <<tt>>java.util.List<</tt>>, but allows long
 * values to be used as index / position values for the <<tt>>List<</tt>>.
 *
 * @param <E>
 *            the type of elements in this list
 *
 * @author Hugh Eaves
 */

public interface LongList<T> extends DefaultList<T> {

    /**
     * Adds an element to the <<tt>>LongList<</tt> at the given position.
     *
     * @param index
     *            the position at which the element should be added
     * @param element
     *            the element
     */
    void add(long index, T element);

    /**
     * Sets the element at the given position.
     *
     * @param index
     *            the index
     * @param element
     *            the element
     * @return the t
     */
    T set(long index, T element);

    /**
     * Gets the element at the given position.
     *
     * @param index
     *            the index
     * @return the t
     */
    T get(long index);

    /**
     * Returns the number of elements in this list.
     *
     * @return the long
     */
    long sizeL();

    /**
     * Sub list.
     *
     * @param from
     *            the from
     * @param to
     *            the to
     * @return the list
     */
    List<T> subList(long from, long to);

    /**
     * List iterator.
     *
     * @param index
     *            the index
     * @return the list iterator
     */
    ListIterator<T> listIterator(long index);

    /**
     * List iterator.
     *
     * @param index
     *            the index
     * @return the list iterator
     * @see org.java0.collection.DefaultList#listIterator(int)
     */
    @Override
    default ListIterator<T> listIterator(final int index) {
        return listIterator((long) index);
    }

    /**
     * @see org.java0.collection.DefaultList#add(int, java.lang.Object)
     */
    @Override
    default void add(final int index, final T element) {
        add((long) index, element);
    }

    /**
     * @see java.util.List#set(int, java.lang.Object)
     */
    @Override
    default T set(final int index, final T element) {
        return set((long) index, element);
    }

    /**
     * @see java.util.List#get(int)
     */
    @Override
    default T get(final int index) {
        return get((long) index);
    }

    /**
     * @see java.util.Collection#size()
     */
    @Override
    default int size() {
        final long size = sizeL();
        if (sizeL() > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) size;
        }
    }

    /**
     * @see java.util.List#subList(int, int)
     */
    @Override
    default List<T> subList(final int from, final int to) {
        return subList((long) from, (long) to);
    }

}
