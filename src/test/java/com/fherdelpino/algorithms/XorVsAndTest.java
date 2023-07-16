package com.fherdelpino.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class XorVsAndTest {

    @Test
    public void testXor() {
        int total = 16;
        int[] numbers = new int[total];
        for (int i = 7; i < total; i++) {
            numbers[i] = i;
        }
        long time = System.currentTimeMillis();
        int count = XorVsAnd.countXorGreatThanAnd(numbers);
        log.info("{} in {}ms", count, System.currentTimeMillis() - time);
    }

}
