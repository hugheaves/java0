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

import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * @author Hugh Eaves
 *
 */
public class Safe {
    @SuppressWarnings("unused")
    private static final Logger logger = Logger.getLogger(Nullsafe.class.getName());

    public static <T> T call(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IndexOutOfBoundsException | NoSuchElementException | NullPointerException e) {
            return null;
        }
    }

    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    // CODE GENERATOR
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    private static final String RETURN_VALUE = "r";
    private static final String PARAM_VALUE = "p";
    private static final String PARAM_TYPE = "P";
    private static final String RETURN_TYPE = "R";

    public static void main(final String[] args) {
        final int depth = 0;
        final String R0 = RETURN_TYPE + depth;
        final String r0 = RETURN_VALUE + depth;

        generate(3, depth, R0, "final " + R0 + " " + r0, r0);

    }

    private static void generate(final int maxDepth, final int depth, final String genericTypes, final String funcArgs,
            final String callArgs) {
        if (depth > maxDepth) {
            return;
        }

        addBiFunction(maxDepth, depth, genericTypes, funcArgs, callArgs);

        addFunction(maxDepth, depth, genericTypes, funcArgs, callArgs);

    }

    private static void addFunction(final int maxDepth, final int depth, String genericTypes, String funcArgs,
            final String callArgs) {

        final String R0 = RETURN_TYPE + depth;
        final String R1 = RETURN_TYPE + (depth + 1);
        final String function0 = "function" + depth;

        genericTypes = genericTypes + "," + R1;

        funcArgs = funcArgs + ", final Function<" + R0 + ", " + R1 + "> " + function0;

        printBody(depth, genericTypes, funcArgs, callArgs, "");

        generate(maxDepth, depth + 1, genericTypes, funcArgs, callArgs + ", " + function0);

    };

    private static void addBiFunction(final int maxDepth, final int depth, String genericTypes, String funcArgs,
            final String callArgs) {

        final String R0 = RETURN_TYPE + depth;
        final String R1 = RETURN_TYPE + (depth + 1);
        final String P1 = PARAM_TYPE + (depth + 1);
        final String p1 = PARAM_VALUE + (depth + 1);
        final String function0 = "function" + depth;

        genericTypes = genericTypes + "," + P1 + "," + R1;

        funcArgs = funcArgs + ", final BiFunction<" + R0 + ", " + P1 + ", " + "" + R1 + "> " + function0 + ", " + P1
                + " " + p1;

        printBody(depth, genericTypes, funcArgs, callArgs, "," + p1);

        generate(maxDepth, depth + 1, genericTypes, funcArgs, callArgs + ", " + function0 + ", " + p1);

    };

    private static void printBody(final int depth, final String genericTypes, final String funcArgs,
            final String callArgs, final String applyArgs) {
        final String R0 = RETURN_TYPE + depth;
        final String R1 = RETURN_TYPE + (depth + 1);
        final String r0 = RETURN_VALUE + depth;
        final String r1 = RETURN_VALUE + (depth + 1);
        final String p0 = PARAM_VALUE + depth;

        System.out.print("public static <" + genericTypes + "> ");
        System.out.println("" + R1 + " call(" + funcArgs + ") {");

        if (depth > 0) {
            System.out.println("final " + R0 + " " + r0 + " = call (" + callArgs + ");");
            System.out.println("if (" + r0 + " == null) { return null; }");
            printApply(depth, applyArgs);
        } else {
            System.out.println("if (" + r0 + " == null) { return null; }");
            printApply(depth, applyArgs);
        }

        System.out.println("return " + r1 + ";");
        System.out.println("}");

    }

    private static void printApply(final int depth, final String applyArgs) {
        final String R1 = RETURN_TYPE + (depth + 1);
        final String r0 = RETURN_VALUE + depth;
        final String r1 = RETURN_VALUE + (depth + 1);
        final String function0 = "function" + depth;
        System.out.println(R1 + " " + r1 + " = null;");
        System.out.println("try {");
        System.out.println(r1 + " = " + function0 + ".apply(" + r0 + applyArgs + ");");
        System.out.println("} catch (IndexOutOfBoundsException | NoSuchElementException e) {");
        System.out.println("}");
    }

    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    // AUTO GENERATED CODE BELOW
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////

    public static <R0, P1, R1> R1 call(final R0 r0, final BiFunction<R0, P1, R1> function0, final P1 p1) {
        if (r0 == null) {
            return null;
        }
        R1 r1 = null;
        try {
            r1 = function0.apply(r0, p1);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r1;
    }

    public static <R0, P1, R1, P2, R2> R2 call(final R0 r0, final BiFunction<R0, P1, R1> function0, final P1 p1,
            final BiFunction<R1, P2, R2> function1, final P2 p2) {
        final R1 r1 = call(r0, function0, p1);
        if (r1 == null) {
            return null;
        }
        R2 r2 = null;
        try {
            r2 = function1.apply(r1, p2);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r2;
    }

    public static <R0, P1, R1, P2, R2, P3, R3> R3 call(final R0 r0, final BiFunction<R0, P1, R1> function0, final P1 p1,
            final BiFunction<R1, P2, R2> function1, final P2 p2, final BiFunction<R2, P3, R3> function2, final P3 p3) {
        final R2 r2 = call(r0, function0, p1, function1, p2);
        if (r2 == null) {
            return null;
        }
        R3 r3 = null;
        try {
            r3 = function2.apply(r2, p3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r3;
    }

    public static <R0, P1, R1, P2, R2, P3, R3, P4, R4> R4 call(final R0 r0, final BiFunction<R0, P1, R1> function0,
            final P1 p1, final BiFunction<R1, P2, R2> function1, final P2 p2, final BiFunction<R2, P3, R3> function2,
            final P3 p3, final BiFunction<R3, P4, R4> function3, final P4 p4) {
        final R3 r3 = call(r0, function0, p1, function1, p2, function2, p3);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3, p4);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, P1, R1, P2, R2, P3, R3, R4> R4 call(final R0 r0, final BiFunction<R0, P1, R1> function0,
            final P1 p1, final BiFunction<R1, P2, R2> function1, final P2 p2, final BiFunction<R2, P3, R3> function2,
            final P3 p3, final Function<R3, R4> function3) {
        final R3 r3 = call(r0, function0, p1, function1, p2, function2, p3);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, P1, R1, P2, R2, R3> R3 call(final R0 r0, final BiFunction<R0, P1, R1> function0, final P1 p1,
            final BiFunction<R1, P2, R2> function1, final P2 p2, final Function<R2, R3> function2) {
        final R2 r2 = call(r0, function0, p1, function1, p2);
        if (r2 == null) {
            return null;
        }
        R3 r3 = null;
        try {
            r3 = function2.apply(r2);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r3;
    }

    public static <R0, P1, R1, P2, R2, R3, P4, R4> R4 call(final R0 r0, final BiFunction<R0, P1, R1> function0,
            final P1 p1, final BiFunction<R1, P2, R2> function1, final P2 p2, final Function<R2, R3> function2,
            final BiFunction<R3, P4, R4> function3, final P4 p4) {
        final R3 r3 = call(r0, function0, p1, function1, p2, function2);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3, p4);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, P1, R1, P2, R2, R3, R4> R4 call(final R0 r0, final BiFunction<R0, P1, R1> function0, final P1 p1,
            final BiFunction<R1, P2, R2> function1, final P2 p2, final Function<R2, R3> function2,
            final Function<R3, R4> function3) {
        final R3 r3 = call(r0, function0, p1, function1, p2, function2);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, P1, R1, R2> R2 call(final R0 r0, final BiFunction<R0, P1, R1> function0, final P1 p1,
            final Function<R1, R2> function1) {
        final R1 r1 = call(r0, function0, p1);
        if (r1 == null) {
            return null;
        }
        R2 r2 = null;
        try {
            r2 = function1.apply(r1);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r2;
    }

    public static <R0, P1, R1, R2, P3, R3> R3 call(final R0 r0, final BiFunction<R0, P1, R1> function0, final P1 p1,
            final Function<R1, R2> function1, final BiFunction<R2, P3, R3> function2, final P3 p3) {
        final R2 r2 = call(r0, function0, p1, function1);
        if (r2 == null) {
            return null;
        }
        R3 r3 = null;
        try {
            r3 = function2.apply(r2, p3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r3;
    }

    public static <R0, P1, R1, R2, P3, R3, P4, R4> R4 call(final R0 r0, final BiFunction<R0, P1, R1> function0,
            final P1 p1, final Function<R1, R2> function1, final BiFunction<R2, P3, R3> function2, final P3 p3,
            final BiFunction<R3, P4, R4> function3, final P4 p4) {
        final R3 r3 = call(r0, function0, p1, function1, function2, p3);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3, p4);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, P1, R1, R2, P3, R3, R4> R4 call(final R0 r0, final BiFunction<R0, P1, R1> function0, final P1 p1,
            final Function<R1, R2> function1, final BiFunction<R2, P3, R3> function2, final P3 p3,
            final Function<R3, R4> function3) {
        final R3 r3 = call(r0, function0, p1, function1, function2, p3);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, P1, R1, R2, R3> R3 call(final R0 r0, final BiFunction<R0, P1, R1> function0, final P1 p1,
            final Function<R1, R2> function1, final Function<R2, R3> function2) {
        final R2 r2 = call(r0, function0, p1, function1);
        if (r2 == null) {
            return null;
        }
        R3 r3 = null;
        try {
            r3 = function2.apply(r2);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r3;
    }

    public static <R0, P1, R1, R2, R3, P4, R4> R4 call(final R0 r0, final BiFunction<R0, P1, R1> function0, final P1 p1,
            final Function<R1, R2> function1, final Function<R2, R3> function2, final BiFunction<R3, P4, R4> function3,
            final P4 p4) {
        final R3 r3 = call(r0, function0, p1, function1, function2);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3, p4);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, P1, R1, R2, R3, R4> R4 call(final R0 r0, final BiFunction<R0, P1, R1> function0, final P1 p1,
            final Function<R1, R2> function1, final Function<R2, R3> function2, final Function<R3, R4> function3) {
        final R3 r3 = call(r0, function0, p1, function1, function2);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, R1> R1 call(final R0 r0, final Function<R0, R1> function0) {
        if (r0 == null) {
            return null;
        }
        R1 r1 = null;
        try {
            r1 = function0.apply(r0);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r1;
    }

    public static <R0, R1, P2, R2> R2 call(final R0 r0, final Function<R0, R1> function0,
            final BiFunction<R1, P2, R2> function1, final P2 p2) {
        final R1 r1 = call(r0, function0);
        if (r1 == null) {
            return null;
        }
        R2 r2 = null;
        try {
            r2 = function1.apply(r1, p2);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r2;
    }

    public static <R0, R1, P2, R2, P3, R3> R3 call(final R0 r0, final Function<R0, R1> function0,
            final BiFunction<R1, P2, R2> function1, final P2 p2, final BiFunction<R2, P3, R3> function2, final P3 p3) {
        final R2 r2 = call(r0, function0, function1, p2);
        if (r2 == null) {
            return null;
        }
        R3 r3 = null;
        try {
            r3 = function2.apply(r2, p3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r3;
    }

    public static <R0, R1, P2, R2, P3, R3, P4, R4> R4 call(final R0 r0, final Function<R0, R1> function0,
            final BiFunction<R1, P2, R2> function1, final P2 p2, final BiFunction<R2, P3, R3> function2, final P3 p3,
            final BiFunction<R3, P4, R4> function3, final P4 p4) {
        final R3 r3 = call(r0, function0, function1, p2, function2, p3);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3, p4);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, R1, P2, R2, P3, R3, R4> R4 call(final R0 r0, final Function<R0, R1> function0,
            final BiFunction<R1, P2, R2> function1, final P2 p2, final BiFunction<R2, P3, R3> function2, final P3 p3,
            final Function<R3, R4> function3) {
        final R3 r3 = call(r0, function0, function1, p2, function2, p3);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, R1, P2, R2, R3> R3 call(final R0 r0, final Function<R0, R1> function0,
            final BiFunction<R1, P2, R2> function1, final P2 p2, final Function<R2, R3> function2) {
        final R2 r2 = call(r0, function0, function1, p2);
        if (r2 == null) {
            return null;
        }
        R3 r3 = null;
        try {
            r3 = function2.apply(r2);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r3;
    }

    public static <R0, R1, P2, R2, R3, P4, R4> R4 call(final R0 r0, final Function<R0, R1> function0,
            final BiFunction<R1, P2, R2> function1, final P2 p2, final Function<R2, R3> function2,
            final BiFunction<R3, P4, R4> function3, final P4 p4) {
        final R3 r3 = call(r0, function0, function1, p2, function2);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3, p4);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, R1, P2, R2, R3, R4> R4 call(final R0 r0, final Function<R0, R1> function0,
            final BiFunction<R1, P2, R2> function1, final P2 p2, final Function<R2, R3> function2,
            final Function<R3, R4> function3) {
        final R3 r3 = call(r0, function0, function1, p2, function2);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, R1, R2> R2 call(final R0 r0, final Function<R0, R1> function0,
            final Function<R1, R2> function1) {
        final R1 r1 = call(r0, function0);
        if (r1 == null) {
            return null;
        }
        R2 r2 = null;
        try {
            r2 = function1.apply(r1);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r2;
    }

    public static <R0, R1, R2, P3, R3> R3 call(final R0 r0, final Function<R0, R1> function0,
            final Function<R1, R2> function1, final BiFunction<R2, P3, R3> function2, final P3 p3) {
        final R2 r2 = call(r0, function0, function1);
        if (r2 == null) {
            return null;
        }
        R3 r3 = null;
        try {
            r3 = function2.apply(r2, p3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r3;
    }

    public static <R0, R1, R2, P3, R3, P4, R4> R4 call(final R0 r0, final Function<R0, R1> function0,
            final Function<R1, R2> function1, final BiFunction<R2, P3, R3> function2, final P3 p3,
            final BiFunction<R3, P4, R4> function3, final P4 p4) {
        final R3 r3 = call(r0, function0, function1, function2, p3);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3, p4);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, R1, R2, P3, R3, R4> R4 call(final R0 r0, final Function<R0, R1> function0,
            final Function<R1, R2> function1, final BiFunction<R2, P3, R3> function2, final P3 p3,
            final Function<R3, R4> function3) {
        final R3 r3 = call(r0, function0, function1, function2, p3);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, R1, R2, R3> R3 call(final R0 r0, final Function<R0, R1> function0,
            final Function<R1, R2> function1, final Function<R2, R3> function2) {
        final R2 r2 = call(r0, function0, function1);
        if (r2 == null) {
            return null;
        }
        R3 r3 = null;
        try {
            r3 = function2.apply(r2);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r3;
    }

    public static <R0, R1, R2, R3, P4, R4> R4 call(final R0 r0, final Function<R0, R1> function0,
            final Function<R1, R2> function1, final Function<R2, R3> function2, final BiFunction<R3, P4, R4> function3,
            final P4 p4) {
        final R3 r3 = call(r0, function0, function1, function2);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3, p4);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

    public static <R0, R1, R2, R3, R4> R4 call(final R0 r0, final Function<R0, R1> function0,
            final Function<R1, R2> function1, final Function<R2, R3> function2, final Function<R3, R4> function3) {
        final R3 r3 = call(r0, function0, function1, function2);
        if (r3 == null) {
            return null;
        }
        R4 r4 = null;
        try {
            r4 = function3.apply(r3);
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
        }
        return r4;
    }

}