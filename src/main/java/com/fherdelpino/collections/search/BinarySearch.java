package com.fherdelpino.collections.search;

public class BinarySearch {

    public boolean searchIterative(int[] numbers, int n) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (n == numbers[mid])
                return true;
            if (n > numbers[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public boolean searchRecursive(int[] numbers, int n) {
        return searchRecursive(numbers, n, 0, numbers.length - 1);
    }

    private boolean searchRecursive(int[] numbers, int n, int left, int right) {
        if (left >= right)
            return false;
        int mid = left + (right - left) / 2;
        if (n == numbers[mid])
            return true;
        if (n > numbers[mid])
            return searchRecursive(numbers, n, mid + 1, right);
        else
            return searchRecursive(numbers, n, left, mid - 1);
    }
}