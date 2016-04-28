package org.java0.process;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.java0.collection.setmap.HashSetMap;
import org.java0.collection.setmap.SetMap;
import org.java0.core.exception.UncheckedException;
import org.java0.logging.Level;
import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.util.timing.Stopwatch;

public class LinuxProcessUtil {

    private static final Logger logger = LoggerFactory.getLogger(LinuxProcessUtil.class);

    private static final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:[0-9]+");

    private static final Filter<Path> pidFileFilter = new Filter<Path>() {
        @Override
        public boolean accept(final Path entry) {
            return matcher.matches(entry.getFileName());
        }
    };

    /**
     * Returns the pids of all the child processes of the given pid.
     * 
     * @param pid
     * @return
     */
    public static Set<Integer> getChildPids(final int pid, final boolean includeParent) {
        final Stopwatch sw = new Stopwatch("getChildren", Level.DEBUG);
        sw.start();
        final SetMap<Integer, Integer> pidTree = getProcessTree();
        sw.log("getProcessTree complete");

        final SetMap<Integer, Integer> pidDepths = new HashSetMap<>();

        final Set<Integer> pids = new HashSet<>();

        descendProcessTree(pidTree, pidDepths, pids, 0, pid);

        sw.stop();

        if (!includeParent) {
            pids.remove(pid);
        }

        return pids;
    }

    public static Collection<LinuxProcStatFile> getChildStatFiles(final int pid, final boolean includeParent) {
        final Collection<LinuxProcStatFile> childStatFiles = new ArrayList<>();

        final Set<Integer> childPids = getChildPids(pid, includeParent);
        for (final int childPid : childPids) {
            childStatFiles.add(new LinuxProcStatFile(childPid));
        }

        return childStatFiles;
    }

    /**
     * Builds a parent -> child pid map for all the processes on this system
     * 
     * @return a map of parent -> child pids
     */
    private static SetMap<Integer, Integer> getProcessTree() {
        final SetMap<Integer, Integer> pidTree = new HashSetMap<>();
        final Set<Integer> allPids = getAllPids();

        for (final int pid : allPids) {
            try (final LinuxProcStatFile statFile = new LinuxProcStatFile(pid)) {
                final LinuxProcessInfo info = statFile.getInfo();
                if (info != null) {
                    final Integer ppid = info.getParentPid();
                    if (ppid > 0) {
                        pidTree.add(ppid, pid);
                    } else {
                        logger.trace("Parent Pid not found for pid {}", pid);
                    }
                }
            } catch (final IOException e) {
                logger.error("Caught exception in auto-generated catch block", e);
            }
        }

        return pidTree;

    }

    /**
     * Recursive function to find child processes of the given pid
     * 
     * @param pidTree
     * @param pidDepths
     * @param pids
     * @param depth
     * @param pid
     */
    private static void descendProcessTree(final SetMap<Integer, Integer> pidTree,
            final SetMap<Integer, Integer> pidDepths, final Set<Integer> pids, final int depth, final int pid) {
        pidDepths.add(depth, pid);
        pids.add(pid);
        final Set<Integer> childPids = pidTree.get(pid);
        if (childPids != null) {
            for (final int childPid : childPids) {
                descendProcessTree(pidTree, pidDepths, pids, depth + 1, childPid);
            }
        }

    }

    /**
     * Return the pids of all running processes on this system.
     * 
     * @return
     */
    public static Set<Integer> getAllPids() {
        final Set<Integer> pids = new HashSet<>();
        final Path dir = Paths.get(LinuxProcConst.PROC_DIR);
        try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir, pidFileFilter)) {
            final Iterator<Path> fileList = directoryStream.iterator();
            while (fileList.hasNext()) {
                final Path path = fileList.next();
                final String pidStr = path.getFileName().toString();
                final int pid = Integer.parseInt(pidStr);
                pids.add(pid);
            }
        } catch (final IOException e) {
            logger.error("Caught exception in auto-generated catch block", e);
        }
        return pids;
    }

    /**
     * Returns the pid for the given Java process.
     * 
     * @param process
     * @return
     */
    public static int getPid(final Process process) {
        try {
            // grab the private pid field via reflection
            final Field pidField = process.getClass().getDeclaredField("pid");
            pidField.setAccessible(true);
            return (Integer) pidField.get(process);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            throw new UncheckedException("Error retrieving pid from Process object", e);
        }
    }
}
