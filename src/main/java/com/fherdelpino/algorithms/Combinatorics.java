package com.fherdelpino.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Combinatorics {

    public static List<List<String>> findCombinations(String[] values, int size) {
        List<List<String>> result = new ArrayList<>();
        List<String> combination = new ArrayList<>();
        powerSet(values, 0, size, result, combination);
        return result;
    }

    private static void powerSet(String[] values, int index, int limit, List<List<String>> result, List<String> combination) {
        if (combination.size() == limit) {
            result.add(combination);
            return;
        }
        if (index >= values.length) {
            return;
        }
        powerSet(values, index + 1, limit, result, combination);
        List<String> tmp = new ArrayList<>(combination);
        tmp.add(values[index]);
        powerSet(values, index + 1, limit, result, tmp);
    }
}
