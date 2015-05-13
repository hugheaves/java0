package org.java0.collection;

import java.util.Collection;
import java.util.Iterator;

public interface DefaultCollection<T> extends Collection<T> {
	@Override
	public default boolean isEmpty() {
		return size() == 0;
	}

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

	@Override
	public default Object[] toArray() {
		Object[] array = new Object[size()];
		int i = 0;
		for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
			array[i++] = iterator.next();
		}
		return array;
	}

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

	@Override
	public default boolean add(T e) {
		throw new UnsupportedOperationException();
	}

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

	@Override
	public default boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

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

	@Override
	public default void clear() {
		for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
			iterator.remove();
		}
	}
}
