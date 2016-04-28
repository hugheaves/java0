package org.java0.core.exception;

/**
 * Exception handling utility functions.
 * 
 * @author Hugh Eaves
 *
 */
public class Exceptions {

    /**
     * Wraps checked exceptions in an UncheckedException. Re-throws all other
     * exceptions unaltered.
     * 
     * @param exception
     * @throws RuntimeException
     * @throws Error
     * @throws UncheckedException
     */
    public static void throwUnchecked(final Throwable exception) throws RuntimeException, Error, UncheckedException {
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        } else if (exception instanceof Error) {
            throw (Error) exception;
        } else {
            throw new UncheckedException(exception);
        }
    }

}
