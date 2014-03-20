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

import java.util.Set;

/**
 * A RowSet is a Set that of Rows that defines some additional "associative"
 * operations on the set.
 *
 * @author Hugh Eaves
 *
 */
public interface RowSet<R> extends Set<R> {
    /**
     * @param row
     * @param keyColumn
     * @return
     */
    RowSet<R> select(R row, boolean... keyColumn);

 //   public <T extends R> void addRow(T row);
}
