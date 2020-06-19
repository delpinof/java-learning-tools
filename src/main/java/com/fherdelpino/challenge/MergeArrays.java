package com.fherdelpino.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeArrays {

    public static void main(String[] args) {

        int[] B = new int[6];
        B[0] = 2;
        B[1] = 4;
        B[2] = 8;

        int[] result = new MergeArrays().merge(new int[] { 1, 7, 9 }, B);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    public int[] merge(int[] A, int[] B) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            numbers.add(A[i]);
            numbers.add(B[i]);
        }

        Collections.sort(numbers);

        for (int i = 0; i < B.length; i++)
            B[i] = numbers.get(i);

        return B;
    }
}
