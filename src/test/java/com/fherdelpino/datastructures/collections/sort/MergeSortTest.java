package com.fherdelpino.datastructures.collections.sort;

import com.fherdelpino.datastructures.collections.CollectionsTestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void binarySearchTest() {
        List<Integer> list = new ArrayList<>(List.of(0,10,20,30));

        //When found the returned value is the index
        assertThat(Collections.binarySearch(list, 0)).isEqualTo(0);
        assertThat(Collections.binarySearch(list, 30)).isEqualTo(3);

        //When not found, the returned value is the position it would be but -1*-1
        assertThat(Collections.binarySearch(list, -1)).isEqualTo(-1);
        assertThat(Collections.binarySearch(list, 5)).isEqualTo(-2);
        assertThat(Collections.binarySearch(list, 25)).isEqualTo(-4);
        assertThat(Collections.binarySearch(list, 40)).isEqualTo(-5);
    }

    @Test
    public void binarySearchMatrixTest() {

        int[][] matrix = {new int[]{1,3,5,7},
                new int[]{10,11,16,20},
                new int[]{23,30,34,60}
        };

        int result = Arrays.binarySearch(matrix, 3, (array,target) -> ((int[]) array)[0]-(int)target);

        log.info("{}", result);
        log.info("{}", -result-1);
    }

    @Test
    public void testInteger() {
        Integer i1 = 1;
        Integer i2 = 1;
        assertTrue(i1==i2);

        Object o1 = new Object();
        Object o2 = new Object();

        //assertTrue(o1==o2);

        String s1 = new String();
        String s2 = new String();

        //assertTrue(s1 == s2);
    }
}
