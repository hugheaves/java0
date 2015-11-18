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

import org.java0.tag.Tag;

/**
 * @author Hugh Eaves
 * 
 */
public class InjectableProvider<T> extends DefaultProvider<T> implements
        InjectableObject {
    private final InjectableFields fields;
    private InjectableValues values;

    public InjectableProvider(Class<? extends T> type, Tag tag,
            boolean singleton, InjectableFields fields) {
        super(type, tag, singleton);
        this.fields = fields;
    }

    /**
     * @see org.java0.factory.InjectableObject#getInjectableField()
     */
    @Override
    public InjectableFields getInjectableFields() {
        return fields;
    }

    /**
     * @see org.java0.factory.InjectableObject#setInjectableValues(org.java0.factory.InjectableValues)
     */
    @Override
    public void setInjectableValues(InjectableValues values) {
        this.values = values;
    }

    /**
     * @return
     */
    @Override
    protected Object[] getConstructorValues() {
        return values.getAll().values().toArray();
    }
}
