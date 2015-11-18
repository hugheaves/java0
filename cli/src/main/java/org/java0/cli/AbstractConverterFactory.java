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
package org.java0.cli;

import java.util.HashMap;
import java.util.Map;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating AbstractConverter objectCache.
 */
@SuppressWarnings("rawtypes")
public class AbstractConverterFactory implements IStringConverterFactory {

	/**
	 * A map of converters per class.
	 */
	private static Map<Class, Class<? extends IStringConverter<?>>> converters = new HashMap<Class, Class<? extends IStringConverter<?>>>();

	/**
	 * Adds the converter.
	 *
	 * @param resultClass
	 *            the result class
	 * @param converterClass
	 *            the converter class
	 */
	protected static void addConverter(Class resultClass,
			Class<? extends IStringConverter<?>> converterClass) {
		converters.put(resultClass, converterClass);
	}

	/**
	 * @see com.beust.jcommander.IStringConverterFactory#getConverter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Class<? extends IStringConverter<?>> getConverter(Class forType) {
		return converters.get(forType);
	}

}
