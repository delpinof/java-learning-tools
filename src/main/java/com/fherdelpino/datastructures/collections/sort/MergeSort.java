package com.fherdelpino.datastructures.collections.sort;

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
        right[right.length - 1] = numbers[numbers.length - 1]; //for odd list sizes

        //sort left & right
        left = sort(left);
        right = sort(right);

        //merge left & right
        int leftPos = 0;
        int rightPos = 0;
        int nPos = 0;
        while (leftPos < left.length && rightPos < right.length) {
            if (left[leftPos] < right[rightPos]) {
                numbers[nPos++] = left[leftPos++];
            } else {
                numbers[nPos++] = right[rightPos++];
            }
        }
        while (leftPos < left.length)
            numbers[nPos++] = left[leftPos++];
        while (rightPos < right.length)
            numbers[nPos++] = right[rightPos++];

        return numbers;
    }

    public void mergeSort(int[] numbers) {
        int size = numbers.length;
        sort(numbers, new int[size], 0, size);
    }

    public void sort(int[] numbers, int[] tmp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        sort(numbers, tmp, leftStart, middle);
        sort(numbers, tmp, middle + 1, rightEnd);
        merge(numbers, tmp, leftStart, rightEnd);
    }

    private void merge(int[] array, int[] tmp, int leftStart, int rightEnd) {
        int mid = (leftStart + rightEnd) / 2;

        int tmpIndex = leftStart;
        int leftIndex = leftStart;
        int rightIndex = mid + 1;

        while (leftIndex <= mid && rightIndex <= rightEnd) {
            if (array[leftIndex] < array[rightIndex]) {
                tmp[tmpIndex++] = array[leftIndex++];
            } else {
                tmp[tmpIndex++] = array[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            tmp[tmpIndex++] = array[leftIndex++];
        }

        while (rightIndex <= rightEnd) {
            tmp[tmpIndex++] = array[rightIndex++];
        }

        while (--tmpIndex >= leftStart) {
            array[tmpIndex] = tmp[tmpIndex];
        }

    }
}
