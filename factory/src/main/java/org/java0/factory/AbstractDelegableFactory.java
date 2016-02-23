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
package org.java0.factory;

import java.util.function.Supplier;

import org.java0.collection.rowset.HashRowSet;
import org.java0.collection.rowset.RowSet;
import org.java0.collection.tuple.ThreeTuple;
import org.java0.collection.tuple.TwoTuple;
import org.java0.tag.DefaultTagComparator;
import org.java0.tag.TagComparator;

/**
 * @author Hugh Eaves
 *
 */
public class AbstractDelegableFactory extends AbstractFactory implements DelegableFactory {

    protected final TagComparator tagComparator = new DefaultTagComparator();

    /**
     *
     */
    private final HashRowSet<ThreeTuple<Class<?>, Object, Supplier<?>>> typeTable = new HashRowSet<>();

    protected AbstractDelegableFactory() {
        super(null);
    }

    protected AbstractDelegableFactory(final String name) {
        super(name);
    }

    /**
     * Adds a concrete type to the factory.
     *
     * @param concreteType
     * @param singleton
     */
    protected <T> void addType(final Class<T> concreteType, final boolean singleton) {
        addType(concreteType, null, new NewObjectProvider<T>(concreteType, singleton));
    }

    /**
     * Adds a mapping from a lookup type to a concrete type.
     *
     * @param lookupType
     * @param singleton
     * @param concreteType
     */
    protected <T> void addType(final Class<T> lookupType, final boolean singleton,
            final Class<? extends T> concreteType) {
        addType(lookupType, null, new NewObjectProvider<T>(concreteType, singleton));
    }

    /**
     *
     * Adds a mapping from a lookup type to a concrete type with the specified
     * constructor mappings.
     *
     * @param lookupType
     * @param lookupTypeObject
     * @param singleton
     * @param concreteType
     * @param constructorFields
     */
    protected <T> void addType(final Class<T> lookupType, final Object selector, final boolean singleton,
            final Class<? extends T> concreteType, final InjectableFields constructorFields) {
        typeTable.add(new ThreeTuple<Class<?>, Object, Supplier<?>>(lookupType, selector,
                new InjectableProvider<T>(concreteType, null, singleton, constructorFields)));
    }

    /**
     *
     * Adds a mapping from a lookup type to a concrete type with the specified
     * constructor mappings.
     *
     * @param lookupType
     * @param lookupTypeObject
     * @param singleton
     * @param concreteType
     * @param constructorProviders
     */
    protected <T> void addType(final Class<T> lookupType, final Object selector, final boolean singleton,
            final Class<? extends T> concreteType, final TypedObjectProvider<?>... constructorProviders) {
        typeTable.add(new ThreeTuple<Class<?>, Object, Supplier<?>>(lookupType, selector,
                new NewObjectProvider<T>(concreteType, singleton, constructorProviders)));
    }

    /**
     * @param lookupType
     * @param lookupTypeObject
     * @param singleton
     * @param concreteType
     */
    protected <T> void addType(final Class<T> lookupType, final Object selector, final boolean singleton,
            final Class<? extends T> concreteType) {
        typeTable.add(new ThreeTuple<Class<?>, Object, Supplier<?>>(lookupType, selector,
                new NewObjectProvider<T>(concreteType, singleton)));
    }

    /**
     * Adds a mapping from a type to an ObjectProvider for that type.
     *
     * @param lookupType
     * @param provider
     */
    protected <T> void addType(final Class<T> lookupType, final Supplier<T> provider) {
        addType(lookupType, null, provider);
    }

    /**
     *
     * Adds a mapping from a lookup type and DisriminatorSet to an
     * ObjectProvider.
     *
     * @param lookupType
     * @param lookupTypeObject
     * @param provider
     */
    protected <T> void addType(final Class<T> lookupType, final Object selector, final Supplier<T> provider) {
        typeTable.add(new ThreeTuple<Class<?>, Object, Supplier<?>>(lookupType, selector, provider));
    }

    /**
     * @see org.java0.factory.DelegableFactory#getSupportedTypes()
     */
    @Override
    public RowSet<TwoTuple<Class<?>, Object>> getSupportedTypes() {
        final RowSet<TwoTuple<Class<?>, Object>> supportedTypes = new HashRowSet<>();
        for (final ThreeTuple<Class<?>, Object, Supplier<?>> row : typeTable) {
            supportedTypes.add(new TwoTuple<Class<?>, Object>(row.get0(), row.get0()));
        }
        return supportedTypes;
    }

    /**
     * @see org.java0.factory.Factory#getObject(java.lang.Class,
     *      org.java0.selector.Object, org.java0.factory.Config)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getObject(final Class<T> type, final Object selector, final Config<T> config) throws FactoryException {

        final RowSet<ThreeTuple<Class<?>, Object, Supplier<?>>> table = typeTable
                .select(new ThreeTuple<Class<?>, Object, Supplier<?>>(type, selector, null));

        int maxScore = Integer.MIN_VALUE;
        int count = 0;
        Supplier<T> creator = null;

        // find the highest scoring match
        for (final ThreeTuple<Class<?>, Object, Supplier<?>> row : table) {

            final int score = tagComparator.matchScore(row.get1(), selector);

            if (score > maxScore) {
                maxScore = score;
                creator = (Supplier<T>) row.get2();
                count = 1;
            } else if (score == maxScore) {
                ++count;
            }
        }

        if (maxScore > Integer.MIN_VALUE) {
            if (count > 1) {
                throw new AmbiguousTypeException();
            }
            if (creator instanceof ConfiguredObjectSupplier) {
                return ((ConfiguredObjectSupplier<T, Config<T>>) creator).get(config);
            } else {
                return creator.get();
            }
        } else {
            throw new UnknownTypeException();
        }
    }

}
