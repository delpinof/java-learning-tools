package com.fherdelpino.test.collections.sort;

import java.util.Random;

public class CollectionsTestUtils {

    public static int[] testData10Ints = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static int[] getTestDataNInts(int n) {
        Random random = new Random();
        int[] testData = new int[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(n);
        }
        return testData;
    }
}
