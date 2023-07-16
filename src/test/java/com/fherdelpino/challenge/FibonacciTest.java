package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
public class FibonacciTest {

    @Test
    @Disabled //test created to compare times
    public void testBigFibonacciNumbers() {
        for (int i = 1; i <= 50; i++) {
            long time = System.currentTimeMillis();
            log.info("{}: {} in {}ms", i, Fibonacci.compute(i), System.currentTimeMillis() - time);
        }
    }

    @Test
    @Disabled //test created to compare times
    public void test50FibonacciNumber() {
        assertEquals(7778742049L, Fibonacci.compute(50));
    }

    @Test
    public void test50FibonacciNumberWithMemo() {
        assertEquals(7778742049L, Fibonacci.computeWithMemo(50));
    }

    @Test
    @Disabled //test created to compare times
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
