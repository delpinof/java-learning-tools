package com.fherdelpino.collections.sort;

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
                int tmp = numbers[i];
                numbers[i] = numbers[lowestPos];
                numbers[lowestPos] = tmp;
            }
        }

        return numbers;
    }
}