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
package org.java0.util.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.java0.util.logging.LogUtil;

public class FactoryUtil {
    private static Logger logger = Logger
            .getLogger(FactoryUtil.class.getName());
    private static LogUtil logUtil = new LogUtil(logger);

    /**
     * Create an object of the given concrete type using the given constructor
     * arguments.
     *
     * @param concreteType
     * @param constructorArgs
     * @return
     */
    public static <T> T createNewObject(Class<T> concreteType,
            Object... constructorArgs) {
        T newObject = null;
        try {
            newObject =
                    ConstructorUtils.invokeConstructor(concreteType,
                            constructorArgs);
        } catch (NoSuchMethodException e) {
            Class<?>[] argTypes = null;
            argTypes = new Class[constructorArgs.length];
            for (int i = 0; i < constructorArgs.length; ++i) {
                argTypes[i] = constructorArgs[i].getClass();
            }
            StringBuffer message = new StringBuffer("Constructor not found: ");
            message.append(concreteType.getName());
            message.append("(");
            for (int i = 0; i < argTypes.length; ++i) {
                if (i > 0) {
                    message.append(", ");
                }
                message.append(argTypes[i].getName());
            }
            message.append(")");

            throw logUtil
                    .exception(new FactoryException(message.toString(), e));
        } catch (SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            throw logUtil.exception(new FactoryException(
                    "Received exception instantiating new object", e));
        }

        return newObject;
    }

}
