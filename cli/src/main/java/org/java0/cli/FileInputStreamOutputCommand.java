package org.java0.cli;

import java.io.OutputStream;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

import com.beust.jcommander.Parameter;

public abstract class FileInputStreamOutputCommand extends FileInputCommand {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(FileInputStreamOutputCommand.class);

    @Parameter(names = { "-o", "--out" }, required = false, description = "Output file name")
    protected OutputStream outputStream;

}
