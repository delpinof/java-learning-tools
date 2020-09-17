package com.fherdelpino.collections.sort;

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
}
