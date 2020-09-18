package com.fherdelpino.collections.search;

public class BinarySearch {

    public int searchIterative(int[] numbers, int n) {
        int left = 0;
        int right = numbers.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (n == numbers[mid])
                return mid;
            if (n > numbers[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public int searchRecursive(int[] numbers, int n) {
        return searchRecursive(numbers, n, 0, numbers.length - 1);
    }

    private int searchRecursive(int[] numbers, int n, int left, int right) {
        if (left >= right)
            return -1;
        int mid = left + (right - left) / 2;
        if (n == numbers[mid])
            return mid;
        if (n > numbers[mid])
            return searchRecursive(numbers, n, mid + 1, right);
        else
            return searchRecursive(numbers, n, left, mid - 1);
    }
}