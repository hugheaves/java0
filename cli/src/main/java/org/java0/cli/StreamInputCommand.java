package org.java0.cli;

import java.io.InputStream;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

import com.beust.jcommander.Parameter;

public abstract class StreamInputCommand extends AbstractCommand {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(StreamInputCommand.class);

    @Parameter(names = { "-i", "--in" }, required = false, description = "Input file name")
    protected InputStream inputFile;

    protected StreamInputCommand() {
        addDefault(CLIConst.STANDARD_IO_FLAG, "-i", "--in");
    }
}
