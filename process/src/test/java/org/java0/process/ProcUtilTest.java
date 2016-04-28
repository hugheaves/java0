package org.java0.process;

import java.util.Set;

import org.java0.logging.Level;
import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.java0.util.timing.Stopwatch;
import org.junit.Test;

public class ProcUtilTest {
    private static final Logger logger = LoggerFactory.getLogger(ProcUtilTest.class);

    String procLine = "3214 (A process name) S 2780 2384 2384 0 -1 1077960704 12941 0 2 0 74 36 0 0 20 0 12 0 3622 381935616 15575 18446744073709551615 1 1 0 0 0 0 0 4097 1256 0 0 0 17 1 0 0 21 0 0 0 0 0 0 0 0 0 0";

    @Test
    public void test1() {
        final Stopwatch sw = new Stopwatch();
        sw.start();
        final Set<Integer> allPids = LinuxProcessUtil.getAllPids();
        for (final Integer pid : allPids) {
            final LinuxProcStatFile lpsf = new LinuxProcStatFile(pid);
            final LinuxProcessInfo lpo = lpsf.getInfo();
            logger.debug(lpo.toString());
        }
        logger.debug(allPids.toString());
        sw.stop();
    }

    @Test
    public void test2() {
        final LinuxProcessInfo lpi = new LinuxProcessInfo(procLine);
    }

    @Test
    public void test3() {
        final Stopwatch sw = new Stopwatch(Level.INFO);
        sw.start();
        int total = 0;
        for (int i = 0; i < 100; ++i) {
            final Set<Integer> allPids = LinuxProcessUtil.getAllPids();
            total += allPids.size();
        }
        logger.info("Total is {}", total);

        sw.stop();
    }

}
