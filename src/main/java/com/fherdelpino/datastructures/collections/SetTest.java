package com.fherdelpino.datastructures.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        String[] values = {"on", "On", "on"};
        Set<String> words = new HashSet<>(Arrays.asList(values));
        words.remove("on");
        System.out.println(words);
    }
}
