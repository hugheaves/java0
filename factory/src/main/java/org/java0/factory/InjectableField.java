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
package org.java0.factory;

import org.java0.core.type.AbstractNamedObject;
import org.java0.tag.Tag;

/**
 * @author Hugh Eaves
 *
 */
public final class InjectableField extends AbstractNamedObject {

    private final Class<?> type;
    private final Tag tag;

    /**
     * Create a new InjectableType.
     *
     * @param type
     */
    public InjectableField(String name, Class<?> type) {
       this(name, type, null);
    }

    /**
     * Create a new InjectableType.
     *
     * @param type
     * @param tag
     */
    public InjectableField(String name, Class<?> type, Tag tag) {
        super(name);
        this.type = type;
        this.tag = tag;
    }

    public Class<?> getType() {
        return type;
    }

    public Tag getTag() {
        return tag;
    }

}
