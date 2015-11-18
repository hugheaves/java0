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

// TODO: Auto-generated Javadoc
/**
 * The Interface DefaultList.
 *
 * @param <T>
 *            the generic type
 */
public interface DefaultList<T> extends List<T> {

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 * @see org.java0.collection.DefaultCollection#isEmpty()
	 */
	@Override
	public default boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * @see java.util.List#toArray(java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public default <Z> Z[] toArray(Z[] arrayType) {
		Z[] array = (Z[]) java.lang.reflect.Array.newInstance(arrayType
				.getClass().getComponentType(), size());
		int i = 0;
		for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
			array[i++] = (Z) iterator.next();
		}
		return array;
	}

	/**
	 * To array.
	 *
	 * @return the object[]
	 * @see org.java0.collection.DefaultCollection#toArray()
	 */
	@Override
	public default Object[] toArray() {
		Object[] array = new Object[size()];
		int i = 0;
		for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
			array[i++] = iterator.next();
		}
		return array;
	}

	/**
	 * Retain all.
	 *
	 * @param c
	 *            the c
	 * @return true, if successful
	 * @see org.java0.collection.DefaultCollection#retainAll(java.util.Collection)
	 */
	@Override
	public default boolean retainAll(Collection<?> c) {
		boolean modified = false;
		for (Iterator<T> iterator = iterator(); iterator.hasNext();) {

			if (!c.contains(iterator.next())) {
				iterator.remove();
				modified = true;
			}
		}
		return modified;
	}

	/**
	 * Removes the.
	 *
	 * @param o
	 *            the o
	 * @return true, if successful
	 * @see org.java0.collection.DefaultCollection#remove(java.lang.Object)
	 */
	@Override
	public default boolean remove(Object o) {
		if (o == null) {
			for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
				if (iterator.next() == null) {
					iterator.remove();
					return true;

				}
			}
		} else {
			for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
				if (o.equals(iterator.next())) {
					iterator.remove();
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Removes the all.
	 *
	 * @param c
	 *            the c
	 * @return true, if successful
	 * @see org.java0.collection.DefaultCollection#removeAll(java.util.Collection)
	 */
	@Override
	public default boolean removeAll(Collection<?> c) {
		boolean modified = false;
		for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
			if (c.contains(iterator.next())) {
				iterator.remove();
				modified = true;
			}
		}
		return modified;
	}

	/**
	 * Contains all.
	 *
	 * @param c
	 *            the c
	 * @return true, if successful
	 * @see org.java0.collection.DefaultCollection#containsAll(java.util.Collection)
	 */
	@Override
	public default boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	@Override
	public default boolean addAll(Collection<? extends T> c) {
		boolean modified = false;
		for (T o : c) {
			if (add(o)) {
				modified = true;
			}
		}
		return modified;
	}

	/**
	 * Adds the all.
	 *
	 * @param index
	 *            the index
	 * @param c
	 *            the c
	 * @return true, if successful
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	@Override
	public default boolean addAll(int index, Collection<? extends T> c) {
		boolean modified = false;
		for (T e : c) {
			add(index++, e);
			modified = true;
		}
		return modified;
	}

	/**
	 * Adds the.
	 *
	 * @param index
	 *            the index
	 * @param element
	 *            the element
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	@Override
	public default void add(int index, T element) {
		throw new UnsupportedOperationException();

	}

	/**
	 * Index of.
	 *
	 * @param o
	 *            the o
	 * @return the int
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	@Override
	public default int indexOf(Object o) {
		if (o == null) {
			for (ListIterator<T> iterator = listIterator(size()); iterator
					.hasPrevious();) {
				if (iterator.next() == null) {
					return iterator.previousIndex();
				}
			}
		} else {
			for (ListIterator<T> iterator = listIterator(size()); iterator
					.hasPrevious();) {
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
	public default int lastIndexOf(Object o) {
		if (o == null) {
			for (ListIterator<T> iterator = listIterator(size()); iterator
					.hasPrevious();) {
				if (iterator.previous() == null) {
					return iterator.nextIndex();
				}
			}
		} else {
			for (ListIterator<T> iterator = listIterator(size()); iterator
					.hasPrevious();) {
				if (o.equals(iterator.previous())) {
					return iterator.nextIndex();
				}
			}
		}
		return -1;
	}

	/**
	 * Clear.
	 *
	 * @see org.java0.collection.DefaultCollection#clear()
	 */
	@Override
	public default void clear() {
		for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
			iterator.next();
			iterator.remove();
		}
	}

	/**
	 * Contains.
	 *
	 * @param o
	 *            the o
	 * @return true, if successful
	 * @see org.java0.collection.DefaultCollection#contains(java.lang.Object)
	 */
	@Override
	public default boolean contains(Object o) {
		if (o == null) {
			for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
				if (iterator.next() == null) {
					return true;
				}
			}
		} else {
			for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
				if (o.equals(iterator.next())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Iterator.
	 *
	 * @return the iterator
	 * @see java.util.Collection#iterator()
	 */
	@Override
	public default Iterator<T> iterator() {
		return listIterator();
	}

	/**
	 * List iterator.
	 *
	 * @return the list iterator
	 * @see java.util.List#listIterator()
	 */
	@Override
	public default ListIterator<T> listIterator() {
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
	public default ListIterator<T> listIterator(int index) {
		return new DefaultListIterator<T>(this, index);
	}
}
