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
package org.java0.factory;

import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 */
public class NewObjectProvider<T> extends AbstractTypedObjectProvider<T> {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(NewObjectProvider.class.getName());

	private TypedObjectProvider<?>[] constructorArgs = null;

	/**
	 * Holds the singleton instance, if needed.
	 */
	protected T instance;

	/**
	 * True if we should be creating a singleton.
	 */
	protected boolean singleton;

	/**
	 * Create a new NewObjectProvider.
	 *
	 * @param type
	 */
	protected NewObjectProvider(Class<? extends T> type, boolean singleton,
			TypedObjectProvider<?>... constructorArgs) {
		super(type);
		this.singleton = singleton;
		this.constructorArgs = constructorArgs;

	}

	/**
	 * @see org.java0.factory.ObjectProvider#getObject()
	 */
	@Override
	public T getObject() throws FactoryException {
		// Get the existing singleton instance (if any).
		T newInstance = instance;

		if (newInstance == null) {

			newInstance = FactoryUtil.createNewObject(type,
					getConstructorValues());

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
		Object constructorValues[] = new Object[constructorArgs.length];
		for (int i = 0; i < constructorArgs.length; ++i) {
			constructorValues[i] = constructorArgs[i].getObject();
		}
		return null;
	}

}
