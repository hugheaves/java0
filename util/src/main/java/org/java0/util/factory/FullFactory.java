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

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.java0.util.collections.HashRowSet;
import org.java0.util.collections.RowSet;
import org.java0.util.collections.ThreeColumnRow;
import org.java0.util.collections.TwoColumnRow;
import org.java0.util.tag.DefaultTagComparator;
import org.java0.util.tag.Tag;
import org.java0.util.tag.TagComparator;

public class FullFactory extends AbstractFactory implements DelegableFactory,
        DelegatingFactory, NotifiableFactory, NotifyingFactory {
    private static Logger logger = Logger
            .getLogger(FullFactory.class.getName());

    protected final TagComparator tagComparator = new DefaultTagComparator();

    private final Set<NotifiableFactory> notifiableFactories = new HashSet<NotifiableFactory>();

    private final Set<DelegableFactory> delegableFactories = new LinkedHashSet<DelegableFactory>();

    private final RowSet<ThreeColumnRow<Class<?>, Tag, DelegableFactory>> typeTable = new HashRowSet<>();

    public FullFactory() {
        super();
    }

    public FullFactory(String name) {
        super(name);
    }

    @Override
    public void supportedTypesUpdated(DelegableFactory source,
            RowSet<TwoColumnRow<Class<?>, Tag>> typesAdded,
            RowSet<TwoColumnRow<Class<?>, Tag>> typesRemoved)
            throws InvalidOverrideException {
        logger.fine("Factory " + this.getClass().getName()
                + " received update notification from " + source);

        // Remove types that are no longer present
        for (TwoColumnRow<Class<?>, Tag> newType : typesAdded) {
            typeTable.add(new ThreeColumnRow<Class<?>, Tag, DelegableFactory>(
                    newType.getColumn1(), newType.getColumn2(), source));
        }

        // Add new types (or modify existing types)
        for (TwoColumnRow<Class<?>, Tag> newType : typesAdded) {
            typeTable.add(new ThreeColumnRow<Class<?>, Tag, DelegableFactory>(
                    newType.getColumn1(), newType.getColumn2(), source));
        }

        // TODO This is broken because it doesn't properly handle overridden
        // types
        // We may still be providing support for a type that was removed
        // from the DelegableFactory, if it is provided by another
        // DelegableFactory that is a child of this factory.
        for (NotifiableFactory notifiableFactory : notifiableFactories) {
            notifiableFactory.supportedTypesUpdated(this, typesAdded,
                    typesRemoved);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.java0.core.factory.DelegableFactory#getSupportedTypes()
     */
    @Override
    public RowSet<TwoColumnRow<Class<?>, Tag>> getSupportedTypes() {
        RowSet<TwoColumnRow<Class<?>, Tag>> supportedTypes = new HashRowSet<>();

        for (ThreeColumnRow<Class<?>, Tag, DelegableFactory> row : typeTable) {
            supportedTypes.add(row);
        }

        return supportedTypes;
    }

    /**
     * @see org.java0.util.factory.NotifyingFactory#
     *      addNotifiableFactory(org.java0.util.factory.NotifiableFactory)
     */
    @Override
    public void addNotifiableFactory(NotifiableFactory factory) {
        factory.supportedTypesUpdated(this, getSupportedTypes(), null);
        this.notifiableFactories.add(factory);
    }

    /**
     * @see org.java0.util.factory.NotifyingFactory#
     *      removeNotifiableFactory(org.java0.util.factory.NotifiableFactory)
     */
    @Override
    public void removeNotifiableFactory(NotifiableFactory factory) {
        factory.supportedTypesUpdated(this, null, getSupportedTypes());
        this.notifiableFactories.remove(factory);

    }

    @Override
    public void addDelegate(DelegableFactory factory) {
        logger.fine("Adding delegate " + factory.getClass().getName() + " to "
                + this.getName());
        delegableFactories.add(factory);
        supportedTypesUpdated(factory, factory.getSupportedTypes(), null);
    }

    @Override
    public void removeDelegate(DelegableFactory factory) {
        logger.fine("Removing delegate " + factory.getClass().getName()
                + " from " + this.getName());
        delegableFactories.remove(factory);
        supportedTypesUpdated(factory, null, factory.getSupportedTypes());
    }

    @Override
    public <T> T getObject(Class<T> type, Tag tag) throws FactoryException {

        RowSet<ThreeColumnRow<Class<?>, Tag, DelegableFactory>> table = typeTable
                .select(new ThreeColumnRow<Class<?>, Tag, DelegableFactory>(
                        type, tag, null));

        int maxScore = Integer.MIN_VALUE;
        int count = 0;
        Factory factory = null;

        // find the highest scoring match
        for (ThreeColumnRow<Class<?>, Tag, DelegableFactory> row : table) {

            int score = tagComparator.matchScore(row.getColumn2(), tag);

            if (score > maxScore) {
                score = maxScore;
                factory = row.getColumn3();
                count = 1;
            } else if (score == maxScore) {
                ++count;
            }
        }

        if (maxScore > Integer.MIN_VALUE) {
            if (count > 1) {
                throw new AmbiguousTypeException();
            }
            return factory.getObject(type, tag);
        } else {
            // No match found. If concrete type, try creating object using
            // default constructor.
            if (type.isLocalClass()) {
                try {
                    T object = type.newInstance();
                    logger.log(Level.INFO, "Instantiated " + type
                            + " using default constructor");
                    return object;
                } catch (InstantiationException e) {
                    logger.log(Level.SEVERE,
                            "Caught exception in auto-generated catch block", e);
                } catch (IllegalAccessException e) {
                    logger.log(Level.SEVERE,
                            "Caught exception in auto-generated catch block", e);
                }
            }
        }

        throw new UnknownTypeException("Unable to find type" + type.getName());
    }
}
