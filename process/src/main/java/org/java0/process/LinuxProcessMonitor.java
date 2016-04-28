package org.java0.process;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;

public class LinuxProcessMonitor implements Closeable {
    private static final Logger logger = LoggerFactory.getLogger(LinuxProcessMonitor.class);

    private final int pid;

    private Collection<LinuxProcStatFile> statFiles;

    private long lastChildUpdate = 0;
    private long updateInterval = -1;

    public LinuxProcessMonitor(final int pid) {
        this.pid = pid;
        updateChildProcesses();
    }

    public LinuxProcessMonitor(final int pid, final long updateInterval) {
        this.pid = pid;
        this.updateInterval = updateInterval;
        updateChildProcesses();
    }

    public Collection<LinuxProcessInfo> getInfo() {
        autoUpdateChildProcesses();

        final List<LinuxProcessInfo> info = new ArrayList<>(statFiles.size());

        for (final LinuxProcStatFile statFile : statFiles) {
            info.add(statFile.getInfo());
        }

        return info;
    }

    public void updateChildProcesses() {
        try {
            close();
        } catch (final IOException e) {
            logger.error("Caught exception in auto-generated catch block", e);
        }
        statFiles = LinuxProcessUtil.getChildStatFiles(pid, true);
    }

    protected void autoUpdateChildProcesses() {
        if (updateInterval > 0) {
            final long currentTime = System.currentTimeMillis();
            if (currentTime - lastChildUpdate > updateInterval) {
                updateChildProcesses();
                lastChildUpdate = currentTime;
            }
        }
    }

    @Override
    public void close() throws IOException {
        if (statFiles != null) {
            statFiles.forEach(f -> {
                try {
                    f.close();
                } catch (final Exception e) {
                    logger.error("Caught exception in auto-generated catch block", e);
                }

            });
        }
    }
}
