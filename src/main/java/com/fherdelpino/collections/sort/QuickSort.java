package com.fherdelpino.collections.sort;

import static com.fherdelpino.collections.sort.CollectionUtils.swap;

public class QuickSort {

    public int[] sort(int[] numbers, int startPos, int endPos) {

        if (startPos >= endPos)
            return numbers;

        int pivot = partition(numbers, startPos, endPos);

        sort(numbers, startPos, pivot - 1);
        sort(numbers, pivot + 1, endPos);
        return numbers;
    }

    private int partition(int[] numbers, int startPos, int endPos) {
        int pivotValue = numbers[endPos];
        int index = startPos;
        for (int i = startPos; i < endPos; i++) {
            if (numbers[i] < pivotValue) {
                swap(numbers, i, index++);
            }
        }
        swap(numbers, index, endPos);
        return index;
    }
}
