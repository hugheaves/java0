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

import java.util.logging.Logger;

import org.java0.tag.Tag;

/**
 * @author Hugh Eaves
 *
 * @param <T>
 */
public class DefaultProvider<T> extends AbstractTypedObjectProvider<T> {
	private static final Logger logger = Logger.getLogger(DefaultProvider.class
			.getName());

	/**
	 * Holds the singleton instance, if needed.
	 */
	protected T instance;

	/**
	 * True if we should be creating a singleton.
	 */
	protected boolean singleton;

	protected Tag tag;

	public DefaultProvider(Class<? extends T> type, boolean singleton) {
		this(type, null, singleton);
	}

	public DefaultProvider(Class<? extends T> type, Tag tag) {
		this(type, null, false);
	}

	public DefaultProvider(Class<? extends T> type, Tag tag, boolean singleton) {
		super(type);
		this.tag = tag;
		this.singleton = singleton;
	}

	@Override
	public T getObject() {
		// Get the existing singleton instance (if any).
		T newInstance = instance;

		if (newInstance == null) {
			// First, try getting the object from the root factory
			try {
				newInstance = FactoryManager.getRootFactory().getObject(type,
						tag);
			} catch (FactoryException e) {
				logger.info("Type " + type.getName() + " not found in factory.");
			}

			// If that didn't work, try creating the type directly.
			if (newInstance == null) {
				newInstance = FactoryUtil.createNewObject(type,
						getConstructorValues());
			}
		}

		// If this is supposed to be a singleton instance, store the singleton
		// for next invocation.
		if (singleton) {
			instance = newInstance;
		}

		return newInstance;
	}

	/**
	 * @return
	 */
	protected Object[] getConstructorValues() {
		return null;
	}

}
