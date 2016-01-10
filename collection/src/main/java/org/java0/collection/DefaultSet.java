package org.java0.collection;

import java.util.Collection;
import java.util.Set;

public interface DefaultSet<T> extends DefaultCollection<T>, Set<T> {
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
    public default boolean addAll(final Collection<? extends T> c) {
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
    public default boolean add(final T e) {
        throw new UnsupportedOperationException();
    }
}
