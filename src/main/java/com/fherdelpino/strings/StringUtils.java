package com.fherdelpino.strings;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public static String getLongestSubstring(String left, String right) {
        if (left == null || left.isEmpty() || right == null || right.isEmpty()) {
            return "";
        }
        int[][] matrix = new int[left.length()][right.length()];
        Longest l = new Longest();
        for (int i = 0; i < left.length(); i++) {
            for (int j = 0; j < right.length(); j++) {
                if (left.charAt(i) == right.charAt(j)) {
                    matrix[i][j] = i == 0 || j == 0 ? 1 : matrix[i - 1][j - 1] + 1;
                    if (matrix[i][j] > l.value) {
                        l.value = matrix[i][j];
                        l.i = i;
                        l.j = j;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = l.i, j = l.j; i >= 0 && j >= 0 && matrix[i][j] > 0; i--, j--) {
            result.append(left.charAt(i));
        }
        return result.reverse().toString();
    }

    private static class Longest {
        int i;
        int j;
        int value;
    }

    public static List<String> getSubstrings(String word) {
        List<String> permutations = new ArrayList<>();
        for (int n = 1; n <= word.length(); n++) {
            permutations.addAll(getSubstringsOf(word, n));
        }
        return permutations;
    }

    public static List<String> getSubstringsOf(String word, int n) {
        List<String> permutations = new ArrayList<>();
        for (int i = 0; i < word.length() - (n - 1); i++) {
            permutations.add(word.substring(i, i + n));
        }
        return permutations;
    }

    public static boolean twoStrings(String s1, String s2) {
        for (int n = 1; n <= s2.length(); n++)
            for (int i = 0; i < s2.length() - (n - 1); i++) {
                if (s1.contains(s2.substring(i, i + n)))
                    return true;
            }
        return false;
    }

    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    public static String longestPalindrome(String s) {
        int maxI = 0;
        int maxJ = 0;
        if (s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (isPalindrome(s, i, j)) {
                    if (j - i > maxJ - maxI) {
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        return s.substring(maxI, maxJ + 1);
    }

    public static boolean isPalindrome(String s, int from, int to) {
        if (s.length() < 1 || to - from < 0) {
            return false;
        }
        for (int i = from, j = to; j - i > 0; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
