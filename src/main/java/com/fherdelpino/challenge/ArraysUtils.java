package com.fherdelpino.challenge;

import java.util.ArrayList;
import java.util.List;

public class ArraysUtils {
    //[1,7,9]
    //[2,4,8,0,0,0]
    //*
    //[0,0,9]
    //[1,2,4,7,8,0]
    //*
    public int[] merge(int[] A, int[] B) {
        int pA = 0;
        int pB = 0;
        while (pA < A.length && pB < B.length) {
            if (A[pA] == 0) {
                pA++;
            }
            if (pA < A.length - 1 && A[pA] > A[pA + 1]) {
                swap(A, pA, A, pA + 1);
            }
            if (A[pA] < B[pB] || B[pB] == 0) {
                swap(A, pA, B, pB);
            }
            pB++;
        }
        return B;
    }

    public void swap(int[] A, int pA, int[] B, int pB) {
        int tmp = A[pA];
        A[pA] = B[pB];
        B[pB] = tmp;
    }

    /**
     * Find elements in both arrays.
     *
     * @param A first array.
     * @param B second array.
     * @return number of elements found in both arrays.
     */
    public int findDuplicated(int[] A, int[] B) {
        int count = 0;
        for (int a = 0, b = 0; a < A.length && b < B.length; ) {
            if (A[a] == B[b]) {
                count++;
                a++;
                b++;
            } else if (A[a] > B[b]) {
                b++;
            } else {
                a++;
            }
        }
        return count;
    }

    public int[] getCopy(int[] original, int start, int end) {
        int[] copy = new int[end - start];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = original[start + i];
        }
        return copy;
    }

    public List<int[]> getSubArraysOf(int[] array, int subStringSize) {
        List<int[]> subArrays = new ArrayList<>();
        for (int i = 0; i <= array.length - subStringSize; i++) {
            subArrays.add(getCopy(array, i, i + subStringSize));
        }
        return subArrays;
    }

    public List<int[]> getAllSubArrays(int[] array) {
        List<int[]> subArrays = new ArrayList<>();
        for (int i = 1; i<=array.length; i++) {
            subArrays.addAll(getSubArraysOf(array, i));
        }
        return subArrays;
    }
}
