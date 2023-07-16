package com.fherdelpino.datastructures.collections.search;

import com.fherdelpino.datastructures.collections.CollectionsTestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class BinarySearchTest {

    @Test
    public void searchIterative10NumbersFound() {
        int[] testData = CollectionsTestUtils.getTestDataNConsecutiveInts(10);
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.searchIterative(testData, 9);
        assertTrue(result > 0);
    }

    @Test
    public void searchIterative10NumbersNotFound() {
        int[] testData = CollectionsTestUtils.getTestDataNConsecutiveInts(10);
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.searchIterative(testData, 11);
        assertTrue(result < 0);
    }

    @Test
    public void searchRecursive10NumbersFound() {
        int[] testData = CollectionsTestUtils.getTestDataNConsecutiveInts(10);
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.searchRecursive(testData, 9);
        assertTrue(result > 0);
    }

    @Test
    public void searchRecursive10NumbersNotFound() {
        int[] testData = CollectionsTestUtils.getTestDataNConsecutiveInts(10);
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.searchRecursive(testData, 11);
        assertTrue(result < 0);
    }
}
