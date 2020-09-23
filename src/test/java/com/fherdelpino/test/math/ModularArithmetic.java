package com.fherdelpino.test.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ModularArithmetic {

    @Test
    public void rotateLeft() {
        int[] a = {1, 2, 3, 4, 5};
        int d = 2;

        for (int i = 0; i < a.length; i++) {
            int newPosition = (i + (a.length - d)) % a.length;
            log.info("oldPosition: {}, newPosition: {}", i, newPosition);
        }
    }

    @Test
    public void test() {
        for (int i = 0; i <= 15; i++) {
            log.info("index={} mod={}", i, i % 5);
        }
    }
}
