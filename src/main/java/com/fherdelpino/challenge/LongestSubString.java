package com.fherdelpino.challenge;


import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static int getLongestSubList(String s) {
        int leftI = 0, rightI = 0;
        Set<Character> chars = new HashSet<>();
        int max = 0;
        while (rightI < s.length()) {
            char c = s.charAt(rightI);
            if (chars.contains(c)) {
                chars.remove(s.charAt(leftI));
                leftI++;
            } else {
                chars.add(c);
                rightI++;
                max = Math.max(chars.size(), max);
            }
        }
        return max;
    }

}
