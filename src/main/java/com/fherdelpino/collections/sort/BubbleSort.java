package com.fherdelpino.collections.sort;

import lombok.extern.slf4j.Slf4j;

import static com.fherdelpino.collections.sort.CollectionUtils.swap;

@Slf4j
public class BubbleSort {

    public int[] sort(int[] numbers) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i - 1] > numbers[i]) {
                    swap(numbers, i, i - 1);
                    swapped = true;
                }
            }
        } while (swapped);
        return numbers;
    }

}
