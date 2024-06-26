package com.fherdelpino.algorithms;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
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

    public static List<List<Integer>> getAllSubList(List<Integer> numbers) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j <= numbers.size(); j++) {
                List<Integer> subList = numbers.subList(i, j);
                result.add(subList);
            }
        }
        return result;
    }

    public static int sumList(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static List<Integer> getPrefixSum(List<Integer> numbers) {
        List<Integer> prefixSum = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0) {
                prefixSum.add(i, numbers.get(i));
            } else {
                int prefix = prefixSum.get(i - 1) + numbers.get(i);
                prefixSum.add(i, prefix);
            }
        }
        return prefixSum;
    }

    public static List<Integer> getAllSubListsSums1(List<Integer> numbers) {
        List<List<Integer>> subLists = Combinatorics.getAllSubList(numbers);
        Map<List<Integer>, Integer> sums = new HashMap<>();
        for(List<Integer> subList : subLists) {
            int sum = Combinatorics.sumList(subList);
            sums.put(subList, sum);
        }
        return new ArrayList<>(sums.values()) ;
    }

    public static List<Integer> getAllSubListSums2(List<Integer> numbers) {
        List<Integer> prefixSum = Combinatorics.getPrefixSum(numbers);
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i; j < numbers.size(); j++) {
                int sum = prefixSum.get(j);
                int leftIndex = j - i - 1;
                if (leftIndex >= 0) {
                    sum-=prefixSum.get(leftIndex);
                }
                sums.add(sum);
            }
        }
        return sums;
    }
}
