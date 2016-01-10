package org.java0.collection;

import java.util.Collection;
import java.util.Iterator;

public interface DefaultCollection<T> extends Collection<T> {
    @Override
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public default boolean contains(final Object o) {
        if (o == null) {
            for (final Iterator<T> iterator = iterator(); iterator.hasNext();) {
                if (iterator.next() == null) {
                    return true;
                }
            }
        } else {
            for (final Iterator<T> iterator = iterator(); iterator.hasNext();) {
                if (o.equals(iterator.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    // TODO Add check for changing list size
    public default Object[] toArray() {
        final Object[] array = new Object[size()];
        int i = 0;
        for (final Iterator<T> iterator = iterator(); iterator.hasNext();) {
            array[i++] = iterator.next();
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    @Override
    // TODO Add check for changing list size
    public default <Z> Z[] toArray(final Z[] arrayType) {
        final Z[] array = (Z[]) java.lang.reflect.Array.newInstance(arrayType.getClass().getComponentType(), size());
        int i = 0;
        for (final Iterator<T> iterator = iterator(); iterator.hasNext();) {
            array[i++] = (Z) iterator.next();
        }
        return array;
    }

    @Override
    public default boolean add(final T e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public default boolean remove(final Object o) {
        if (o == null) {
            for (final Iterator<T> iterator = iterator(); iterator.hasNext();) {
                if (iterator.next() == null) {
                    iterator.remove();
                    return true;

                }
            }
        } else {
            for (final Iterator<T> iterator = iterator(); iterator.hasNext();) {
                if (o.equals(iterator.next())) {
                    iterator.remove();
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public default boolean containsAll(final Collection<?> c) {
        for (final Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public default boolean addAll(final Collection<? extends T> c) {
        boolean modified = false;
        for (final T o : c) {
            if (add(o)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public default boolean removeAll(final Collection<?> c) {
        boolean modified = false;
        for (final Iterator<T> iterator = iterator(); iterator.hasNext();) {
            if (c.contains(iterator.next())) {
                iterator.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public default boolean retainAll(final Collection<?> c) {
        boolean modified = false;
        for (final Iterator<T> iterator = iterator(); iterator.hasNext();) {

            if (!c.contains(iterator.next())) {
                iterator.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public default void clear() {
        for (final Iterator<T> iterator = iterator(); iterator.hasNext();) {
            iterator.remove();
        }
    }
}
