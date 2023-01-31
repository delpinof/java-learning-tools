package com.fherdelpino.challenge;

import java.util.Arrays;

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
     * Count elements in both arrays.
     *
     * @param A first array.
     * @param B second array.
     * @return number of elements found in both arrays.
     */
    public static int countDuplicates(int[] A, int[] B) {
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

    public int[][] getSubArraysOf(int[] array, int subArrayLength) {
        int numOfSubArrays = array.length - (subArrayLength - 1);
        int[][] subArrays = new int[numOfSubArrays][];
        for (int i = 0; i < numOfSubArrays; i++) {
            subArrays[i] = Arrays.copyOfRange(array, i, i + subArrayLength);
        }
        return subArrays;
    }

    public int[][] getAllSubArrays(int[] array) {
        int numOfSubArrays = (array.length + 1) * array.length / 2;
        int[][] subArrays = new int[numOfSubArrays][];
        int subArraysLastIdx = 0;
        for (int mainIdx = 1; mainIdx <= array.length; mainIdx++) {
            int[][] subArraysOfN = getSubArraysOf(array, mainIdx);
            for (int[] subArrayOfN : subArraysOfN) {
                subArrays[subArraysLastIdx++] = subArrayOfN;
            }
        }
        return subArrays;
    }
}
