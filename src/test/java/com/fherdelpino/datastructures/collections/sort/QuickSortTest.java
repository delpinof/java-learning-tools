package com.fherdelpino.datastructures.collections.sort;

import com.fherdelpino.datastructures.collections.CollectionsTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class QuickSortTest {

    QuickSort quickSort;

    @Before
    public void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    public void test10Ints() {
        int[] testData = {7, 2, 1, 6, 8, 5, 3, 4}; //CollectionsTestUtils.testData10Ints.clone();
        int[] result = quickSort.sort(testData, 0, testData.length - 1);
        log.info("result={}", result);
    }

    @Test
    public void test1MInts() {
        int[] testData = CollectionsTestUtils.getTestDataRandomNInts(1_000_000);
        long timeStart = System.currentTimeMillis();
        int[] result = quickSort.sort(testData, 0, testData.length - 1);
        long timeTaken = System.currentTimeMillis() - timeStart;
        log.info("result={}", result);
        log.info("time={}", timeTaken);
    }
}
