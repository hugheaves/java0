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
package org.java0.cli;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.Parameters;

public class CLIUtil {
    private static final Logger logger = LoggerFactory.getLogger(CLIUtil.class);

    /**
     * Parses the command line arguments in args, and executes the appropriate
     * command in the list of commands. If the command syntax is incorrect, a
     * "usage" message is printed to standard error.
     * 
     * @param args
     *            the command line arguments
     * @param commands
     *            a list of commands
     * @return returns 0 if the command executed succesfully, != 0 otherwise
     *         (including incorrect command line syntax)
     */
    public static int processCommandLine(final String[] args, final Command... commands) {
        int returnCode = 0;
        Command command = null;

        try {
            command = parseCommandLine(args, commands);

            if (command != null) {
                final Command newCommand = command.prepare();
                if (!command.equals(newCommand)) {
                    parseCommandLine(args, newCommand);
                    command = newCommand;
                }
                command.run();
            } else {
                returnCode = 1;
            }
        } catch (final Throwable e) {
            final StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            printError(writer.toString());
            throw e;
        } finally {
            if (command != null) {
                command.finish();
            }
        }

        return (returnCode);
    }

    private static Command parseCommandLine(final String[] args, final Command... commands) {
        JCommander jCommander = null;
        String programName;
        boolean singleDefault = false;

        try {
            programName = commands[0].getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            logger.debug("Detected program name: {}", programName);
        } catch (final URISyntaxException e1) {
            programName = "PROGRAM_NAME";
        }

        logger.debug("Using program name: {}", programName);

        try {
            // Check if we have a single "default" Command (i.e. with no
            // actual command name defined)
            if (commands.length == 1) {
                final Command command = commands[0];
                final Parameters parameters = command.getClass().getAnnotation(Parameters.class);
                if (parameters == null || parameters.commandNames().length == 0) {
                    singleDefault = true;
                    logger.debug("Found single default command");
                }
            }

            if (singleDefault) {
                logger.debug("Creating single default JCommander instance");
                jCommander = new JCommander(commands[0]);
            } else {
                jCommander = new JCommander();
                for (final Command command : commands) {
                    logger.debug("Adding command {}", command);
                    jCommander.addCommand(command);
                }
            }

            // Add file argument converter factory
            jCommander.addConverterFactory(new FileArgumentConverterFactory());
            jCommander.setProgramName(programName);
            jCommander.parse(args);

            if (!singleDefault) {
                final String commandName = jCommander.getParsedCommand();
                logger.debug("Got command name: {}", commandName);

                if (commandName != null) {
                    jCommander = jCommander.getCommands().get(commandName);
                } else {
                    throw new ParameterException("No command given on commandline");
                }
            }

            final Command command = (Command) jCommander.getObjects().get(0);
            command.validate();
            return command;

        } catch (final ParameterException e) {
            printError(e.getMessage());
            printUsage(jCommander);
        }
        return null;
    }

    private static void printError(final String error) {
        System.err.println(error);
    }

    private static void printUsage(final JCommander jCommander) {
        final StringBuilder usage = new StringBuilder();
        final String parsedCommand = jCommander.getParsedCommand();
        if (parsedCommand != null) {
            jCommander.usage(parsedCommand, usage);
        } else {
            jCommander.usage(usage);
        }
        printError(usage.toString());
        return;
    }
}
