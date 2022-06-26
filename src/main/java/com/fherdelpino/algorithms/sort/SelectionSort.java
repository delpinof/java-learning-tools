package com.fherdelpino.algorithms.sort;

/**
 * Find the smallest in the list and put it in the first place.
 */
public class SelectionSort implements Sorteable {

    @Override
    public void sort(int[] elements) {
        for (int nextToSort = 0; nextToSort < elements.length; nextToSort++) {
            for (int i = nextToSort + 1; i < elements.length; i++) {
                if (elements[i] < elements[nextToSort]) {
                    swap(elements, nextToSort, i);
                }
            }
        }
    }
}
