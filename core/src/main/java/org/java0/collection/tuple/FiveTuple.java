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
package org.java0.collection.tuple;

/**
 * @author Hugh Eaves
 *
 */
public class FiveTuple<T0, T1, T2, T3, T4> extends FourTuple<T0, T1, T2, T3> {

    public <V0 extends T0, V1 extends T1, V2 extends T2, V3 extends T3, V4 extends T4> FiveTuple(final V0 value0,
            final V1 value1, final V2 value2, final V3 value3, final V4 value4) {
        super(value0, value1, value2, value3, value4);
    }

    protected FiveTuple(final Object... values) {
        super(values);
    }

    @SuppressWarnings("unchecked")
    public T4 get4() {
        return (T4) this.get(4);
    }
}
