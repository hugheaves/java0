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
 * @author Hugh Eaves
 * 
 */
public class Attribute implements Map<AttributeKey, Attribute> {

    /**
     * @see java.util.Map#size()
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * @see java.util.Map#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @see java.util.Map#containsKey(java.lang.Object)
     */
    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    /**
     * @see java.util.Map#containsValue(java.lang.Object)
     */
    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    /**
     * @see java.util.Map#get(java.lang.Object)
     */
    @Override
    public Attribute get(Object key) {
        return null;
    }

    /**
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    @Override
    public Attribute put(AttributeKey key, Attribute value) {
        return null;
    }

    /**
     * @see java.util.Map#remove(java.lang.Object)
     */
    @Override
    public Attribute remove(Object key) {
        return null;
    }

    /**
     * @see java.util.Map#putAll(java.util.Map)
     */
    @Override
    public void putAll(Map<? extends AttributeKey, ? extends Attribute> m) {
    }

    /**
     * @see java.util.Map#clear()
     */
    @Override
    public void clear() {
    }

    /**
     * @see java.util.Map#keySet()
     */
    @Override
    public Set<AttributeKey> keySet() {
        return null;
    }

    /**
     * @see java.util.Map#values()
     */
    @Override
    public Collection<Attribute> values() {
        return null;
    }

    /**
     * @see java.util.Map#entrySet()
     */
    @Override
    public Set<java.util.Map.Entry<AttributeKey, Attribute>> entrySet() {
        return null;
    }
}
