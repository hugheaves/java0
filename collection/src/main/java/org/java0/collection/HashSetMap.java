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
package org.java0.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 * @param <K>
 * @param <V>
 */
public class HashSetMap<K, V> extends AbstractSetMap<K, V> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(HashSetMap.class
            .getName());

    /**
     * Create a new HashSetMap.
     *
     * @param map
     * @param setMap
     * @param deepCopySets
     */
    public HashSetMap(SetMap<K, V> setMap,
            boolean deepCopySets) {
        super(new HashMap<K, Set<V>>(), setMap, deepCopySets);
    }

    /**
     * Create a new HashSetMap.
     *
     * @param map
     * @param setMap
     */
    public HashSetMap(SetMap<K, V> setMap) {
        super(new HashMap<K, Set<V>>(), setMap);
    }

    /**
     * Create a new HashSetMap.
     *
     * @param map
     */
    public HashSetMap() {
        super(new HashMap<K, Set<V>>());
    }


    /**
     * @see org.java0.collection.AbstractSetMap#newSet()
     */
    @Override
    protected Set<V> newSet() {
        return new HashSet<>();
    }

}
