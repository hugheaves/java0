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
package org.java0.util.collections;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Hugh Eaves
 *
 */
public class ArraySet<E> extends AbstractSet<E> {
    private E[] elements;
    private int emptyElements;

    @SuppressWarnings("unchecked")
    public ArraySet() {
        elements = (E[]) new Object[1];
        emptyElements = 1;
    }

    @SuppressWarnings("unchecked")
    public ArraySet(int capacity) {
        elements = (E[]) new Object[capacity];
        emptyElements = 0;
   }

    protected class ArraySetIterator implements Iterator<E> {
        private int position = 0;

        /**
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            if (position >= elements.length) {
                return false;

            }
            if (elements[position] != null) {
                return true;
            }

            while (position < (elements.length - 1)
                    && elements[position] != null) {
                ++position;
            }

            if (elements[position] != null) {
                return true;
            }

            return false;

        }

        /**
         * @see java.util.Iterator#next()
         */
        @Override
        public E next() {
            if (position >= elements.length) {
                throw new NoSuchElementException();
            }
            return elements[position];
        }

        /**
         * @see java.util.Iterator#remove()
         */
        @Override
        public void remove() {
            if (elements[position] == null) {
                throw new IllegalStateException();
            }
            ++emptyElements;
            elements[position] = null;
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
        return elements.length - emptyElements;
    }

    /**
     * @see java.util.Set#add(java.lang.Object)
     */
    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }

        if (emptyElements > 0) {
            int nullPos = -1;
            for (int i = 0; i < elements.length; ++i) {
                if (elements[i] == null) {
                    nullPos = i;
                } else if (elements[i].equals(e)) {
                    return false;
                }
            }
            elements[nullPos] = e;
            --emptyElements;
        } else {
            @SuppressWarnings("unchecked")
            E newElements[] = (E[]) new Object[elements.length + 1];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            newElements[elements.length] = e;
            elements = newElements;
        }
        return true;
    }
}
