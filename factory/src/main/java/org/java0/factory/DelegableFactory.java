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

import org.java0.collection.rowset.RowSet;
import org.java0.collection.rowset.TwoColumnRow;

public interface DelegableFactory extends Factory {
	/**
	 * Returns the types that this factory is able to create, along with the
	 * selector (if any) for those types
	 *
	 * @return
	 */
	public RowSet<TwoColumnRow<Class<?>, Object>> getSupportedTypes();
}
