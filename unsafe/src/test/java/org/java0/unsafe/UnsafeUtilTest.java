package org.java0.unsafe;

import java.util.Arrays;
import java.util.Random;

import org.java0.logging.slf4j.Logger;
import org.java0.logging.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;

import sun.misc.Unsafe;

public class UnsafeUtilTest {
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(UnsafeUtilTest.class);

    private static final int ITERATIONS = 1000;
    private static final int MAX_LENGTH = 1024;

    private final Random random = new Random(0);

    @Test
    public void testGetUnsafe() {
        final Unsafe unsafe = UnsafeUtil.get();
        Assert.assertNotNull(unsafe);
    }

    @Test
    public void testArrayCopy() {
        for (int i = 0; i < ITERATIONS; ++i) {
            final int length = random.nextInt(MAX_LENGTH - 1) + 1;
            final byte[] testData = new byte[length];
            random.nextBytes(testData);
            for (int j = 0; j < ITERATIONS; ++j) {
                final int srcStartPos = random.nextInt(length);
                final int destStartPos = random.nextInt(length);
                final int maxLength = Math.min(length - srcStartPos, length - destStartPos);
                final int copyLength = random.nextInt(maxLength);
                final byte[] result1 = new byte[length];
                final byte[] result2 = new byte[length];
                System.arraycopy(testData, srcStartPos, result1, destStartPos, copyLength);
                UnsafeUtil.arrayCopy(testData, srcStartPos, result2, destStartPos, copyLength);
                Assert.assertArrayEquals(result1, result2);
            }
        }
    }

    @Test
    public void testCopyOf() {
        for (int i = 0; i < ITERATIONS; ++i) {
            final int length = random.nextInt(MAX_LENGTH - 1) + 1;
            final byte[] testData = new byte[length];
            random.nextBytes(testData);
            for (int j = 0; j < ITERATIONS; ++j) {
                final int newLength = random.nextInt(length);
                final byte[] result1 = UnsafeUtil.copyOf(testData, newLength);
                final byte[] result2 = Arrays.copyOf(testData, newLength);
                Assert.assertArrayEquals(result1, result2);
            }
        }
    }

    @Test
    public void testUnsafePerf() {
        final int length = MAX_LENGTH;
        final long testData = UnsafeUtil.allocateMemory(MAX_LENGTH);
        // random.nextBytes(testData);
        for (int i = 0; i < ITERATIONS; ++i) {
            for (int j = 0; j < ITERATIONS; ++j) {
                final long result = UnsafeUtil.copyOf(testData, MAX_LENGTH, MAX_LENGTH);
                UnsafeUtil.freeMemory(result);
            }
        }
    }

    @Test
    public void testArraysPerf() {
        final int length = MAX_LENGTH;
        final byte[] testData = new byte[MAX_LENGTH];
        random.nextBytes(testData);
        for (int i = 0; i < ITERATIONS; ++i) {
            for (int j = 0; j < ITERATIONS; ++j) {
                final byte[] result1 = Arrays.copyOf(testData, MAX_LENGTH);
            }
        }
    }

}
