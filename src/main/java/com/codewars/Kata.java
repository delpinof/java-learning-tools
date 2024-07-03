package com.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {

    public static int[] arrayDiff(int[] a, int[] b) {
        // Your code here
        List<Integer> aList = new ArrayList<>(IntStream.of(a).boxed().toList());
        List<Integer> bList = IntStream.of(b).boxed().toList();
        aList.removeAll(bList);
        return aList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static Map<Character, Integer> count(String str) {
        if (str == null || str.isEmpty() || str.isBlank()) {
            return new HashMap<>();
        }
        return Arrays.stream(str.split(""))
                .map(s -> s.charAt(0))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
    }
}
