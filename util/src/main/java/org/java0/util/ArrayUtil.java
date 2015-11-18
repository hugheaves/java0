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
package org.java0.util;

import java.lang.reflect.Array;
import java.util.function.IntFunction;

/**
 * @author Hugh Eaves
 *
 */
public class ArrayUtil {
	public static <T> T[] newArray(Class<T> type, int length,
			IntFunction<T> initializer) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(type, length);
		for (int i = 0; i < length; ++i) {
			array[i] = initializer.apply(i);
		}
		return array;
	}
}
