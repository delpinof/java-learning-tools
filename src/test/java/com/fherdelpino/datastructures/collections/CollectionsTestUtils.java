package com.fherdelpino.datastructures.collections;

import java.util.Random;

public class CollectionsTestUtils {

    public static int[] testData10IntsReverseOrder = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static int[] getTestDataRandomNInts(int n) {
        Random random = new Random();
        int[] testData = new int[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(n);
        }
        return testData;
    }

    public static int[] getTestDataNConsecutiveInts(int n) {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }
}
