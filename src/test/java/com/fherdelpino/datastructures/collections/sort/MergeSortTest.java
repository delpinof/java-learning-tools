package com.fherdelpino.datastructures.collections.sort;

import com.fherdelpino.datastructures.collections.CollectionsTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class MergeSortTest {

    private static MergeSort sut;

    @BeforeAll
    public static void setUp() {
        sut = new MergeSort();
    }

    @Test
    public void test4Ints() {
        int[] testData = {2, 4, 3, 1};
        int[] result = sut.sort(testData);
        assertThat(result).isSorted();
    }

    @Test
    public void test3Ints() {
        int[] testData = {2, 3, 1};
        int[] result = sut.sort(testData);
        assertThat(result).isSorted();
    }

    @Test
    public void test10Ints() {
        int[] testData = CollectionsTestUtils.testData10IntsReverseOrder.clone();
        int[] result = sut.sort(testData);
        assertThat(result).isSorted();
    }

    @Test
    public void test1MInts() {
        int[] testData = CollectionsTestUtils.getTestDataRandomNInts(1_000_001).clone();
        long timeStart = System.currentTimeMillis();
        sut.sort(testData, new int[testData.length], 0, testData.length - 1);
        long timeTaken = System.currentTimeMillis() - timeStart;
        log.info("time={}", timeTaken);
        assertThat(testData).isSorted();
    }

    @Test
    public void intDivision() {
        int size = 3;
        assertEquals(size / 2, 1);
    }

    @ParameterizedTest
    @MethodSource
    public void testMergeSort(int[] unOrderedArray) {
        int[] result = unOrderedArray.clone();
        sut.sort(result, new int[result.length], 0, result.length - 1);
        assertThat(result).containsExactlyInAnyOrder(unOrderedArray);
        assertThat(result).isSorted();
    }

    public static Stream<Arguments> testMergeSort() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1}),
                Arguments.of(new int[]{2, 4, 3, 1})
        );
    }
}
