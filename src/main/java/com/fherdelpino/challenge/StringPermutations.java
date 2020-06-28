package com.fherdelpino.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public List<String> findPermutations(String s) {
        List<String> permutations = new ArrayList<>();
        if (s.length() == 1) {
            permutations.add(s);
        } else if (s.length() == 2) {
            permutations.add(s);
            permutations.add(new StringBuilder(s).reverse().toString());
        } else {
            List<String> previousPermutations = findPermutations(s.substring(0, s.length() - 1));
            String c = s.substring(s.length() - 1);
            for (String prevPer : previousPermutations) {
                permutations.addAll(fillString(prevPer, c));
            }
        }
        return permutations;
    }

    public List<String> fillString(String source, String c) {
        List<String> filledString = new ArrayList<>();
        for (int i = 0; i <= source.length(); i++) {
            StringBuilder sb = new StringBuilder(source);
            sb.insert(i, c);
            filledString.add(sb.toString());
        }
        return filledString;
    }
}
