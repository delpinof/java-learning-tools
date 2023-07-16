package com.fherdelpino.datastructures.collections.sort;

import com.fherdelpino.datastructures.collections.CollectionsTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class BubbleSortTest {

    @Test
    public void test10Integers() {
        int[] testData = CollectionsTestUtils.testData10IntsReverseOrder.clone();
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testData);
        log.info("result={}", result);
    }

    @Test
    public void test100Integers() {
        int[] testData = CollectionsTestUtils.getTestDataRandomNInts(100);
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testData);
        log.info("result={}", result);
    }

    @Test
    public void test100KIntegers() {
        int[] testData = CollectionsTestUtils.getTestDataRandomNInts(100_000);
        BubbleSort bubbleSort = new BubbleSort();
        long timeStart = System.currentTimeMillis();
        int[] result = bubbleSort.sort(testData);
        long timeTaken = System.currentTimeMillis() - timeStart;
        log.info("result={}", result);
        log.info("time={}", timeTaken);
    }
}
