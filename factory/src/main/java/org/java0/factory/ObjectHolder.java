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

import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 */
public class ObjectHolder<T> implements TypedObjectProvider<T> {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(ObjectHolder.class.getName());

    private final T value;

    public ObjectHolder(final T value) {
        this.value = value;
    }

    @Override
    public T get() throws FactoryException {
        return value;
    }

    /**
     * @see org.java0.factory.ObjectProvider#getType()
     */
    @SuppressWarnings("unchecked")
    @Override
    public Class<? extends T> getType() {
        return (Class<? extends T>) value.getClass();
    }

}