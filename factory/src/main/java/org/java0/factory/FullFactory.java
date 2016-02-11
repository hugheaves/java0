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

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.java0.collection.rowset.HashRowSet;
import org.java0.collection.rowset.RowSet;
import org.java0.collection.tuple.ThreeTuple;
import org.java0.collection.tuple.TwoTuple;
import org.java0.tag.DefaultTagComparator;
import org.java0.tag.TagComparator;

public class FullFactory extends AbstractFactory
        implements DelegableFactory, DelegatingFactory, NotifiableFactory, NotifyingFactory {
    private static Logger logger = Logger.getLogger(FullFactory.class.getName());

    protected final TagComparator tagComparator = new DefaultTagComparator();

    private final Set<NotifiableFactory> notifiableFactories = new HashSet<NotifiableFactory>();

    private final Set<DelegableFactory> delegableFactories = new LinkedHashSet<DelegableFactory>();

    private final RowSet<ThreeTuple<Class<?>, Object, DelegableFactory>> typeTable = new HashRowSet<>();

    public FullFactory() {
        super(FullFactory.class.getName());
    }

    public FullFactory(final String name) {
        super(name);
    }

    @Override
    public void supportedTypesUpdated(final DelegableFactory source,
            final RowSet<TwoTuple<Class<?>, Object>> typesAdded, final RowSet<TwoTuple<Class<?>, Object>> typesRemoved)
                    throws InvalidOverrideException {
        logger.fine("Factory " + this.getClass().getName() + " received update notification from " + source);

        // Remove types that are no longer present
        for (final TwoTuple<Class<?>, Object> newType : typesAdded) {
            typeTable.add(new ThreeTuple<Class<?>, Object, DelegableFactory>(newType.get0(), newType.get0(), source));
        }

        // Add new types (or modify existing types)
        for (final TwoTuple<Class<?>, Object> newType : typesAdded) {
            typeTable.add(new ThreeTuple<Class<?>, Object, DelegableFactory>(newType.get0(), newType.get0(), source));
        }

        // TODO This is broken because it doesn't properly handle overridden
        // types
        // We may still be providing support for a type that was removed
        // from the DelegableFactory, if it is provided by another
        // DelegableFactory that is a child of this factory.
        for (final NotifiableFactory notifiableFactory : notifiableFactories) {
            notifiableFactory.supportedTypesUpdated(this, typesAdded, typesRemoved);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.java0.core.factory.DelegableFactory#getSupportedTypes()
     */
    @Override
    public RowSet<TwoTuple<Class<?>, Object>> getSupportedTypes() {
        final RowSet<TwoTuple<Class<?>, Object>> supportedTypes = new HashRowSet<>();

        for (final ThreeTuple<Class<?>, Object, DelegableFactory> row : typeTable) {
            supportedTypes.add(row);
        }

        return supportedTypes;
    }

    /**
     * @see org.java0.factory.NotifyingFactory#
     *      addNotifiableFactory(org.java0.factory.NotifiableFactory)
     */
    @Override
    public void addNotifiableFactory(final NotifiableFactory factory) {
        factory.supportedTypesUpdated(this, getSupportedTypes(), null);
        this.notifiableFactories.add(factory);
    }

    /**
     * @see org.java0.factory.NotifyingFactory#
     *      removeNotifiableFactory(org.java0.factory.NotifiableFactory)
     */
    @Override
    public void removeNotifiableFactory(final NotifiableFactory factory) {
        factory.supportedTypesUpdated(this, null, getSupportedTypes());
        this.notifiableFactories.remove(factory);

    }

    @Override
    public void addDelegate(final DelegableFactory factory) {
        logger.fine("Adding delegate " + factory.getClass().getName() + " to " + this.getName());
        delegableFactories.add(factory);
        supportedTypesUpdated(factory, factory.getSupportedTypes(), null);
    }

    @Override
    public void removeDelegate(final DelegableFactory factory) {
        logger.fine("Removing delegate " + factory.getClass().getName() + " from " + this.getName());
        delegableFactories.remove(factory);
        supportedTypesUpdated(factory, null, factory.getSupportedTypes());
    }

    /**
     * @see org.java0.factory.Factory#getObject(java.lang.Class,
     *      org.java0.selector.Object, org.java0.factory.Config)
     */
    @Override
    public <T> T getObject(final Class<T> type, final Object selector, final Config<T> config) throws FactoryException {
        final RowSet<ThreeTuple<Class<?>, Object, DelegableFactory>> table = typeTable
                .select(new ThreeTuple<Class<?>, Object, DelegableFactory>(type, selector, null));

        final int maxScore = Integer.MIN_VALUE;
        int count = 0;
        Factory factory = null;

        // find the highest scoring match
        for (final ThreeTuple<Class<?>, Object, DelegableFactory> row : table) {

            int score = tagComparator.matchScore(row.get0(), selector);

            if (score > maxScore) {
                score = maxScore;
                factory = row.get2();
                count = 1;
            } else if (score == maxScore) {
                ++count;
            }
        }

        if (maxScore > Integer.MIN_VALUE) {
            if (count > 1) {
                throw new AmbiguousTypeException();
            }
            return factory.getObject(type, selector, config);
        } else {
            // No match found. If concrete type, try creating object using
            // default constructor.
            if (type.isLocalClass()) {
                try {
                    final T object = type.newInstance();
                    logger.log(Level.INFO, "Instantiated " + type + " using default constructor");
                    return object;
                } catch (final InstantiationException e) {
                    logger.log(Level.SEVERE, "Caught exception in auto-generated catch block", e);
                } catch (final IllegalAccessException e) {
                    logger.log(Level.SEVERE, "Caught exception in auto-generated catch block", e);
                }
            }
        }

        throw new UnknownTypeException("Unable to find type" + type.getName());

    }

}
