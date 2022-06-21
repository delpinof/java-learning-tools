package com.fherdelpino.algorithms;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindUniquesBinary {

    public static void main(String[] args) {
        int[] values = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
                5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
                8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
                20, 20, 20, 20, 20, 20, 20, 20, 20};
        log.info("output={}", searchUniques(values));
    }

    public static int searchUniques(int[] values) {
        int greatest = values[values.length - 1];
        int firstAppearanceIndex = 0;
        int count = 1;
        while (values[firstAppearanceIndex] < greatest) {
            firstAppearanceIndex = searchUniques(values, values[firstAppearanceIndex], firstAppearanceIndex, values.length - 1);
            count++;
        }
        return count;
    }

    private static int searchUniques(int[] values, int n, int left, int right) {
        if (left > right)
            return -1;
        int middle = (right + left) / 2;
        if (values[middle] == n) {
            if (values[middle] != values[middle + 1]) {
                return middle + 1;
            }
            return searchUniques(values, n, middle + 1, right);
        }
        return searchUniques(values, n, left, middle - 1);
    }

}
