package com.fherdelpino.algorithms.sort;

/**
 * Compare pairs next to each other, swap the bigger to the right.
 */
public class BubbleSort implements Sorteable {

    public void sort(int[] values) {
        int swapsCount = 1;
        while (swapsCount > 0) {
            swapsCount = 0;
            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] > values[i + 1]) {
                    swap(values, i, i + 1);
                    swapsCount++;
                }
            }
        }
    }
}
