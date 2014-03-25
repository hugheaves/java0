/*
 * Copyright (C) 2014 Hugh Eaves
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
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
	/*
	 * Array of set elements
	 */
    private E[] elements;

    /*
     * Number of empty elements in the array
     */
    private int emptyElements;

    /*
     * Array (index + 1) of next unused element in array
     */
    private int nextElement;

    public ArraySet() {
        this(4);
    }

    @SuppressWarnings("unchecked")
    public ArraySet(int capacity) {
        elements = (E[]) new Object[capacity];
        nextElement = 0;
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
        	while (position < nextElement
                    && elements[position] == null) {
                ++position;
            }

            if (position >= nextElement) {
                return false;

            }
            return true;

        }

        /**
         * @see java.util.Iterator#next()
         */
        @Override
        public E next() {
            if (position >= nextElement) {
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
            if (!nextCalled)  {
                throw new IllegalStateException();
            }
            nextCalled = false;
            elements[position-1] = null;
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
        return nextElement - emptyElements;
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
        for (int i = 0; i < nextElement; ++i) {
            if (elements[i] == null) {
                nullPos = i;
            } else if (elements[i].equals(e)) {
                return false;
            }
        }

        if (nullPos != -1) {
            elements[nullPos] = e;
            --emptyElements;
        } else if (nextElement < elements.length) {
        	elements[nextElement++] = e;
        } else {
        	expandArray();
        	elements[nextElement++] = e;
        }
        return true;
    }

    private void expandArray() {
        @SuppressWarnings("unchecked")
        E newElements[] = (E[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    @Override
	public void clear() {
    	nextElement = 0;
    	emptyElements = 0;
    }
}
