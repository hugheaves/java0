/**
 * This package provides some helper classes to assist the implementation of a
 * command line interface for an application. These classes use the
 * excellent JCommander command line library to perform most of the heavy
 * lifting.
 *
 * These helper classes simplify handling of two command line "formats": one
 * where the application implements only a single function / command, and the
 * other where multiple sub-commands are implemented in a single application.
 *
 * Example command line format for an application that only implements a single
 * function / command:
 *
 * java -jar MyApp.jar -option1 ValueA -option2 ValueB -optionX
 *
 * Example command line format for an application that implements multiple
 * functions / commands within a single application: (note the command name
 * appears first on the command line, followed by any options used by that
 * command)
 *
 * java -jar MyApp.jar commandA -option1 ValueA -option2 ValueB -optionX
 *
 * java -jar MyApp.jar commandB -optionA val5 -optionZ
 *
 * java -jar MyApp.jar commandC
 *
 *
 */
package org.java0.cli;

