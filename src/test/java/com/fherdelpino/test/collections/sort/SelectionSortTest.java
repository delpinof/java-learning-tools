package com.fherdelpino.test.collections.sort;

import com.fherdelpino.collections.sort.SelectionSort;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SelectionSortTest {

    @Test
    public void test10Integers() {
        int[] testData = CollectionsTestUtils.testData10Ints.clone();
        SelectionSort selectionSort = new SelectionSort();
        int[] result = selectionSort.sort(testData);
        log.info("result={}", result);
    }

    @Test
    public void test100Integers() {
        int[] testData = CollectionsTestUtils.getTestDataNInts(100);
        SelectionSort selectionSort = new SelectionSort();
        int[] result = selectionSort.sort(testData);
        log.info("result={}", result);
    }

    @Test
    public void test10KIntegers() {
        int[] testData = CollectionsTestUtils.getTestDataNInts(100_000);
        SelectionSort selectionSort = new SelectionSort();
        long timeStart = System.currentTimeMillis();
        int[] result = selectionSort.sort(testData);
        long timeTaken = System.currentTimeMillis() - timeStart;
        log.info("result={}", result);
        log.info("time={}", timeTaken);
    }
}
