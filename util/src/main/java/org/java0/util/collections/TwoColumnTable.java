/*
 * Copyright (C) 2014 Hugh Eaves
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.java0.util.collections;


/**
 * @author Hugh Eaves
 *
 */
public interface TwoColumnTable<T1, T2> extends Table<TwoColumnTable.Row<T1, T2>> {
    public interface Row<T1, T2> extends OneColumnTable.Row<T1> {
        public T2 getValue2();
    }

    public boolean append(T1 t1, T2 t2);

    public boolean exists(T1 t1, T2 t2);

    public boolean delete(T1 t1, T2 t2);

    public TwoColumnTable<T1, T2> select(T1 t1, T2 t2);
}
