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
package org.java0.io;

/**
 * @author Hugh Eaves
 * 
 */
public class WritableChannelIdImpl<T> extends ChannelIdImpl<T> implements
        WritableChannelId<T> {
    /**
     * Create a new WritableChannelIdImpl.
     * 
     * @param name
     * @param dataType
     */
    public WritableChannelIdImpl(String name, Class<T> dataType) {
        super(name, dataType);

    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof ReadableChannelId) {
            if (getDataType()
                    .equals(((ReadableChannelId<T>) obj).getDataType())) {
                return true;
            }
        }

        return false;
    }
}
