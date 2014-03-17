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
package org.java0.basetypes;

import java.util.logging.Logger;

/**
 * Abstract class implementing {@link NamedObject}.
 *
 * @author Hugh Eaves
 *
 */
public abstract class AbstractNamedObject implements NamedObject {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(AbstractNamedObject.class
            .getName());

    protected String name;

    public AbstractNamedObject() {
        this.name = null;
    }

    public AbstractNamedObject(String name) {
        this.name = name;
    }

    /**
     * @see org.java0.basetypes.NamedObject#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NamedObject) {
            if (getName().equals(((NamedObject) obj).getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Named Object: " + getName();
    }
}
