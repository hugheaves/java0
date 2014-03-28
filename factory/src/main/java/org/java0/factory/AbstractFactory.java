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
 */
package org.java0.factory;

import org.java0.core.type.AbstractNamedObject;
import org.java0.tag.Tag;

/**
 * @author Hugh Eaves
 * 
 */
public abstract class AbstractFactory extends AbstractNamedObject implements
        Factory {
    /**
     * Create a new AbstractFactory.
     * 
     * @param name
     */
    public AbstractFactory(String name) {
        super(name);
    }

    /**
     * @see org.java0.factory.Factory#getObject(java.lang.Class)
     */
    @Override
    public <T> T getObject(Class<T> type) throws FactoryException {
        return getObject(type, null, null);
    }

    /**
     * @see org.java0.factory.Factory#getObject(java.lang.Class,
     *      org.java0.tag.Tag)
     */
    @Override
    public <T> T getObject(Class<T> type, Tag tag) throws FactoryException {
        return getObject(type, tag, null);
    }

    /**
     * @see org.java0.factory.Factory#getObject(java.lang.Class,
     *      org.java0.factory.Config)
     */
    @Override
    public <T> T getObject(Class<T> type, Config<T> config)
            throws FactoryException {
        return getObject(type, null, config);
    }
}
