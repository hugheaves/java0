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
 *
 */
package org.java0.util.tag;


/**
 * A class that should be applied to entities that are in a different JVM.
 *
 * @author Hugh Eaves
 *
 */
public class SeparateJVMTag extends JVMProximityTag {
    /**
     * Static instance of this Tag.
     */

    public static final SeparateJVMTag INSTANCE = new SeparateJVMTag();

    /**
     * Create a new SeperateJVMTag.
     *
     * @param value
     */
    private SeparateJVMTag() {
        super(SeparateJVMTag.class);

    }
}
