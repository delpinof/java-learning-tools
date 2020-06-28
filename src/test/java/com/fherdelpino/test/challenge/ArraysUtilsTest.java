package com.fherdelpino.test.challenge;

import org.junit.Test;

import com.fherdelpino.challenge.ArraysUtils;

import static org.junit.Assert.assertEquals;

public class ArraysUtilsTest {
    ArraysUtils arraysUtils = new ArraysUtils();

    @Test
    public void test() {
        int[] A = { 13, 27, 35, 40, 49, 55, 59 };
        int[] B = { 17, 35, 39, 40, 55, 58, 60 };

        int result = arraysUtils.findDuplicated(A, B);
        assertEquals(3, result);
    }
}
