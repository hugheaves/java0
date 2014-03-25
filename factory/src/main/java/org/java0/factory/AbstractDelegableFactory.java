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
package org.java0.factory;

import org.java0.collection.HashRowSet;
import org.java0.collection.RowSet;
import org.java0.collection.ThreeColumnRow;
import org.java0.collection.TwoColumnRow;
import org.java0.tag.DefaultTagComparator;
import org.java0.tag.Tag;
import org.java0.tag.TagComparator;

/**
 * @author Hugh Eaves
 *
 */
public class AbstractDelegableFactory extends AbstractFactory implements
        DelegableFactory {

    protected final TagComparator tagComparator = new DefaultTagComparator();

    /**
     *
     */
    private final HashRowSet<ThreeColumnRow<Class<?>, Tag, ObjectProvider<?>>> typeTable = new HashRowSet<>();

    /**
     * Adds a concrete type to the factory.
     *
     * @param concreteType
     * @param singleton
     */
    protected <T> void addType(Class<T> concreteType, boolean singleton) {
        addType(concreteType, null, new NewObjectProvider<T>(concreteType,
                singleton));
    }

    /**
     * Adds a mapping from a lookup type to a concrete type.
     *
     * @param lookupType
     * @param singleton
     * @param concreteType
     */
    protected <T> void addType(Class<T> lookupType, boolean singleton,
            Class<? extends T> concreteType) {
        addType(lookupType, null, new NewObjectProvider<T>(concreteType,
                singleton));
    }

    /**
     *
     * Adds a mapping from a lookup type to a concrete type with the specified
     * constructor mappings.
     *
     * @param lookupType
     * @param lookupTypeTag
     * @param singleton
     * @param concreteType
     * @param constructorFields
     */
    protected <T> void addType(Class<T> lookupType, Tag lookupTypeTag,
            boolean singleton, Class<? extends T> concreteType,
            InjectableFields constructorFields) {
        typeTable.add(new ThreeColumnRow<Class<?>, Tag, ObjectProvider<?>>(
                lookupType, lookupTypeTag, new InjectableProvider<T>(
                        concreteType, null, singleton, constructorFields)));
    }

    /**
     *
     * Adds a mapping from a lookup type to a concrete type with the specified
     * constructor mappings.
     *
     * @param lookupType
     * @param lookupTypeTag
     * @param singleton
     * @param concreteType
     * @param constructorProviders
     */
    protected <T> void addType(Class<T> lookupType, Tag lookupTypeTag,
            boolean singleton, Class<? extends T> concreteType,
            TypedObjectProvider<?>... constructorProviders) {
        typeTable.add(new ThreeColumnRow<Class<?>, Tag, ObjectProvider<?>>(
                lookupType, lookupTypeTag, new NewObjectProvider<T>(
                        concreteType, singleton, constructorProviders)));
    }

    /**
     * @param lookupType
     * @param lookupTypeTag
     * @param singleton
     * @param concreteType
     */
    protected <T> void addType(Class<T> lookupType, Tag lookupTypeTag,
            boolean singleton, Class<? extends T> concreteType) {
        typeTable.add(new ThreeColumnRow<Class<?>, Tag, ObjectProvider<?>>(
                lookupType, lookupTypeTag, new NewObjectProvider<T>(
                        concreteType, singleton)));
    }

    /**
     * Adds a mapping from a type to an ObjectProvider for that type.
     *
     * @param lookupType
     * @param provider
     */
    protected <T> void addType(Class<T> lookupType, ObjectProvider<T> provider) {
        addType(lookupType, null, provider);
    }

    /**
     *
     * Adds a mapping from a lookup type and DisriminatorSet to an
     * ObjectProvider.
     *
     * @param lookupType
     * @param lookupTypeTag
     * @param provider
     */
    protected <T> void addType(Class<T> lookupType, Tag lookupTypeTag,
            ObjectProvider<T> provider) {
        typeTable.add(new ThreeColumnRow<Class<?>, Tag, ObjectProvider<?>>(
                lookupType, lookupTypeTag, provider));
    }

    /**
     * @see org.java0.factory.DelegableFactory#getSupportedTypes()
     */
    @Override
    public RowSet<TwoColumnRow<Class<?>, Tag>> getSupportedTypes() {
        RowSet<TwoColumnRow<Class<?>, Tag>> supportedTypes = new HashRowSet<>();
        for (ThreeColumnRow<Class<?>, Tag, ObjectProvider<?>> row : typeTable) {
            supportedTypes.add(new TwoColumnRow<Class<?>, Tag>(
                    row.getColumn1(), row.getColumn2()));
        }
        return supportedTypes;
    }

    /**
     * @see org.java0.factory.Factory#getObject(java.lang.Class,
     *      org.java0.tag.Tag, org.java0.factory.Config)
     */
    @Override
    public <T> T getObject(Class<T> type, Tag tag, Config<T> config)
            throws FactoryException {

        RowSet<ThreeColumnRow<Class<?>, Tag, ObjectProvider<?>>> table = typeTable
                .select(new ThreeColumnRow<Class<?>, Tag, ObjectProvider<?>>(
                        type, tag, null));

        int maxScore = Integer.MIN_VALUE;
        int count = 0;
        ObjectProvider<T> creator = null;

        // find the highest scoring match
        for (ThreeColumnRow<Class<?>, Tag, ObjectProvider<?>> row : table) {

            int score = tagComparator.matchScore(row.getColumn2(), tag);

            if (score > maxScore) {
                maxScore = score;
                creator = (ObjectProvider<T>) row.getColumn3();
                count = 1;
            } else if (score == maxScore) {
                ++count;
            }
        }

        if (maxScore > Integer.MIN_VALUE) {
            if (count > 1) {
                throw new AmbiguousTypeException();
            }
            return creator.getObject(config);
        } else {
            throw new UnknownTypeException();
        }
    }

}
