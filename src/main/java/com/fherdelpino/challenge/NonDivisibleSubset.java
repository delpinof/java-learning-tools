package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NonDivisibleSubset {

    /*
    Given a set of distinct integers, print the size of a maximal subset of  where the sum of any numbers in s is not evenly divisible by k.
     */
    public static int find(int k, List<Integer> s) {
        List<Integer> numbers = new ArrayList<>();
        int maxCount = 0;
        for (int i = 0; i < s.size(); i++) {
            numbers.add(s.get(i));
            for (int j = 0; j < s.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (isNotEvenlyDivisible(k, s.get(j), numbers)) {
                    numbers.add(s.get(j));
                }
            }
            //log.info("from {} - {}", i, numbers);
            if (numbers.size() > maxCount) {
                maxCount = numbers.size();
            }

            numbers = new ArrayList<>();
        }

        return maxCount;
    }

    private static boolean isNotEvenlyDivisible(int k, int j, List<Integer> numbers) {
        for (int n : numbers) {
            int sum = n + j;
            if (sum % k == 0) {
                return false;
            }
        }
        return true;
    }
}
