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
package org.java0.util.factory;

import org.java0.util.collections.ThreeColumnHashTable;
import org.java0.util.collections.ThreeColumnTable;
import org.java0.util.collections.TwoColumnHashTable;
import org.java0.util.collections.TwoColumnTable;
import org.java0.util.collections.ThreeColumnTable.Row;
import org.java0.util.tag.DefaultTagComparator;
import org.java0.util.tag.Tag;
import org.java0.util.tag.TagComparator;

/**
 * @author Hugh Eaves
 *
 */
public abstract class AbstractDelegableFactory extends AbstractFactory
        implements DelegableFactory {

    protected final TagComparator tagComparator = new DefaultTagComparator();

    /**
     *
     */
    private final ThreeColumnTable<Class<?>, Tag, ObjectProvider<?>> typeTable =
            ThreeColumnHashTable.create();

    /**
     * Adds a concrete type to the factory.
     *
     * @param concreteType
     * @param singleton
     */
    protected <T> void addType(Class<T> concreteType, boolean singleton) {
        addType(concreteType, null, new DefaultProvider<T>(
                concreteType, singleton));
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
        addType(lookupType, null, new DefaultProvider<T>(
                concreteType, singleton));
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
    protected <T> void
            addType(Class<T> lookupType, Tag lookupTypeTag, boolean singleton,
                    Class<? extends T> concreteType,
                    InjectableFields constructorFields) {
        typeTable.append(lookupType, lookupTypeTag, new InjectableProvider<T>(
                concreteType, null, singleton, constructorFields));
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
    protected <T> void
            addType(Class<T> lookupType, Tag lookupTypeTag, boolean singleton,
                    Class<? extends T> concreteType,
                    ObjectProvider<?>... constructorProviders) {
       // typeTable.append(lookupType, lookupTypeTag, new InjectableProvider<T>(
       //         concreteType, null, singleton, constructorFields));
    }

    /**
     * @param lookupType
     * @param lookupTypeTag
     * @param singleton
     * @param concreteType
     */
    protected <T> void
            addType(Class<T> lookupType, Tag lookupTypeTag, boolean singleton,
                    Class<? extends T> concreteType) {
        typeTable.append(lookupType, lookupTypeTag,  new DefaultProvider<T>(
                concreteType, null, singleton));
    }


    /**
     * @param lookupType
     * @param lookupTypeTag
     * @param singleton
     * @param concreteType
     * @param concreteTypeTag
     */
    protected <T> void
            addType(Class<T> lookupType, Tag lookupTypeTag, boolean singleton,
                    Class<? extends T> concreteType, Tag concreteTypeTag) {
        typeTable.append(lookupType, lookupTypeTag,  new DefaultProvider<T>(
                concreteType, concreteTypeTag, singleton));
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
     * Adds a mapping from a lookup type and DisriminatorSet to an ObjectProvider.
     *
     * @param lookupType
     * @param lookupTypeTag
     * @param provider
     */
    protected <T> void addType(Class<T> lookupType, Tag lookupTypeTag,
            ObjectProvider<T> provider) {
        typeTable.append(lookupType, lookupTypeTag, provider);
    }

    /**
     * @see org.java0.util.factory.DelegableFactory#getSupportedTypes()
     */
    @Override
    public TwoColumnTable<Class<?>, Tag> getSupportedTypes() {
        TwoColumnTable<Class<?>, Tag> supportedTypes =
                TwoColumnHashTable.create();
        for (Row<Class<?>, Tag, ObjectProvider<?>> row : typeTable.rowSet()) {
            supportedTypes.append(row.getValue1(), row.getValue2());
        }
        return supportedTypes;
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T> T getObject(Class<T> type, Tag tag) throws FactoryException {

        ThreeColumnTable<Class<?>, Tag, ObjectProvider<?>> table =
                typeTable.select(type, null, null);

        int maxScore = Integer.MIN_VALUE;
        int count = 0;
        ObjectProvider<T> creator = null;

        // find the highest scoring match
        for (Row<Class<?>, Tag, ObjectProvider<?>> row : table.rowSet()) {

            int score = tagComparator.matchScore(row.getValue2(), tag);

            if (score > maxScore) {
                score = maxScore;
                creator = (ObjectProvider<T>) row.getValue3();
                count = 1;
            } else if (score == maxScore) {
                ++count;
            }
        }

        if (maxScore > Integer.MIN_VALUE) {
            if (count > 1) {
                throw new AmbiguousTypeException();
            }
            return creator.getObject();
        } else {
            throw new UnknownTypeException();
        }
    }

}
