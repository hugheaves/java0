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

public interface Factory {

	/**
	 * Obtains an object of the specified type (or a subtype of the specified
	 * type).
	 *
	 * @param type
	 * @return
	 * @throws FactoryException
	 */
	public default <T> T getObject(Class<T> type) throws FactoryException {
		return getObject(type, null, (Config<T>) null);
	}

	/**
	 * Obtains an object of the specified type (or a subtype of the specified
	 * type) selected using the given selector.
	 *
	 * @param type
	 * @param selector
	 * @return
	 * @throws FactoryException
	 */
	public default <T> T getObject(Class<T> type, Object selector)
			throws FactoryException {
		return getObject(type, selector, (Config<T>) null);
	}

	/**
	 * Obtains an object of the specified type (or a subtype of the specified
	 * type) created using the given config.
	 *
	 * @param type
	 * @param config
	 * @return
	 * @throws FactoryException
	 */
	public default <T> T getObject(Class<T> type, Config<T> config)
			throws FactoryException {
		return getObject(type, null, config);
	}

	/**
	 * Obtains an object of the specified type (or a subtype of the specified
	 * type) selected using the given tag, and created using the given config.
	 *
	 * @param type
	 * @param tag
	 * @param config
	 * @return
	 * @throws FactoryException
	 */
	public <T> T getObject(Class<T> type, Object selector, Config<T> config)
			throws FactoryException;

}
