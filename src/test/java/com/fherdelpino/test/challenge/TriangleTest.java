package com.fherdelpino.test.challenge;

import com.fherdelpino.challenge.Triangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TriangleTest {

    @Test
    public void testGetDistance() {
        double result = Triangle.distance(0,0, 0,5);
        assertEquals(5, result, .01);
    }

    @Test
    public void testGetArea() {
        int[] x = {0,4,0};
        int[] y = {0,0,4};
        double result = Triangle.getArea(x, y);
        assertEquals(8, result, .01);
    }
}
