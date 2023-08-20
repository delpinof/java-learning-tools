package com.fherdelpino.challenge;


public class Palindrome {

    public static boolean isPalindrome(String s) {
        var charArray = s.replaceAll(" ", "")
                .toLowerCase()
                .toCharArray();
        return isPalindrome(charArray, 0, charArray.length - 1);
    }

    private static boolean isPalindrome(char[] string, int left, int right) {
        if (right - left <= 1) {
            return true;
        } else {
            return string[left] == string[right] && isPalindrome(string, left + 1, right - 1);
        }
    }

    /**
     * Find the palindromic string in a String s
     *
     * @param s the string that has a palindrome in any place.
     * @return the palindromic String
     */
    public static String findPalindrome(String s) {
        String[] letters = s.split("");
        int start = 0;
        int end = 0;
        for (int i = 0; i < letters.length - 2; i++) {
            boolean pairPalindrome = letters[i].equals(letters[i + 1]);
            boolean oddPalindrome = letters[i].equals(letters[i + 2]);
            if (pairPalindrome || oddPalindrome) {
                start = i - 1;
                end = i + (pairPalindrome ? 2 : 3);
                while (start >= 0 && end < letters.length && letters[start].equals(letters[end])) {
                    start--;
                    end++;
                }
                break;
            }
        }
        return start == end ? "" : s.substring(start + 1, end);
    }
}
