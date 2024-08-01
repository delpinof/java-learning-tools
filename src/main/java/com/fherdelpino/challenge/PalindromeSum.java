package com.fherdelpino.challenge;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSum {

    public static int findSums(List<Integer> arr) {
        int count = 0;
        while (!isPalindrome(arr)) {
            if (arr.size() == 2) {
                if (!isPalindrome(arr))
                    count++;
                break;
            }
            int i = 0;
            while (arr.get(i).equals(arr.get(arr.size() - i - 1))) {
                i++;
            }

            if (arr.get(i) < arr.get(arr.size() - i - 1)) {
                arr = sumPair(arr, i, i + 1);
            } else {
                arr = sumPair(arr, arr.size() - i - 2, arr.size() - i - 1);
            }
            count++;
        }


        return count;
    }

    public static List<Integer> sumPair(List<Integer> arr, int leftIndex, int rightIndex) {
        int sum = arr.get(leftIndex) + arr.get(rightIndex);
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (i == leftIndex) {
                newList.add(sum);
                i++;
            } else {
                newList.add(arr.get(i));
            }
        }
        return newList;
    }

    public static boolean isPalindrome(List<Integer> arr) {
        if (arr.size() == 1) {
            return true;
        }
        for (int i = 0; i < arr.size() / 2; i++) {
            if (!arr.get(i).equals(arr.get(arr.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }


}
