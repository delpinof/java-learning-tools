package com.fherdelpino.test.challenge;

import org.junit.Test;

import com.fherdelpino.challenge.ArraysUtils;

import static org.junit.Assert.assertArrayEquals;

public class ArraysUtilsTest {
    ArraysUtils arraysUtils = new ArraysUtils();

    @Test
    public void test() {
        int[] B = new int[6];
        B[0] = 2;
        B[1] = 4;
        B[2] = 8;

        int[] result = arraysUtils.merge(new int[] { 1, 7, 9 }, B);

        assertArrayEquals(new int[]{1,2,4,7,8,9}, result);
    }
}
