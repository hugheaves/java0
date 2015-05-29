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

import org.java0.collection.rowset.HashRowSet;
import org.java0.collection.rowset.RowSet;
import org.java0.collection.rowset.ThreeColumnRow;
import org.java0.collection.rowset.TwoColumnRow;
import org.java0.tag.DefaultTagComparator;
import org.java0.tag.TagComparator;

/**
 * @author Hugh Eaves
 *
 */
public class AbstractDelegableFactory extends AbstractFactory implements
		DelegableFactory {

	protected final TagComparator tagComparator = new DefaultTagComparator();

	/**
     *
     */
	private final HashRowSet<ThreeColumnRow<Class<?>, Object, ObjectProvider<?>>> typeTable = new HashRowSet<>();

	protected AbstractDelegableFactory() {
		super(null);
	}

	protected AbstractDelegableFactory(String name) {
		super(name);
	}

	/**
	 * Adds a concrete type to the factory.
	 *
	 * @param concreteType
	 * @param singleton
	 */
	protected <T> void addType(Class<T> concreteType, boolean singleton) {
		addType(concreteType, null, new NewObjectProvider<T>(concreteType,
				singleton));
	}

	/**
	 * Adds a mapping from a lookup type to a concrete type.
	 *
	 * @param lookupType
	 * @param singleton
	 * @param concreteType
	 */
	protected <T> void addType(Class<T> lookupType, boolean singleton,
			Class<? extends T> concreteType) {
		addType(lookupType, null, new NewObjectProvider<T>(concreteType,
				singleton));
	}

	/**
	 *
	 * Adds a mapping from a lookup type to a concrete type with the specified
	 * constructor mappings.
	 *
	 * @param lookupType
	 * @param lookupTypeObject
	 * @param singleton
	 * @param concreteType
	 * @param constructorFields
	 */
	protected <T> void addType(Class<T> lookupType, Object selector,
			boolean singleton, Class<? extends T> concreteType,
			InjectableFields constructorFields) {
		typeTable.add(new ThreeColumnRow<Class<?>, Object, ObjectProvider<?>>(
				lookupType, selector, new InjectableProvider<T>(concreteType,
						null, singleton, constructorFields)));
	}

	/**
	 *
	 * Adds a mapping from a lookup type to a concrete type with the specified
	 * constructor mappings.
	 *
	 * @param lookupType
	 * @param lookupTypeObject
	 * @param singleton
	 * @param concreteType
	 * @param constructorProviders
	 */
	protected <T> void addType(Class<T> lookupType, Object selector,
			boolean singleton, Class<? extends T> concreteType,
			TypedObjectProvider<?>... constructorProviders) {
		typeTable.add(new ThreeColumnRow<Class<?>, Object, ObjectProvider<?>>(
				lookupType, selector, new NewObjectProvider<T>(concreteType,
						singleton, constructorProviders)));
	}

	/**
	 * @param lookupType
	 * @param lookupTypeObject
	 * @param singleton
	 * @param concreteType
	 */
	protected <T> void addType(Class<T> lookupType, Object selector,
			boolean singleton, Class<? extends T> concreteType) {
		typeTable.add(new ThreeColumnRow<Class<?>, Object, ObjectProvider<?>>(
				lookupType, selector, new NewObjectProvider<T>(concreteType,
						singleton)));
	}

	/**
	 * Adds a mapping from a type to an ObjectProvider for that type.
	 *
	 * @param lookupType
	 * @param provider
	 */
	protected <T> void addType(Class<T> lookupType, ObjectProvider<T> provider) {
		addType(lookupType, null, provider);
	}

	/**
	 *
	 * Adds a mapping from a lookup type and DisriminatorSet to an
	 * ObjectProvider.
	 *
	 * @param lookupType
	 * @param lookupTypeObject
	 * @param provider
	 */
	protected <T> void addType(Class<T> lookupType, Object selector,
			ObjectProvider<T> provider) {
		typeTable.add(new ThreeColumnRow<Class<?>, Object, ObjectProvider<?>>(
				lookupType, selector, provider));
	}

	/**
	 * @see org.java0.factory.DelegableFactory#getSupportedTypes()
	 */
	@Override
	public RowSet<TwoColumnRow<Class<?>, Object>> getSupportedTypes() {
		RowSet<TwoColumnRow<Class<?>, Object>> supportedTypes = new HashRowSet<>();
		for (ThreeColumnRow<Class<?>, Object, ObjectProvider<?>> row : typeTable) {
			supportedTypes.add(new TwoColumnRow<Class<?>, Object>(row
					.getColumn1(), row.getColumn2()));
		}
		return supportedTypes;
	}

	/**
	 * @see org.java0.factory.Factory#getObject(java.lang.Class,
	 *      org.java0.selector.Object, org.java0.factory.Config)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getObject(Class<T> type, Object selector, Config<T> config)
			throws FactoryException {

		RowSet<ThreeColumnRow<Class<?>, Object, ObjectProvider<?>>> table = typeTable
				.select(new ThreeColumnRow<Class<?>, Object, ObjectProvider<?>>(
						type, selector, null));

		int maxScore = Integer.MIN_VALUE;
		int count = 0;
		ObjectProvider<T> creator = null;

		// find the highest scoring match
		for (ThreeColumnRow<Class<?>, Object, ObjectProvider<?>> row : table) {

			int score = tagComparator.matchScore(row.getColumn2(), selector);

			if (score > maxScore) {
				maxScore = score;
				creator = (ObjectProvider<T>) row.getColumn3();
				count = 1;
			} else if (score == maxScore) {
				++count;
			}
		}

		if (maxScore > Integer.MIN_VALUE) {
			if (count > 1) {
				throw new AmbiguousTypeException();
			}
			if (creator instanceof ConfiguredObjectProvider) {
				return ((ConfiguredObjectProvider<T>) creator)
						.getObject(config);
			} else {
				return creator.getObject();
			}
		} else {
			throw new UnknownTypeException();
		}
	}

}
