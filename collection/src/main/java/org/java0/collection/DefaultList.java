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
package org.java0.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Provides default implemenetations for many of the methods in <
 * <tt>>java.util.List<</tt>>.
 *
 * @param <E>
 *            the element type of this list
 */
public interface DefaultList<E> extends DefaultCollection<E>, List<E> {

    @Override
    default boolean isEmpty() {
        return DefaultCollection.super.isEmpty();
    }

    @Override
    public default boolean containsAll(final Collection<?> c) {
        return DefaultCollection.super.containsAll(c);
    }

    @Override
    public default boolean retainAll(final Collection<?> c) {
        return DefaultCollection.super.retainAll(c);

    }

    @Override
    public default boolean remove(final Object o) {
        return DefaultCollection.super.remove(o);
    }

    @Override
    public default boolean removeAll(final Collection<?> c) {
        return DefaultCollection.super.removeAll(c);
    }

    @Override
    public default boolean addAll(final Collection<? extends E> c) {
        return DefaultCollection.super.addAll(c);
    }

    @Override
    public default void clear() {
        DefaultCollection.super.clear();
    }

    @Override
    public default boolean contains(final Object o) {
        return DefaultCollection.super.contains(0);
    }

    @Override
    public default <Z> Z[] toArray(final Z[] arrayType) {
        return DefaultCollection.super.toArray(arrayType);
    }

    @Override
    public default Object[] toArray() {
        return DefaultCollection.super.toArray();
    }

    @Override
    public default boolean addAll(int index, final Collection<? extends E> c) {
        boolean modified = false;
        for (final E e : c) {
            add(index++, e);
            modified = true;
        }
        return modified;
    }

    @Override
    public default boolean add(final E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public default void add(final int index, final E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public default int indexOf(final Object o) {
        if (o == null) {
            for (final ListIterator<E> iterator = listIterator(size()); iterator.hasPrevious();) {
                if (iterator.next() == null) {
                    return iterator.previousIndex();
                }
            }
        } else {
            for (final ListIterator<E> iterator = listIterator(size()); iterator.hasPrevious();) {
                if (o.equals(iterator.next())) {
                    return iterator.previousIndex();
                }
            }
        }
        return -1;
    }

    /**
     * Last index of.
     *
     * @param o
     *            the o
     * @return the int
     * @see java.util.List#lastIndexOf(java.lang.Object)
     */
    @Override
    public default int lastIndexOf(final Object o) {
        if (o == null) {
            for (final ListIterator<E> iterator = listIterator(size()); iterator.hasPrevious();) {
                if (iterator.previous() == null) {
                    return iterator.nextIndex();
                }
            }
        } else {
            for (final ListIterator<E> iterator = listIterator(size()); iterator.hasPrevious();) {
                if (o.equals(iterator.previous())) {
                    return iterator.nextIndex();
                }
            }
        }
        return -1;
    }

    /**
     * Iterator.
     *
     * @return the iterator
     * @see java.util.Collection#iterator()
     */
    @Override
    public default Iterator<E> iterator() {
        return listIterator();
    }

    /**
     * List iterator.
     *
     * @return the list iterator
     * @see java.util.List#listIterator()
     */
    @Override
    public default ListIterator<E> listIterator() {
        return listIterator(0);
    }

    /**
     * List iterator.
     *
     * @param index
     *            the index
     * @return the list iterator
     * @see java.util.List#listIterator(int)
     */
    @Override
    public default ListIterator<E> listIterator(final int index) {
        return new DefaultListIterator<E>(this, index);
    }

}
