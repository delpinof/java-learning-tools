package com.fherdelpino.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrefixTree {

    public static void main(String[] args) {
        new PrefixTree().run();
    }

    public void run() {
        Collection<String> result = trie("de", Arrays.asList("dog", "deer", "deal"));
        System.out.println(result);
        int i = 10;
        while(i--==0);
    }

    public Collection<String> trie(String s, Collection<String> words) {
        Stream<String> x = words.stream();
        Set<String> result = words.stream().filter(word -> word.startsWith(s)).collect(Collectors.toSet());
        return result;
    }
}
