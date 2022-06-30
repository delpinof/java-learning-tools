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
}
