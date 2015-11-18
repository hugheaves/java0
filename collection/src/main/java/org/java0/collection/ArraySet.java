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

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Hugh Eaves
 *
 */
public class ArraySet<E> extends AbstractSet<E> {
	/**
	 *
	 */
	private static final int INITIAL_CAPACITY = 4;

	/*
	 * Array of set elements
	 */
	private E[] elements;

	/*
	 * Number of empty elements in the array
	 */
	private int emptyElements;

	/*
	 * Index of first unused element in array
	 */
	private int lastElement;

	public ArraySet() {
		this(INITIAL_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArraySet(int capacity) {
		elements = (E[]) new Object[capacity];
		lastElement = 0;
		emptyElements = 0;
	}

	protected class ArraySetIterator implements Iterator<E> {
		private int position = 0;
		private boolean nextCalled = false;

		/**
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			while (position < lastElement && elements[position] == null) {
				++position;
			}

			if (position >= lastElement) {
				return false;

			}
			return true;

		}

		/**
		 * @see java.util.Iterator#next()
		 */
		@Override
		public E next() {
			if (position >= lastElement) {
				throw new NoSuchElementException();
			}
			nextCalled = true;
			return elements[position++];
		}

		/**
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			if (!nextCalled) {
				throw new IllegalStateException();
			}
			nextCalled = false;
			elements[position - 1] = null;
			++emptyElements;
		}
	}

	/**
	 * @see java.util.AbstractCollection#iterator()
	 */
	@Override
	public Iterator<E> iterator() {
		return new ArraySetIterator();
	}

	/**
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return lastElement - emptyElements;
	}

	/**
	 * @see java.util.Set#add(java.lang.Object)
	 */
	@Override
	public boolean add(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		int nullPos = -1;
		for (int i = 0; i < lastElement; ++i) {
			if (elements[i] == null) {
				nullPos = i;
			} else if (elements[i].equals(e)) {
				return false;
			}
		}

		if (nullPos != -1) {
			elements[nullPos] = e;
			--emptyElements;
		} else if (lastElement < elements.length) {
			elements[lastElement++] = e;
		} else {
			expandArray();
			elements[lastElement++] = e;
		}
		return true;
	}

	private void expandArray() {
		@SuppressWarnings("unchecked")
		E newElements[] = (E[]) new Object[elements.length * 2];
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		elements = newElements;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		elements = (E[]) new Object[INITIAL_CAPACITY];
		lastElement = 0;
		emptyElements = 0;
	}
}
