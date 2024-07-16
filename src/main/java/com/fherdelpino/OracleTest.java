package com.fherdelpino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OracleTest {
    public static void main(String[] args) {
       OracleTest.run3();
    }

    /*
    Implement a method that takes in a list of strings as input and prints out all anagrams in buckets.

The method will have the following signature:
public void anagramBuckets(List<String> input)

Example input: List<String> ["star", "rats", "ice", "cie", "arts"]
Example output:
"star", "rats", "arts"
"ice", "cie"


start

s,1
t,1
a,1
r,1

r,1
a,1,
t,1
s, 1
     */
    public static void run3() {
        List<String> input = List.of("star", "rats", "ice", "cie", "arts");
        //Map<String, Map<String,Integer>> maps = new HashMap<>();
        Map<Map<String,Integer>, List<String>> wordMap = new HashMap<>();

        Set<Set<String>> result = new HashSet<>();
        for (String word: input) {
            var characterMap = createMap(word);
            if (wordMap.containsKey(characterMap)) {
                wordMap.get(characterMap).add(word);
            } else {
                wordMap.put(characterMap, new ArrayList<>());
                wordMap.get(characterMap).add(word);
            }
        }
/*
        for (int i = 0; i<input.size()-1; i++) {
            for(int j=i+1; j<input.size(); j++) {
                var mapI = maps.get(input.get(i));
                var mapJ = maps.get(input.get(j));
                if (mapI.equals(mapJ)) {
                    Set<String> words = new HashSet<>();
                    words.add(input.get(i));
                    words.add(input.get(j));
                    result.add(words );
                }
            }
        }

 */
        System.out.println(wordMap.values());
    }

    public static Map<String, Integer> createMap(String s) {
        Map<String, Integer> characterMap = new HashMap<>();
        for (String letter: s.split("")) {
            characterMap.merge(letter, 1, Integer::sum);
        }
        return characterMap;
    }

    public static void run2() {
        String s = "abcde";
        int count = 0;
        for (char c : s.toCharArray()) {
            count++;
        }
        System.out.println(count);
    }

    public static void run1() {
        for(int i =0;i<=30;i++) {
            boolean printed = false;
            if (i%3==0) {
                System.out.print("Fizz");
                printed = true;
            }
            if (i%5==0) {
                System.out.print("Buzz");
                printed = true;
            }
            if (!printed) {
                System.out.print(i);
            }

            System.out.println("");
        }
    }
}
