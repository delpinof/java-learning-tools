package com.fherdelpino.challenge;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class StringPermutations {

    /**
     * Find any permutation of the small String into the Big String.
     *
     * @param small
     * @param big
     * @return
     */
    public int findPermutations(String small, String big) {
        int numberOfPermutations = 0;
        Map<String, Integer> sMap = convertToMap(small);
        for (int i = 0; i <= big.length() - small.length(); i++) {
            String sub = big.substring(i, i + small.length());
            Map<String, Integer> bMap = convertToMap(sub);
            if (sMap.equals(bMap)) {
                numberOfPermutations++;
            }
        }
        return numberOfPermutations;
    }

    private Map<String, Integer> convertToMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (String letter : s.split(StringUtils.EMPTY)) {
            Integer n = map.get(letter) == null ? 0 : map.get(letter);
            map.put(letter, n + 1);
        }
        return map;
    }
}
