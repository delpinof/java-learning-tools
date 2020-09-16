package com.fherdelpino.collections.sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BubbleSort {

    public int[] sort(int[] numbers) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i - 1] > numbers[i]) {
                    int tmp = numbers[i - 1];
                    numbers[i - 1] = numbers[i];
                    numbers[i] = tmp;
                    swapped = true;
                }
            }
            log.info("array={}", numbers);
        } while (swapped);
        return numbers;
    }

}
