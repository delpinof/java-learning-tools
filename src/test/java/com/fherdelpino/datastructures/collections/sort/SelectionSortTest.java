package com.fherdelpino.datastructures.collections.sort;

import com.fherdelpino.datastructures.collections.CollectionsTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SelectionSortTest {

    @Test
    public void test10Integers() {
        int[] testData = CollectionsTestUtils.testData10IntsReverseOrder.clone();
        SelectionSort selectionSort = new SelectionSort();
        int[] result = selectionSort.sort(testData);
        log.info("result={}", result);
    }

    @Test
    public void test100Integers() {
        int[] testData = CollectionsTestUtils.getTestDataRandomNInts(100);
        SelectionSort selectionSort = new SelectionSort();
        int[] result = selectionSort.sort(testData);
        log.info("result={}", result);
    }

    @Test
    public void test100KIntegers() {
        int[] testData = CollectionsTestUtils.getTestDataRandomNInts(100_000);
        SelectionSort selectionSort = new SelectionSort();
        long timeStart = System.currentTimeMillis();
        int[] result = selectionSort.sort(testData);
        long timeTaken = System.currentTimeMillis() - timeStart;
        log.info("result={}", result);
        log.info("time={}", timeTaken);
    }
}
