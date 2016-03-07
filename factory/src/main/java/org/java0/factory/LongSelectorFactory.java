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
import org.java0.util.bits.Masks;

public class LongSelectorFactory implements Factory {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(LongSelectorFactory.class.getName());

    /** The object cache. */
    private LongIdentified[][] objectCache;

    /** The suppliers. */
    private final Map<Long, Supplier<? extends LongIdentified>> suppliers = new HashMap<>();

    /** The create singleton. */
    private final Map<Long, Boolean> createSingleton = new HashMap<>();

    // TODO Create faster hash implementation
    private final Map<Class<?>, Long> defaultTypes = new HashMap<>();

    public final int objectIdBits;
    public final long objectIdMask;

    /**
     * Instantiates a new abstract id based factory.
     *
     * @param emptyObjects
     *            the empty objects
     */
    public LongSelectorFactory(final int objectIdBits) {
        this.objectCache = new LongIdentified[0][0];
        this.objectIdBits = objectIdBits;
        this.objectIdMask = Masks.LOW_ORDER_LONG_MASK[objectIdBits];
    }

    public void setDefaultType(final Class<?> cls, final long selector) {
        if (suppliers.get(selector) == null) {
            throw new UncheckedException(
                    "Can't set default for type not already registered. Missing selector = " + selector);
        }
        final Long previousDefault = defaultTypes.put(cls, selector);
        if (previousDefault != null) {
            logger.warn("Overriding previous default type, previous selector = {}, current selector = {}",
                    previousDefault, selector);
        }
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
    public void registerProvider(final long selector, final Supplier<? extends LongIdentified> supplier,
            final boolean singleton) {

        final int groupId = (int) (selector >>> objectIdBits);
        final int objectId = (int) (selector & objectIdMask);

        logger.log(Level.DEBUG,
                "registerProvider: selector = {}, groupId = {}, objectId = {}, supplier = {}, singleton = {}", selector,
                groupId, objectId, supplier, singleton);

        checkCacheSize(selector);
        createSingleton.put(selector, singleton);
        final Supplier<?> oldSupplier = suppliers.put(selector, supplier);
        if (oldSupplier != null) {
            throw new UncheckedException("Duplicate object id registered in factory, id = " + selector
                    + ", current class = " + oldSupplier.get().getClass().getName() + ", new class = "
                    + supplier.get().getClass().getName());
        }
    }

    /**
     * Register.
     *
     * @param object
     *            the object
     */
    public void register(final LongIdentified object) {
        final long selector = object.getId();

        final int groupId = (int) (selector >>> objectIdBits);
        final int objectId = (int) (selector & objectIdMask);

        logger.log(Level.DEBUG, "register: selector = {}, groupId = {}, objectId = {}, object = {}, object class = {}",
                selector, groupId, objectId, object, object.getClass().getName());

        registerProvider(selector, new Supplier<LongIdentified>() {
            @Override
            public LongIdentified get() {
                return object;
            }
        }, true);

        setDefaultType(object.getClass(), selector);
    }

    /**
     * Check cache size.
     *
     * @param selector
     *            the id
     */
    protected void checkCacheSize(final long selector) {
        final int groupId = (int) (selector >>> objectIdBits);
        final int objectId = (int) (selector & objectIdMask);

        logger.log(Level.DEBUG, "checkCacheSize: selector = {}, groupId = {}, objectId = {}", selector, groupId,
                objectId);

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
    public <T> T getObject(final Class<T> type, final long selector) throws FactoryException {
        final int groupId = (int) (selector >>> objectIdBits);
        final int objectId = (int) (selector & objectIdMask);

        assert (logger.log(Level.DEBUG, "getObject: type = {}, selector = {}, groupId = {}, objectId = {}",
                type.getName(), selector, groupId, objectId));

        LongIdentified instance;

        try {
            instance = objectCache[groupId][objectId];
        } catch (final ArrayIndexOutOfBoundsException e) {
            throw new FactoryException("Object for selector " + selector + " not found");
        }

        if (instance == null) {
            final Supplier<? extends LongIdentified> supplier = suppliers.get(selector);
            if (supplier != null) {
                logger.debug("Constructing new object for objectId {}", selector);
                instance = supplier.get();
                logger.debug("Constructed new object {}", instance.toString());
                if (createSingleton.get(selector)) {
                    objectCache[groupId][objectId] = instance;
                }
            } else {
                throw new FactoryException("Object for selector " + selector + " not found");
            }
        }

        return (T) instance;
    }

    @Override
    public <T> T getObject(final Class<T> type) throws FactoryException {
        return getObject(type, defaultTypes.get(type));
    }

    @Override
    public <T> T getObject(final Class<T> type, final Object selector) throws FactoryException {
        return getObject(type, (long) selector);
    }

    @Override
    public <T> T getObject(final Class<T> type, final Object selector, final Config<T> config) throws FactoryException {
        // TODO for now
        throw new UnsupportedOperationException("requesting objects with a configuration not supported");
    }
}
