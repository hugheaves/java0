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
package org.java0.logging.jul;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogUtil {

    private final Logger targetLogger;

    public LogUtil(Logger targetLogger) {
        this.targetLogger = targetLogger;
    }

    /**
     * Convenience method to log an exception.
     * 
     * @param exception
     * @return exception
     */
    public <T extends Throwable> T exception(T exception) {
        targetLogger.log(Level.SEVERE, "Caught exception: ", exception);
        return exception;
    }

    /**
     * Convenience method to log a series of variable values at the Level.INFO
     * logging level.
     * 
     * @see LogUtil#values(Level, String, Object...)
     * 
     * @param message
     * @param objects
     */
    public void valuesInfo(String message, Object... objects) {
        values(Level.INFO, message, objects);
    }

    /**
     * Convenience method to log a series of variable values at the Level.CONFIG
     * logging level.
     * 
     * @see LogUtil#values(Level, String, Object...)
     * 
     * @param message
     * @param objects
     */
    public void valuesConfig(String message, Object... objects) {
        values(Level.CONFIG, message, objects);
    }

    /**
     * Convenience method to log a series of variable values at the Level.FINE
     * logging level.
     * 
     * @see LogUtil#values(Level, String, Object...)
     * 
     * @param message
     * @param objects
     */
    public void valuesFine(String message, Object... objects) {
        values(Level.FINE, message, objects);
    }

    /**
     * Convenience method to log a series of variable values at the Level.FINER
     * logging level.
     * 
     * @see LogUtil#values(Level, String, Object...)
     * 
     * @param message
     * @param objects
     */
    public void valuesFiner(String message, Object... objects) {
        values(Level.FINER, message, objects);
    }

    /**
     * Convenience method to log a series of variable values at the Level.FINEST
     * logging level.
     * 
     * @see LogUtil#values(Level, String, Object...)
     * 
     * @param message
     * @param objects
     */
    public void valuesFinest(String message, Object... objects) {
        values(Level.FINEST, message, objects);
    }

    /**
     * <p>
     * Convenience method to log a series of variable values for debugging. This
     * method should be called with a log level and message, followed by a
     * series of name / value pairs.
     * 
     * <p>
     * Ex. :
     * 
     * <p>
     * {@code logUtil.values(Level.FINE, "Inside for loop", "i", i, "j", j, "total", total); }
     * 
     * @param level
     *            Logging level
     * @param message
     *            Message
     * @param objects
     *            List of name / value pairs.
     */
    public void values(Level level, String message, Object... objects) {
        if (!targetLogger.isLoggable(level)) {
            return;
        }

        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException(
                    "Number of names must equal number of values");
        }

        for (int i = 0; i < objects.length; i = i + 2) {
            if (!(objects[i] instanceof String)) {
                throw new IllegalArgumentException(
                        "Every other value must be a name (i.e. String)");
            }
        }

        targetLogger.log(level, message, objects);
    }

    /**
     * Initialize the {@link java.util.logging.LogManager} from the named
     * properties file, loaded from the classpath.
     * 
     * @param propertiesFile
     * @return True if the file was found on the classpath and logging was
     *         successfully configured
     */
    public static boolean initLogging(String propertiesFile) {

        try {
            if (propertiesFile != null) {
                InputStream inputStream = ClassLoader
                        .getSystemResourceAsStream(propertiesFile);
                if (inputStream != null) {
                    LogManager.getLogManager().readConfiguration(inputStream);
                    inputStream.close();
                    Logger.getLogger(LogUtil.class.getName()).info(
                            "Logging configured from \"" + propertiesFile
                                    + "\" file.");
                    return true;
                } else {
                    Logger.getLogger(LogUtil.class.getName()).info(
                            "Logging configuration file \"" + propertiesFile
                                    + "\" not found.");
                }
            }
        } catch (SecurityException | IOException e) {
            System.err.println("Caught exception in LogUtil.initLogging():");
            e.printStackTrace(System.err);
        }

        return false;
    }

    /**
     * Initialize the logging system using a simple programmatic configuration.
     * Any messages at the specified level or higher will be logged to
     * System.err.
     * 
     * @param level
     *            The lowest level at which to log messages
     * @return
     */
    public static boolean initLoggingSimple(Level level) {
        LogManager.getLogManager().reset();
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new FastFormatter());
        handler.setLevel(level);
        Logger.getLogger("").addHandler(handler);
        Logger.getLogger("").setLevel(level);
        return true;
    }
}
