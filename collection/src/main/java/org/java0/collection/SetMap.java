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
package org.java0.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * A map of sets. That is, a collection of sets of values of type "V", where
 * each set can be accessed using a key value of type "K".
 *
 * Basically, implements Map<K, Set<V>>, but adds a few methods for convenience.
 *
 * @author Hugh Eaves
 *
 * @param <K>
 *            the type of the key used for the map
 * @param <V>
 *            the type of entries in the set
 */
public interface SetMap<K, V> extends Map<K, Set<V>> {
    /**
     * Replace the current set of values (if any) mapped by key with a new set
     * of values.
     *
     * @param key
     *            The key
     * @param values
     *            The set of values
     * @return The old set of values mapped by that key, or null if no such set
     *         existed.
     */
    public Set<V> put(K key, Collection<V> values);

    /**
     * Adds a value to the set mapped by key. If the set mapped by key does not
     * currently exist, it is created.
     *
     * @param key
     *            The key for the set of values to which the new value should be
     *            added.
     * @param value
     *            The value to add.
     * @return true if the SetMap was modified as a result of this call
     */
    public boolean add(K key, V value);

    /**
     * Adds a collection of values to the set mapped by key. If the set mapped
     * by key does not currently exist, it is created.
     *
     * @param key
     *            The key for the set of values to which the new values should
     *            be added.
     * @param values
     *            The values that should be added to the set.
     * @return true if the SetMap was modified as a result of this call
     */
    public boolean add(K key, Collection<V> values);

    /**
     * Removes a value from the set of values mapped by key. If the resulting
     * set is empty, the empty set is removed from the map. (That is, subsequent
     * lookups of the set using this same key would return null).
     *
     * @param key
     *            The key for the set of values from which the value should be
     *            removed.
     * @param value
     *            The value to remove.
     * @return true if the SetMap was modified as a result of this call
     */
    public boolean remove(K key, V value);

    /**
     * Removes a collection of values from the set of values mapped by key. If
     * the resulting set is empty, the empty set is removed from the map. (That
     * is, subsequent lookups of the set using this same key would return null).
     *
     * @param key
     *            The key for the set of values from which the values should be
     *            removed.
     * @param values
     *            The values to remove.
     * @return true if the SetMap was modified as a result of this call
     */
    public boolean remove(K key, Collection<V> values);

    /**
     * Returns all the values in all sets of this SetMap.
     *
     * @return
     */
    public Collection<V> allValues();

    /**
     * Returns the backing map for this SetMap.
     *
     * @return
     */
    public  Map<K, Set<V>> getMap();


    /**
     * Returns the number of values contains in all sets of this SetMap
     *
     * @return
     */
    public int numVals();

}
