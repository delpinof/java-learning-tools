package com.fherdelpino.test.challenge;

import com.fherdelpino.challenge.ArraysUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArraysUtilsTest {
    ArraysUtils arraysUtils = new ArraysUtils();

    @Test
    public void testMerge() {
        int[] B = new int[6];
        B[0] = 2;
        B[1] = 4;
        B[2] = 8;

        int[] result = arraysUtils.merge(new int[]{1, 7, 9}, B);

        assertArrayEquals(new int[]{1, 2, 4, 7, 8, 9}, result);
    }

    @Test
    public void testSubArraysOf() {
        int[] inputArray = {1, 2, 3, 4, 5};

        List<int[]> list = arraysUtils.getSubArraysOf(inputArray, 3);

        assertEquals(3, list.size());
        assertArrayEquals(new int[]{1, 2, 3}, list.get(0));
        assertArrayEquals(new int[]{2, 3, 4}, list.get(1));
        assertArrayEquals(new int[]{3, 4, 5}, list.get(2));

    }

    @Test
    public void testSubArrays() {
        int[] inputArray = {1, 2, 3, 4, 5};

        List<int[]> list = arraysUtils.getAllSubArrays(inputArray);

        int sizeExpected = (inputArray.length + 1) * inputArray.length / 2;
        assertEquals(sizeExpected, list.size());
        assertArrayEquals(new int[]{1}, list.get(0));
        assertArrayEquals(new int[]{2}, list.get(1));
        assertArrayEquals(new int[]{3}, list.get(2));
        assertArrayEquals(new int[]{4}, list.get(3));
        assertArrayEquals(new int[]{5}, list.get(4));
        assertArrayEquals(new int[]{1, 2}, list.get(5));
        assertArrayEquals(new int[]{2, 3}, list.get(6));
        assertArrayEquals(new int[]{3, 4}, list.get(7));
        assertArrayEquals(new int[]{4, 5}, list.get(8));
        assertArrayEquals(new int[]{1, 2, 3}, list.get(9));
        assertArrayEquals(new int[]{2, 3, 4}, list.get(10));
        assertArrayEquals(new int[]{3, 4, 5}, list.get(11));
        assertArrayEquals(new int[]{1, 2, 3, 4}, list.get(12));
        assertArrayEquals(new int[]{2, 3, 4, 5}, list.get(13));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, list.get(14));

    }
}
