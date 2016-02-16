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
package org.java0.util;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 */
public class Nullsafe {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(Nullsafe.class.getName());

    public static <T, U, R, U1, R1, U2, R2, U3, R3, U4, R4> R call(final T t, final BiFunction<T, U, R> function,
            final U u) {
        if (t == null) {
            return null;
        }
        final R r = function.apply(t, u);
        return r;
    }

    public static <T, U, R, U1, R1, U2, R2, U3, R3, U4, R4> R call(final T t, final BiFunction<T, U1, R1> function1,
            final U1 u1, final BiFunction<R1, U, R> function, final U u) {
        final R1 r1 = call(t, function1, u1);
        if (r1 == null) {
            return null;
        }
        final R r = function.apply(r1, u);
        return r;
    }

    public static <T, U, R, U1, R1, U2, R2, U3, R3, U4, R4> void call(final T t, final BiFunction<T, U1, R1> function1,
            final U1 u1, final BiConsumer<R1, U> function, final U u) {
        final R1 r1 = call(t, function1, u1);
        if (r1 == null) {
            return;
        }
        function.accept(r1, u);
    }

    public static <T, U, R, U1, R1, U2, R2, U3, R3, U4, R4> R call(final T t, final BiFunction<T, U2, R2> function2,
            final U2 u2, final BiFunction<R2, U1, R1> function1, final U1 u1, final BiFunction<R1, U, R> function,
            final U u) {
        final R1 r1 = call(t, function2, u2, function1, u1);
        if (r1 == null) {
            return null;
        }
        final R r = function.apply(r1, u);
        return r;
    }

    public static <T, U, R, U1, R1, U2, R2, U3, R3, U4, R4> R call(final T t, final BiFunction<T, U3, R3> function3,
            final U3 u3, final BiFunction<R3, U2, R2> function2, final U2 u2, final BiFunction<R2, U1, R1> function1,
            final U1 u1, final BiFunction<R1, U, R> function, final U u) {
        final R1 r1 = call(t, function3, u3, function2, u2, function1, u1);
        if (r1 == null) {
            return null;
        }
        final R r = function.apply(r1, u);
        return r;
    }

    public static <T, U, R, U1, R1, U2, R2, U3, R3, U4, R4> R call(final T t, final BiFunction<T, U4, R4> function4,
            final U4 u4, final BiFunction<R4, U3, R3> function3, final U3 u3, final BiFunction<R3, U2, R2> function2,
            final U2 u2, final BiFunction<R2, U1, R1> function1, final U1 u1, final BiFunction<R1, U, R> function,
            final U u) {
        final R1 r1 = call(t, function4, u4, function3, u3, function2, u2, function1, u1);
        if (r1 == null) {
            return null;
        }
        final R r = function.apply(r1, u);
        return r;
    }
}
