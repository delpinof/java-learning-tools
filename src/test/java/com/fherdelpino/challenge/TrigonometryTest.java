package com.fherdelpino.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometryTest {

    @Test
    public void testGetDistance() {
        double result = TrigonometryUtils.distance(0,0, 0,5);
        assertEquals(5, result, .01);
    }

    @Test
    public void testGetArea() {
        int[] x = {0,4,0};
        int[] y = {0,0,4};
        double result = TrigonometryUtils.getTriangleArea(x, y);
        assertEquals(8, result, .01);
    }
}
