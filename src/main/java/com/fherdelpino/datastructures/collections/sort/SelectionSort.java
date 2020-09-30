package com.fherdelpino.datastructures.collections.sort;

import static com.fherdelpino.datastructures.collections.sort.CollectionUtils.swap;

public class SelectionSort {

    public int[] sort(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            int lowestValue = numbers[i];
            int lowestPos = i;
            boolean swap = false;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < lowestValue) {
                    lowestValue = numbers[j];
                    lowestPos = j;
                    swap = true;
                }
            }
            if (swap) {
                swap(numbers, i, lowestPos);
            }
        }

        return numbers;
    }
}