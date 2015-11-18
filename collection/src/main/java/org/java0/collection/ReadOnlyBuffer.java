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
import java.util.List;
import java.util.logging.Logger;

public class ReadOnlyBuffer<T> extends ArrayBuffer<T> {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ReadOnlyBuffer.class
			.getName());

	protected Buffer<T> buffer;
	protected int originalSize;

	public ReadOnlyBuffer(Buffer<T> buffer) {
		super(buffer, true);
		this.buffer = buffer;
		originalSize = buffer.size();
	}

	@Override
	public boolean offer(T e) {
		throw new UnsupportedOperationException();
	}


	@Override
	public boolean add(T e) {
		throw new UnsupportedOperationException();
	}

		@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public T set(int index, T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isReadOnly() {
		return true;
	}

	@Override
    public T[] array() {
		throw new UnsupportedOperationException();
	}

	@Override
    public boolean hasArray() {
		return false;
	}

	@Override
    public T[] getArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S> S[] toArray(S[] array) {
		throw new UnsupportedOperationException();
	}

	public void reset() {
		if (buffer.hasArray()) {
			count = buffer.size();
			head = buffer.arrayOffset();
			tail = (head + count) / elements.length;
		} else {
			count = originalSize;
			head = 0;
			tail = 0;
		}
	}
}
