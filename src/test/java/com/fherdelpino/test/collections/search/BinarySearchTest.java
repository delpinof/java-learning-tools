package com.fherdelpino.test.collections.search;

import com.fherdelpino.collections.search.BinarySearch;
import com.fherdelpino.test.collections.CollectionsTestUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinarySearchTest {

    @Test
    public void searchIterative10NumbersFound() {
        int[] testData = CollectionsTestUtils.getTestDataNConsecutiveInts(10);
        BinarySearch binarySearch = new BinarySearch();
        boolean result = binarySearch.searchIterative(testData, 9);
        assertTrue(result);
    }

    @Test
    public void searchIterative10NumbersNotFound() {
        int[] testData = CollectionsTestUtils.getTestDataNConsecutiveInts(10);
        BinarySearch binarySearch = new BinarySearch();
        boolean result = binarySearch.searchIterative(testData, 11);
        assertFalse(result);
    }

    @Test
    public void searchRecursive10NumbersFound() {
        int[] testData = CollectionsTestUtils.getTestDataNConsecutiveInts(10);
        BinarySearch binarySearch = new BinarySearch();
        boolean result = binarySearch.searchRecursive(testData, 9);
        assertTrue(result);
    }

    @Test
    public void searchRecursive10NumbersNotFound() {
        int[] testData = CollectionsTestUtils.getTestDataNConsecutiveInts(10);
        BinarySearch binarySearch = new BinarySearch();
        boolean result = binarySearch.searchRecursive(testData, 11);
        assertFalse(result);
    }
}
