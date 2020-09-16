package com.fherdelpino.test.collections.sort;

import com.fherdelpino.collections.sort.BubbleSort;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BubbleSortTest {

    @Test
    public void test10Integers() {
        int[] testData = CollectionsTestUtils.testData10Ints.clone();
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testData);
        log.info("result={}", result);
    }

    @Test
    public void test100Integers() {
        int[] testData = CollectionsTestUtils.getTestDataNInts(100);
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testData);
        log.info("result={}", result);
    }

    @Test
    public void test10KIntegers() {
        int[] testData = CollectionsTestUtils.getTestDataNInts(100_000);
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testData);
        log.info("result={}", result);
    }
}
