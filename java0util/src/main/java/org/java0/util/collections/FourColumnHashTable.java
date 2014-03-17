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

import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 */
public class FourColumnHashTable<T1, T2, T3, T4>
        extends
        AbstractHashTable<FourColumnTable.Row<T1, T2, T3, T4>, FourColumnTable<T1, T2, T3, T4>>
        implements FourColumnTable<T1, T2, T3, T4> {

    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(FourColumnHashTable.class
            .getName());

    private static final int COLUMNS = 4;

    public static class Row<T1, T2, T3, T4> extends
            ThreeColumnHashTable.Row<T1, T2, T3> implements
            FourColumnTable.Row<T1, T2, T3, T4> {

        public Row(T1 t1, T2 t2, T3 t3, T4 t4) {
            super(new Object[] { t1, t2, t3, t4 });
        }

        public static <T1, T2, T3, T4> Row<T1, T2, T3, T4> create(T1 t1, T2 t2, T3 t3, T4 t4) {
            return new Row<T1, T2, T3, T4>(t1, t2, t3, t4);
        }

        /**
         * Create a new FourColumnTableRow.
         *
         * @param values
         */
        public Row(Object[] values) {
            super(values);
        }

        /**
         * @see org.java0.util.collections.FourColumnTable.Row#getValue4()
         */
        @SuppressWarnings("unchecked")
        @Override
        public T4 getValue4() {
            return (T4) getValue(3);
        }
    }

    private FourColumnHashTable() {
        super(COLUMNS);
    }

    public static <T1, T2, T3, T4> FourColumnHashTable<T1, T2, T3, T4> create() {
        return new FourColumnHashTable<T1, T2, T3, T4>();
    }

    /**
     * @see org.java0.util.collections.FourColumnTable#append(java.lang.Object,
     *      java.lang.Object, java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean append(T1 t1, T2 t2, T3 t3, T4 t4) {
        return append(new Row<T1, T2, T3, T4>(t1, t2, t3, t4));
    }

    /**
     * @see org.java0.util.collections.FourColumnTable#exists(java.lang.Object,
     *      java.lang.Object, java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean exists(T1 t1, T2 t2, T3 t3, T4 t4) {
        return exists(new Row<T1, T2, T3, T4>(t1, t2, t3, t4));
    }

    /**
     * @see org.java0.util.collections.FourColumnTable#delete(java.lang.Object,
     *      java.lang.Object, java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean delete(T1 t1, T2 t2, T3 t3, T4 t4) {
        return delete(new Row<T1, T2, T3, T4>(t1, t2, t3, t4));
    }

    /**
     * @see org.java0.util.collections.AbstractHashTable#createRow(java.lang.Object[])
     */
    @Override
    protected FourColumnTable.Row<T1, T2, T3, T4> createRow(Object[] objects) {
        return new Row<T1, T2, T3, T4>(objects);
    }

    /**
     * @see org.java0.util.collections.FourColumnTable#select(java.lang.Object,
     *      java.lang.Object, java.lang.Object, java.lang.Object)
     */
    @Override
    public FourColumnTable<T1, T2, T3, T4> select(T1 t1, T2 t2, T3 t3, T4 t4) {
        return select(new Object[] { t1, t2, t3, t4 });
    }

    /**
     * @see org.java0.util.collections.AbstractHashTable#createTable()
     */
    @Override
    protected FourColumnTable<T1, T2, T3, T4> createTable() {
        return new FourColumnHashTable<T1, T2, T3, T4>();
    }
}
