package com.fherdelpino.algorithms.sort;

import com.fherdelpino.datastructures.collections.CollectionsTestUtils;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortTest {
    int[] unSorted;
    int[] sorted;

    @Before
    public void init() {
        unSorted = new int[]{6, 5, 4, 3, 2, 1};
        sorted = new int[]{1, 2, 3, 4, 5, 6};
    }

    @Test
    public void testSwap() {
        int[] swappable = {6, 5};
        ((Sorteable) elements -> {
        }).swap(swappable, 0, 1);
        assertThat(swappable).isEqualTo(new int[]{5, 6});
    }

    @Test
    public void testSwap0() {
        int[] swappable = {6, 0};
        ((Sorteable) elements -> {
        }).swap(swappable, 0, 1);
        assertThat(swappable).isEqualTo(new int[]{0, 6});
    }

    @Test
    public void testBubbleSort() {
        new BubbleSort().sort(unSorted);
        assertThat(unSorted).isEqualTo(sorted);
    }

    @Test
    public void testSelectionSort() {
        int[] testData = CollectionsTestUtils.getTestDataRandomNInts(100);
        new SelectionSort().sort(testData);
        for (int i = 0; i< testData.length-1; i++) {
            assertThat(testData[i]).isLessThanOrEqualTo(testData[i+1]);
        }

    }
}
