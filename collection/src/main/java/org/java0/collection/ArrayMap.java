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

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.java0.core.type.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Hugh Eaves
 *
 */
public class ArrayMap<K, V> implements Map<K, V> {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ArrayMap.class
			.getName());

	private static final int INITIAL_CAPACITY = 4;

	protected Object elements[] = Constants.EMPTY_OBJECT_ARRAY;

	/*
	 * Number of empty elements in the array
	 */
	private int emptyElements;

	/*
	 * Index of first unused element in array
	 */
	private int lastElement;

	public ArrayMap() {

	}

	public ArrayMap(int capacity) {
		elements = new Object[capacity * 2];
		lastElement = 0;
		emptyElements = 0;
	}

	public abstract class ArrayMapAbstractIterator<T> implements Iterator<T> {
		private int position = 0;
		private boolean nextCalled = false;

		/**
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			while (position < lastElement && elements[position] == null) {
				position += 2;
			}
			if (position >= lastElement) {
				return false;
			}
			return true;
		}

		/**
		 * @see java.util.Iterator#next()
		 */
		@Override
		public T next() {
			if (position >= lastElement) {
				throw new NoSuchElementException();
			}
			nextCalled = true;
			T value = getValueAt(position);
			position += 2;
			return value;
		}

		protected abstract T getValueAt(int position);

		/**
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			if (!nextCalled) {
				throw new IllegalStateException();
			}
			nextCalled = false;
			elements[position - 1] = null;
			elements[position - 2] = null;
			emptyElements += 2;
		}
	}

	protected class ArrayMapCollectionIterator extends
			ArrayMapAbstractIterator<V> {
		/**
		 * @see org.java0.collection.ArrayMap.ArrayMapAbstractIterator#getValueAt(int)
		 */
		@Override
		@SuppressWarnings("unchecked")
		protected V getValueAt(int position) {
			return (V) elements[position + 1];
		}

	}

	protected class ArrayMapValueCollection extends AbstractCollection<V> {
		/**
		 * @see java.util.AbstractCollection#iterator()
		 */
		@Override
		public Iterator<V> iterator() {
			return new ArrayMapCollectionIterator();
		}

		/**
		 * @see java.util.AbstractCollection#size()
		 */
		@Override
		public int size() {
			return ArrayMap.this.size();
		}

	}

	protected class ArrayMapKeySetIterator extends ArrayMapAbstractIterator<K> {
		/**
		 * @see org.java0.collection.ArrayMap.ArrayMapAbstractIterator#getValueAt(int)
		 */
		@SuppressWarnings("unchecked")
		@Override
		protected K getValueAt(int position) {
			return (K) elements[position];
		}

	}

	protected class ArrayMapKeySet extends AbstractSet<K> {

		/**
		 * @see java.util.AbstractCollection#iterator()
		 */
		@Override
		public Iterator<K> iterator() {
			return new ArrayMapKeySetIterator();
		}

		/**
		 * @see java.util.AbstractCollection#size()
		 */
		@Override
		public int size() {
			return ArrayMap.this.size();
		}

	}

	protected class ArrayMapEntry implements Entry<K, V> {
		int position;

		ArrayMapEntry(int position) {
			this.position = position;
		}

		/**
		 * @see java.util.Map.Entry#getKey()
		 */
		@SuppressWarnings("unchecked")
		@Override
		public K getKey() {
			return (K) elements[position];
		}

		/**
		 * @see java.util.Map.Entry#getValue()
		 */
		@SuppressWarnings("unchecked")
		@Override
		public V getValue() {
			return (V) elements[position + 1];
		}

		/**
		 * @see java.util.Map.Entry#setValue(java.lang.Object)
		 */
		@Override
		public V setValue(V value) {
			@SuppressWarnings("unchecked")
			V oldValue = (V) elements[position + 1];
			elements[position + 1] = value;
			return oldValue;
		}

		@Override
		public boolean equals(Object object) {
			if (object == this) {
				return true;
			}
			if (!(object instanceof Entry)) {
				return false;
			}
			@SuppressWarnings("unchecked")
			Entry<K, V> entry = (Entry<K, V>) object;
			if (!getKey().equals(entry.getKey())) {
				return false;
			}
			if (getValue() == entry.getValue()) {
				return true;
			}
			if (getValue() != null && getValue().equals(entry.getValue())) {
				return true;
			}

			return false;
		}

		@Override
		public int hashCode() {
			int hashCode = getKey().hashCode();
			if (getValue() != null) {
				hashCode ^= getValue().hashCode();
			}
			return hashCode;
		}

		@Override
		public String toString() {
			return getKey() + "=" + getValue();
		}
	}

	public class ArrayMapEntrySet extends AbstractSet<Entry<K, V>> {
		/**
		 * @return
		 * @see java.util.Map#size()
		 */
		@Override
		public int size() {
			return ArrayMap.this.size();
		}

		@Override
		public void clear() {
			ArrayMap.this.clear();
		}

		/**
		 * @see java.util.AbstractCollection#iterator()
		 */
		@Override
		public Iterator<Entry<K, V>> iterator() {
			return new ArrayMapEntryIterator();
		}
	}

	public class ArrayMapEntryIterator extends
			ArrayMapAbstractIterator<Entry<K, V>> {
		/**
		 * @see org.java0.collection.ArrayMap.ArrayMapAbstractIterator#getValueAt(int)
		 */
		@Override
		protected Entry<K, V> getValueAt(int position) {
			return new ArrayMapEntry(position);
		}

	}

	private final int keyLocation(Object key) {
		for (int i = 0; i < elements.length; i += 2) {
			if (key.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @see java.util.Map#size()
	 */
	@Override
	public int size() {
		return (lastElement - emptyElements) / 2;
	}

	/**
	 * @see java.util.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	/**
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object key) {
		return (keyLocation(key) != -1);

	}

	/**
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object value) {
		for (int i = 0; i < lastElement; i += 2) {
			if (elements[i] != null) {
				if (elements[i + 1] == value) {
					return true;
				}
				if (value != null && value.equals(elements[i + 1])) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {
		int i = keyLocation(key);
		if (i != -1) {
			return (V) elements[i + 1];
		}

		return null;
	}

	@Override
	public V put(K key, V value) {
		if (key == null) {
			throw new NullPointerException("Null key value unsupported");
		}
		int nullPos = -1;
		for (int i = 0; i < lastElement; i += 2) {
			if (elements[i] == null) {
				nullPos = i;
			} else if (elements[i].equals(key)) {
				@SuppressWarnings("unchecked")
				V oldVal = (V) elements[i + 1];
				elements[i + 1] = value;
				return oldVal;
			}
		}

		if (nullPos != -1) {
			elements[nullPos] = key;
			elements[nullPos + 1] = value;
			--emptyElements;
		} else if (lastElement < elements.length) {
			elements[lastElement++] = key;
			elements[lastElement++] = value;
		} else {
			expandArray();
			elements[lastElement++] = key;
			elements[lastElement++] = value;
		}
		return null;
	}

	private void expandArray() {
		Object newElements[];
		if (elements.length == 0) {
			newElements = new Object[INITIAL_CAPACITY];
		} else {
			newElements = new Object[elements.length * 2];
		}
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		elements = newElements;
	}

	@Override
	public void clear() {
		elements = Constants.EMPTY_OBJECT_ARRAY;
		lastElement = 0;
		emptyElements = 0;
	}

	/**
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object key) {
		int i = keyLocation(key);
		V oldVal = null;
		if (i != -1) {
			oldVal = (V) elements[i + 1];
			elements[i + 1] = null;
			elements[i] = null;
			emptyElements += 2;
		}
		return oldVal;

	}

	/**
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {

		for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}

	}

	/**
	 * @return
	 * @param this that
	 * @see java.util.Map#keySet()
	 */
	@Override
	public Set<K> keySet() {
		return new ArrayMapKeySet();
	}

	/**
	 * @see java.util.Map#values()
	 */
	@Override
	public Collection<V> values() {
		return new ArrayMapValueCollection();
	}

	/**
	 * @see java.util.Map#entrySet()
	 */
	@Override
	public Set<Entry<K, V>> entrySet() {
		return new ArrayMapEntrySet();
	}

	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}

		if (!(object instanceof Map)) {
			return false;
		}

		Map<?, ?> map = (Map<?, ?>) object;
		if (map.size() != size()) {
			return false;
		}

		for (Entry<K, V> entry : entrySet()) {
			K key = entry.getKey();
			V value = entry.getValue();
			// check for null value stored in map
			if (value == null) {
				if (!(map.get(key) == null && map.containsKey(key)))
					return false;
			} else {
				if (!value.equals(map.get(key)))
					return false;
			}
		}

		return true;
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		for (int i = 0; i < lastElement; i += 2) {
			if (elements[i] != null) {
				int elementHash = elements[i].hashCode();
				if (elements[i + 1] != null) {
					elementHash ^= elements[i + 1].hashCode();
				}
				hashCode = hashCode + elementHash;
			}
		}
		return hashCode;

	}

	@Override
	public String toString() {
		Iterator<Entry<K, V>> i = entrySet().iterator();
		if (!i.hasNext())
			return "{}";

		StringBuilder sb = new StringBuilder();
		sb.append('{');
		for (;;) {
			Entry<K, V> e = i.next();
			K key = e.getKey();
			V value = e.getValue();
			sb.append(key == this ? "(this Map)" : key);
			sb.append('=');
			sb.append(value == this ? "(this Map)" : value);
			if (!i.hasNext())
				return sb.append('}').toString();
			sb.append(',').append(' ');
		}
	}

}
