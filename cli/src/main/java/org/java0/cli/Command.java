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
package org.java0.cli;

import com.beust.jcommander.ParameterException;

/**
 * A single command line "command" or function. Applications define one or more
 * <tt>Command</tt>s that implement the parameter validation and high level
 * operations for each commnad line command implemented by the application.
 *
 */
public interface Command extends Runnable {

	/**
	 * Performs command specific validation of the command line parameters.
	 *
	 * @throws ParameterException
	 *             the parameter exception
	 */
	public void validate() throws ParameterException;

	/**
	 * Performs any preparatory steps before the command is executed.
	 */
	public Command prepare();

	/**
	 * Run the command.
	 *
	 */
	@Override
	public void run();

	/**
	 * Perform any cleanup work after the command has been executed.
	 */
	public void finish();

}
