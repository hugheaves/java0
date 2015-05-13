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
package org.java0.collection.setmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 */
public abstract class AbstractSetMap<K, V> implements SetMap<K, V> {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(AbstractSetMap.class
			.getName());

	private final Map<K, Set<V>> map;

	protected AbstractSetMap(Map<K, Set<V>> map) {
		this.map = map;
	}

	/*
	 * Create a copy of an existing SetMap. A new map will be created, to hold
	 * the sets, but the existing sets are added to the new map directly. (No
	 * deep copy of the sets is made).
	 * 
	 * @param setMap the set to copy
	 */
	protected AbstractSetMap(Map<K, Set<V>> map, SetMap<K, V> setMap) {
		this(map);
		for (Entry<K, Set<V>> entry : setMap.entrySet()) {
			map.put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Create a copy of an existing SetMap. A new map is created. If
	 * deepCopySets is false, the sets will be added directly to the new map.
	 * (i.e. no copy of the sets is made). If deepCopySets is true, a deep copy
	 * will be made of each set before it is added to the new map.
	 *
	 * @param setMap
	 *            the set to copy
	 * @param deepCopySets
	 *            true to make a deep copy of the sets
	 */
	public AbstractSetMap(Map<K, Set<V>> map, SetMap<K, V> setMap,
			boolean deepCopySets) {
		this(map);
		for (Entry<K, Set<V>> entry : setMap.entrySet()) {
			if (deepCopySets) {
				map.put(entry.getKey(), newSet(entry.getValue()));
			} else {
				map.put(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * @see org.java0.collection.setmap.SetMap#add(java.lang.Object,
	 *      java.util.Collection)
	 */
	@Override
	public boolean add(K key, Collection<V> values) {
		boolean modified = false;
		Set<V> set = get(key);
		if (set == null) {
			set = newSet(values);
			map.put(key, set);
			modified = true;
		} else {
			modified = set.addAll(values);
		}
		return modified;
	}

	/**
	 * @see org.java0.collection.setmap.SetMap#add(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean add(K key, V value) {
		boolean modified = false;
		Set<V> set = get(key);
		if (set == null) {
			set = newSet(value);
			map.put(key, set);
			modified = true;
		} else {
			modified = set.add(value);
		}
		return modified;
	}

	/**
	 * @see org.java0.collection.setmap.SetMap#allValues()
	 */
	@Override
	public Collection<V> allValues() {
		Collection<V> values = new ArrayList<V>(size());
		for (Set<V> valueSet : map.values()) {
			values.addAll(valueSet);
		}
		return values;
	}

	/**
	 * @see java.util.Map#clear()
	 */
	@Override
	public void clear() {
		map.clear();
	}

	/**
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	/**
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	/**
	 * @see java.util.Map#entrySet()
	 */
	@Override
	public Set<java.util.Map.Entry<K, Set<V>>> entrySet() {
		return map.entrySet();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object instanceof Map) {
			Map<?, ?> objectMap = (Map<?, ?>) object;
			return map.equals(objectMap);
		} else if (object instanceof SetMap) {
			SetMap<?, ?> setMap = (SetMap<?, ?>) object;
			return map.equals(setMap.getMap());
		}
		return false;
	}

	/**
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@Override
	public Set<V> get(Object key) {
		return map.get(key);
	}

	/**
	 * @see org.java0.collection.setmap.SetMap#getMap()
	 */
	@Override
	public Map<K, Set<V>> getMap() {
		return map;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return map.hashCode();
	}

	/**
	 * @see java.util.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		for (Set<V> valueSet : map.values()) {
			if (!valueSet.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @see java.util.Map#keySet()
	 */
	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	protected abstract Set<V> newSet();

	/**
	 * @param values
	 * @return
	 */
	protected Set<V> newSet(Collection<V> values) {
		Set<V> set = newSet();
		set.addAll(values);
		return set;
	}

	/**
	 * @param value
	 * @return
	 */
	protected Set<V> newSet(V value) {
		Set<V> set = newSet();
		set.add(value);
		return set;
	}

	/**
	 * @see org.java0.collection.setmap.SetMap#numVals()
	 */
	@Override
	public int numVals() {
		int size = 0;
		for (Set<V> value : map.values()) {
			size += value.size();
		}
		return size;
	}

	/**
	 * @see org.java0.collection.setmap.SetMap#put(java.lang.Object,
	 *      java.util.Collection)
	 */
	@Override
	public Set<V> put(K key, Collection<V> values) {
		return map.put(key, newSet(values));
	}

	/**
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Set<V> put(K key, Set<V> value) {
		return map.put(key, value);
	}

	/**
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends K, ? extends Set<V>> m) {
		map.putAll(m);
	}

	/**
	 * @see org.java0.collection.setmap.SetMap#remove(java.lang.Object,
	 *      java.util.Collection)
	 */
	@Override
	public boolean remove(K key, Collection<V> values) {
		boolean modified = false;
		Set<V> set = get(key);
		if (set != null) {
			modified = set.removeAll(values);
			if (set.isEmpty()) {
				map.remove(key);
			}
			set = null;
		}
		return modified;
	}

	/**
	 * @see org.java0.collection.setmap.SetMap#remove(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public boolean removeValue(K key, V value) {
		boolean modified = false;
		Set<V> set = get(key);
		if (set != null) {
			modified = set.remove(value);
			if (set.isEmpty()) {
				map.remove(key);
			}
			set = null;
		}
		return modified;
	}

	/**
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@Override
	public Set<V> remove(Object key) {
		return map.remove(key);
	}

	/**
	 * @see java.util.Map#size()
	 */
	@Override
	public int size() {
		return map.size();
	}

	@Override
	public String toString() {
		return map.toString();
	}

	/**
	 * @see java.util.Map#values()
	 */
	@Override
	public Collection<Set<V>> values() {
		return map.values();
	}
}
