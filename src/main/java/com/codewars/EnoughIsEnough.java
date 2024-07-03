package com.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int e : elements) {
            Integer o = occurrences.merge(e, 1, Integer::sum);
            if (o <= maxOccurrences) {
                result.add(e);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
