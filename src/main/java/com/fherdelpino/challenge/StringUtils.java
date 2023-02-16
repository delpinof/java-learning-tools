package com.fherdelpino.challenge;

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
        for (int i = l.i, j = l.j; i>=0 && j>=0 && matrix[i][j] > 0; i--, j--) {
            result.append(left.charAt(i));
        }
        return result.reverse().toString();
    }

    private static class Longest {
        int i;
        int j;
        int value;
    }
}
