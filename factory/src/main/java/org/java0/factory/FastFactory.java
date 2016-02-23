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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.java0.core.exception.UncheckedException;
import org.java0.core.type.LongIdentified;
import org.java0.logging.Level;
import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

public class FastFactory {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(FastFactory.class.getName());

    /** The object cache. */
    private LongIdentified[][] objectCache;

    /** The providers. */
    private final Map<Long, Supplier<? extends LongIdentified>> suppliers = new HashMap<>();

    /** The create singleton. */
    private final Map<Long, Boolean> createSingleton = new HashMap<>();

    public static long GROUP_ID = 1L << Integer.SIZE;

    /**
     * Instantiates a new abstract id based factory.
     *
     * @param emptyObjects
     *            the empty objects
     */
    public FastFactory() {
        this.objectCache = new LongIdentified[0][0];
    }

    /**
     * Register provider.
     *
     * @param objectId
     *            the object id
     * @param provider
     *            the provider
     * @param singleton
     *            the singleton
     */
    public void registerProvider(final long id, final Supplier<? extends LongIdentified> supplier,
            final boolean singleton) {
        logger.log(Level.DEBUG, "register, longId = {}, groupId = {}, id = {}", id, (int) (id >>> Integer.SIZE),
                (int) id);
        checkCacheSize(id);
        createSingleton.put(id, singleton);
        final Supplier<?> oldSupplier = suppliers.put(id, supplier);
        if (oldSupplier != null) {
            throw new UncheckedException("Duplicate object id registered in factory, id = " + id + ", current class = "
                    + oldSupplier.get().getClass().getName() + ", new class = " + supplier.get().getClass().getName());
        }
    }

    /**
     * Register.
     *
     * @param object
     *            the object
     */
    public void register(final LongIdentified object) {
        final long id = object.getId();
        logger.log(Level.DEBUG, "register, longId = {}, groupId = {}, id = {}", id, (int) (id >>> Integer.SIZE),
                (int) id);

        registerProvider(id, new Supplier<LongIdentified>() {
            @Override
            public LongIdentified get() {
                return object;
            }
        }, true);
    }

    /**
     * Check cache size.
     *
     * @param id
     *            the id
     */
    protected void checkCacheSize(final long id) {
        final int groupId = (int) (id >>> Integer.SIZE);
        final int objectId = (int) id;

        logger.debug("checking cache size, id = {}, groupId = {}, objectId = {}, groupLength = {}", id, groupId,
                objectId, objectCache.length);

        if (objectCache.length <= groupId) {
            logger.debug("lengthing objectCache, newLength = {}", groupId + 1);
            objectCache = Arrays.copyOf(objectCache, groupId + 1);
            objectCache[groupId] = new LongIdentified[0];
        }
        if (objectCache[groupId].length <= objectId) {
            logger.debug("lengthing objectCache[{}], newLength = {}", groupId, objectId + 1);
            objectCache[groupId] = Arrays.copyOf(objectCache[groupId], objectId + 1);
        }

    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(final Class<T> type, final long id) throws FactoryException {
        assert (logger.log(Level.DEBUG, "getObject, longId = {}, groupId = {}, id = {}", id,
                (int) (id >>> Integer.SIZE), (int) id));

        final int groupId = (int) (id >>> Integer.SIZE);
        final int intId = (int) id;

        LongIdentified instance = objectCache[groupId][intId];
        if (instance == null) {
            final Supplier<? extends LongIdentified> supplier = suppliers.get(id);
            if (supplier != null) {
                logger.debug("Constructing new object for objectId {}", id);
                instance = supplier.get();
                logger.debug("Constructed new object {}", instance.toString());
                if (createSingleton.get(id)) {
                    objectCache[groupId][intId] = instance;
                }
            }
        }
        return (T) instance;
    }
}
