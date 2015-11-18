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

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Hugh Eaves
 *
 */
public class AbstractConfig<T> implements Config<T> {

	protected Map<Object, Object> values = new TreeMap<>();

	public AbstractConfig(Object... values) {
		int i = 0;
		for (Object value : values) {
			this.values.put(i++, value);
		}
	}

	/**
	 * @see org.java0.factory.Config#values()
	 */
	@Override
	public Object[] values() {
		return values.values().toArray();
	}

	/**
	 * @see org.java0.factory.Config#getValue(java.lang.String)
	 */
	@Override
	public Object getValue(Object key) {
		return values.get(key);
	}

	public void setValue(Object key, Object value) {
		values.put(key, value);
	}
}
