package com.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Kata {

    public static int[] arrayDiff(int[] a, int[] b) {
        // Your code here
        List<Integer> aList = new ArrayList<>(IntStream.of(a).boxed().toList());
        List<Integer> bList = IntStream.of(b).boxed().toList();
        aList.removeAll(bList);
        return aList.stream().mapToInt(Integer::intValue).toArray();
    }
}
