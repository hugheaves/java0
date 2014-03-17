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
package org.java0.util.factory;

import java.util.logging.Logger;

import org.java0.basetypes.AbstractNamedObject;

/**
 * @author Hugh Eaves
 *
 */
public abstract class AbstractFactory extends AbstractNamedObject implements Factory {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(AbstractFactory.class
            .getName());

    /**
     * Create a new AbstractFactory.
     *
     * @param name
     */
    public AbstractFactory(String name) {
        super(name);
    }

    /**
     * Create a new AbstractFactory.
     *
     * @param name
     */
    public AbstractFactory() {
        super();
        setName(getClass().getName());
    }

    /**
     * @see org.java0.util.factory.Factory#getObject(java.lang.Class)
     */
    @Override
    public <T> T getObject(Class<T> type) throws FactoryException {
        return getObject(type, null);
    }
}
