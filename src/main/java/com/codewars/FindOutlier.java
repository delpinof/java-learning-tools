package com.codewars;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class FindOutlier {
    public static int find(int[] integers) {
        IntPredicate outlierFilter = isMostlyOdd(integers) ?
                FindOutlier::isEven :
                FindOutlier::isOdd;
        return Arrays.stream(integers)
                .filter(outlierFilter)
                .findFirst()
                .orElse(0);
    }

    public static boolean isMostlyOdd(int[] integers) {
        int count = 0;
        for(int i = 0;i<3;i++) {
            count += isOdd(integers[i]) ? 1:0;
        }
        return count > 1;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    private static boolean isOdd(int n) {
        return !isEven(n);
    }
}
