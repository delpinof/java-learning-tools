package com.fherdelpino.collections.sort;

import static com.fherdelpino.collections.sort.CollectionUtils.swap;

public class MergeSort {

    public int[] sort(int[] numbers) {
        if (numbers.length < 2)
            return numbers;

        //split left & right
        int middlePos = numbers.length / 2;
        int[] left = new int[middlePos];
        int[] right = new int[numbers.length - middlePos];
        for (int i = 0; i < middlePos; i++) {
            left[i] = numbers[i];
            right[i] = numbers[middlePos + i];
        }
        right[right.length - 1] = numbers[numbers.length - 1];

        //sort left & right
        left = sort(left);
        right = sort(right);

        //merge left & right
        int leftPos = 0;
        int rightPos = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (leftPos >= left.length) {
                numbers[i] = right[rightPos++];
                continue;
            }
            if (rightPos >= right.length) {
                numbers[i] = left[leftPos++];
                continue;
            }
            if (left[leftPos] < right[rightPos]) {
                numbers[i] = left[leftPos++];
            } else {
                numbers[i] = right[rightPos++];
            }
        }

        return numbers;
    }
}
