package com.fherdelpino.test.challenge;

import com.fherdelpino.challenge.Fibonacci;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Slf4j
public class FibonacciTest {

    @Test
    @Ignore //test created to compare times
    public void testBigFibonacciNumbers() {
        for (int i = 1; i <= 50; i++) {
            long time = System.currentTimeMillis();
            log.info("{}: {} in {}ms", i, Fibonacci.compute(i), System.currentTimeMillis() - time);
        }
    }

    @Test
    @Ignore //test created to compare times
    public void test50FibonacciNumber() {
        assertEquals(7778742049l, Fibonacci.compute(50));
    }

    @Test
    public void test50FibonacciNumberWithMemo() {
        assertEquals(7778742049l, Fibonacci.computeWithMemo(50));
    }

    @Test
    @Ignore //test created to compare times
    public void testFibonacciNumber() {
        Fibonacci.compute(50);
        log.info("count={}", Fibonacci.getCount());
    }

    @Test
    public void testFibonacciNumberWithMemo() {
        Fibonacci.computeWithMemo(50);
        log.info("count={}", Fibonacci.getCount());
    }
}
