package org.java0.util.collections;

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
	
	public T[] array() {
		throw new UnsupportedOperationException();
	}

	public boolean hasArray() {
		return false;
	}

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
