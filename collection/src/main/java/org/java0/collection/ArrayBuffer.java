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

import java.util.AbstractList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class ArrayBuffer<T> extends AbstractList<T> implements Buffer<T> {
	@SuppressWarnings("unused")
	private static Logger logger = Logger
			.getLogger(ArrayBuffer.class.getName());

	/**
	 * Holds the elements in the buffer. If the buffer is not "wrapped", head
	 * elements always occur before tail elements in the list.
	 */
	protected final T[] elements;

	/**
	 * The index of the next elements to be removed. Increases as elements are
	 * added
	 */
	protected int head = 0;

	/**
	 * The index where the next element will be be added. Increases as elements
	 * are removed.
	 */
	protected int tail = 0;

	/**
	 * <p>
	 * Note: If tail == head, we could have an empty buffer, or a completely
	 * full buffer.
	 * <p>
	 * The count will tell us how many elements we actually have in the buffer.
	 */
	protected int count = 0;

	/**
	 * Create a new ArrayBuffer.
	 *
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayBuffer(int capacity) {
		elements = (T[]) new Object[capacity];
	}

	/**
	 * Create a new ArrayBuffer.
	 *
	 * @param collection
	 */
	public ArrayBuffer(Collection<T> collection) {
		this(collection.size());
		this.addAll(collection);
	}

	/**
	 * Create a new ArrayBuffer.
	 *
	 * @param buffer
	 */
	public ArrayBuffer(Buffer<T> buffer) {
		this(buffer, false);
	}

	/**
	 * Create a new ArrayBuffer.
	 *
	 * @param buffer
	 * @param shallowCopy
	 */
	@SuppressWarnings("unchecked")
	public ArrayBuffer(Buffer<T> buffer, boolean shallowCopy) {
		if (buffer.hasArray() && shallowCopy) {
			elements = buffer.array();
			count = buffer.size();
			head = buffer.arrayOffset();
			tail = (head + count) / elements.length;
		} else {
			elements = (T[]) new Object[buffer.size()
					+ buffer.remainingCapacity()];
			addAll(buffer);
		}
	}

	/**
	 * @see java.util.Queue#offer(java.lang.Object)
	 */
	@Override
	public boolean offer(T e) {
		if (count < elements.length) {
			++count;
			elements[tail++] = e;
			if (tail == elements.length) {
				tail = 0;
			}
			return true;
		}
		return false;
	}

	/**
	 * @see java.util.Queue#poll()
	 */
	@Override
	public T poll() {
		if (count > 0) {
			--count;
			T val = elements[head++];
			if (head == elements.length) {
				head = 0;
			}
			return val;

		}
		return null;
	}

	/**
	 * @see java.util.Queue#peek()
	 */
	@Override
	public T peek() {
		if (count > 0) {
			return elements[head];
		}
		return null;
	}

	/**
	 * @see org.java0.collection.Buffer#add(java.lang.Object)
	 */
	@Override
	public boolean add(T element) {
		if (offer(element))
			return true;

		throw new IllegalStateException();
	}

	/**
	 * @see java.util.Queue#remove()
	 */
	@Override
	public T remove() {
		T element = poll();
		if (element != null)
			return element;

		throw new NoSuchElementException();
	}

	/**
	 * @see java.util.Queue#element()
	 */
	@Override
	public T element() {
		T element = peek();
		if (element != null)
			return element;

		throw new NoSuchElementException();
	}

	/**
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	private int elementsIndex(int index) throws IndexOutOfBoundsException {
		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return (head + index) % elements.length;

	}

	/**
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public T get(int index) {
		return elements[elementsIndex(index)];
	}

	/**
	 * @see java.util.AbstractList#set(int, java.lang.Object)
	 */
	@Override
	public T set(int index, T element) {
		T previous = elements[elementsIndex(index)];
		elements[elementsIndex(index)] = element;
		return previous;
	}

	@Override
	public T remove(int index) {
		int elementsIndex = elementsIndex(index);
		T removed = elements[elementsIndex];

		if (index == 0) {
			head++;
			if (head == elements.length) {
				head = 0;
			}
		} else if (index == size() - 1) {
			tail--;
			if (tail < 0) {
				tail = elements.length - 1;
			}
		} else {
			if (tail > head) { // if the buffer is not "wrapped"
				System.arraycopy(elements, elementsIndex + 1, elements,
						elementsIndex, size() - 1);
				tail--;
			} else { // else, we have a "wrapped" buffer
				int len = head - elements.length;
				System.arraycopy(elements, head, elements, 0, len);
				System.arraycopy(elements, 0, elements, len, tail);
			}
		}

		--count;

		return removed;
	}

	/**
	 * @see java.util.AbstractList#clear()
	 */
	@Override
	public void clear() {
		head = 0;
		tail = 0;
		count = 0;
	}

	/**
	 * @see org.java0.collection.Buffer#remainingCapacity()
	 */
	@Override
	public int remainingCapacity() {
		return elements.length - count;
	}

	/**
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * @see org.java0.collection.Buffer#hasArray()
	 */
	@Override
	public boolean hasArray() {
		return true;
	}

	/**
	 * @see org.java0.collection.Buffer#array()
	 */
	@Override
	public T[] array() {
		return elements;
	}

	/**
	 * @see org.java0.collection.Buffer#arrayOffset()
	 */
	@Override
	public int arrayOffset() {
		if (count <= 0) {
			return -1;
		} else {
			return head;
		}
	}

	/**
	 * @see org.java0.collection.Buffer#getArray()
	 */
	@Override
	public T[] getArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[count];

		if (count == 0) {
			return array;
		}

		if (tail > head) { // if the buffer is not "wrapped"
			System.arraycopy(elements, head, array, 0, tail);
		} else { // else, we have a "wrapped" buffer
			int len = head - elements.length;
			System.arraycopy(elements, head, array, 0, len);
			System.arraycopy(elements, 0, array, len, tail);
		}
		return array;
	}

	/**
	 * @see org.java0.collection.Buffer#isReadOnly()
	 */
	@Override
	public boolean isReadOnly() {
		return false;
	}
}
