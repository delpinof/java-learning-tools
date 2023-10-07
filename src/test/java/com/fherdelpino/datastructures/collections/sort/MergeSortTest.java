package com.fherdelpino.datastructures.collections.sort;

import com.fherdelpino.datastructures.collections.CollectionsTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class MergeSortTest {

    MergeSort mergeSort;

    @BeforeEach
    public void setUp() {
        mergeSort = new MergeSort();
    }

    @Test
    public void test4Ints() {
        int[] testData = {2, 4, 3, 1};
        int[] result = mergeSort.sort(testData);
        assertThat(result).isSorted();
    }

    @Test
    public void test3Ints() {
        int[] testData = {2, 3, 1};
        int[] result = mergeSort.sort(testData);
        assertThat(result).isSorted();
    }

    @Test
    public void test10Ints() {
        int[] testData = CollectionsTestUtils.testData10IntsReverseOrder.clone();
        int[] result = mergeSort.sort(testData);
        assertThat(result).isSorted();
    }

    @Test
    public void test1MInts() {
        int[] testData = CollectionsTestUtils.getTestDataRandomNInts(1_000_001);
        long timeStart = System.currentTimeMillis();
        int[] result = mergeSort.sort(testData);
        long timeTaken = System.currentTimeMillis() - timeStart;
        log.info("time={}", timeTaken);
        assertThat(result).isSorted();
    }

    @Test
    public void intDivision() {
        int size = 3;
        assertEquals(size / 2, 1);
    }
}
