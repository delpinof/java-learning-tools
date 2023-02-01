package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@Slf4j
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

        int[][] list = arraysUtils.getSubArraysOf(inputArray, 3);

        assertEquals(3, list.length);
        assertArrayEquals(new int[]{1, 2, 3}, list[0]);
        assertArrayEquals(new int[]{2, 3, 4}, list[1]);
        assertArrayEquals(new int[]{3, 4, 5}, list[2]);

    }

    @Test
    public void testSubArrays() {
        int[] inputArray = {1, 2, 3, 4, 5};

        int[][] list = arraysUtils.getAllSubArrays(inputArray);

        int sizeExpected = (inputArray.length + 1) * inputArray.length / 2;
        assertEquals(sizeExpected, list.length);
        assertArrayEquals(new int[]{1}, list[0]);
        assertArrayEquals(new int[]{2}, list[1]);
        assertArrayEquals(new int[]{3}, list[2]);
        assertArrayEquals(new int[]{4}, list[3]);
        assertArrayEquals(new int[]{5}, list[4]);
        assertArrayEquals(new int[]{1, 2}, list[5]);
        assertArrayEquals(new int[]{2, 3}, list[6]);
        assertArrayEquals(new int[]{3, 4}, list[7]);
        assertArrayEquals(new int[]{4, 5}, list[8]);
        assertArrayEquals(new int[]{1, 2, 3}, list[9]);
        assertArrayEquals(new int[]{2, 3, 4}, list[10]);
        assertArrayEquals(new int[]{3, 4, 5}, list[11]);
        assertArrayEquals(new int[]{1, 2, 3, 4}, list[12]);
        assertArrayEquals(new int[]{2, 3, 4, 5}, list[13]);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, list[14]);

    }

    @Test
    public void testArrays() {
        int[] inputArray = {6, 7, 8, 9, 10};
        Arrays.setAll(inputArray, operand -> inputArray[operand] * 10);
        log.info("{}", inputArray);
    }

    @Test
    public void testCountDuplicates() {
        int result = ArraysUtils.countDuplicates(new int[]{1,2,3}, new int[]{3,4,5});
        assertEquals(1, result);
    }
}
