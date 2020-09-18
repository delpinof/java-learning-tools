package com.fherdelpino.test.collections.sort;

import com.fherdelpino.collections.sort.MergeSort;
import com.fherdelpino.test.collections.CollectionsTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Slf4j
public class MergeSortTest {

    MergeSort mergeSort;

    @Before
    public void setUp() {
        mergeSort = new MergeSort();
    }

    @Test
    public void test4Ints() {
        int[] testData = {2, 4, 3, 1};
        int[] result = mergeSort.sort(testData);
        log.info("result={}", result);
    }

    @Test
    public void test3Ints() {
        int[] testData = {2, 3, 1};
        int[] result = mergeSort.sort(testData);
        log.info("result={}", result);
    }

    @Test
    public void test10Ints() {
        int[] testData = CollectionsTestUtils.testData10IntsReverseOrder.clone();
        log.info("result={}", mergeSort.sort(testData));
    }

    @Test
    public void test1MInts() {
        int[] testData = CollectionsTestUtils.getTestDataRandomNInts(1_000_001);
        long timeStart = System.currentTimeMillis();
        int[] result = mergeSort.sort(testData);
        long timeTaken = System.currentTimeMillis() - timeStart;
        log.info("result={}", result);
        log.info("time={}", timeTaken);
    }

    @Test
    public void intDivision() {
        int size = 3;
        assertEquals(3 / 2, 1);
    }
}
