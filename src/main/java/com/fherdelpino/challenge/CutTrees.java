package com.fherdelpino.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CutTrees {
    public static List<Integer> cutTheSticks(List<Integer> arr) {
        if (arr.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(arr.size());
        int smaller = arr.stream()
                .mapToInt(n -> n)
                .min()
                .orElse(0);
        List<Integer> cut = arr.stream()
                .map(n -> n - smaller)
                .filter(n -> n > 0)
                .collect(Collectors.toList());
        answer.addAll(cutTheSticks(cut));
        return answer;
    }
}
