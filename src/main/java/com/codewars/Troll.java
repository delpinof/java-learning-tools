package com.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class Troll {
    static String[] vowels = {"a","e","i","o","u"};

    public static String disemvowel(String str) {
        // Code away...
        return Arrays.stream(str.split(""))
                .filter(not(Troll::isVowel))
                .collect(Collectors.joining());
    }

    private static boolean isVowel(String c) {
        for (String v : vowels) {
            if (v.equalsIgnoreCase(c))
                return true;
        }
        return false;
    }
}
