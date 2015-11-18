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
package org.java0.logging.slf4j;

import org.java0.logging.Level;
import org.slf4j.Marker;

/**
 * @author Hugh Eaves
 *
 */
public interface Logger extends org.slf4j.Logger {

	public boolean isEnabled(Level level);

	public boolean isEnabled(Level level, Marker marker);

	public void log(Level level, String msg);

	public void log(Level level, String format, Object arg);

	public void log(Level level, String format, Object arg1, Object arg2);

	public void log(Level level, String format, Object... arguments);

	public void log(Level level, String msg, Throwable t);

	public void log(Level level, Marker marker, String msg);

	public void log(Level level, Marker marker, String format, Object arg);

	public void log(Level level, Marker marker, String format, Object arg1,
			Object arg2);

	public void log(Level level, Marker marker, String format,
			Object... arguments);

	public void log(Level level, Marker marker, String msg, Throwable t);
}
