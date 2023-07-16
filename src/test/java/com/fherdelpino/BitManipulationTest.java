package com.fherdelpino;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.fherdelpino.bitmanupulation.BitManipulation.getBit;
import static com.fherdelpino.bitmanupulation.BitManipulation.setBit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class BitManipulationTest {

    @Test
    public void test() {
        for (int i = 1; i <= 30; i++) {
            log.info("num={}", 1 << i);
        }

    }

    @Test
    public void logicalBitShiftTest() {
        int num = 32;
        int expected = 16;
        assertEquals(expected, num >> 1);
    }

    @Test
    public void getBitTest() {
        int num = 7;
        assertTrue(getBit(num, 0));
        assertTrue(getBit(num, 1));
        assertTrue(getBit(num, 2));
        assertFalse(getBit(num, 3));
    }

    @Test
    public void setBitTest() {
        int num = 4;
        assertEquals(num + 1, setBit(num, 0));
        assertEquals(num + 2, setBit(num, 1));
    }
}
