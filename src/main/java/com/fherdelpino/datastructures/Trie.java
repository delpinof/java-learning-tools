package com.fherdelpino.datastructures;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Trie {

    private char c;
    private Set<Trie> childs;

    public Trie() {
        c = ' ';
        this.childs = new HashSet<>();
    }

    public void addWord(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        char tmpC = chars[0];
        List<Trie> tries = childs.stream()
                .filter(trie -> trie.c == tmpC)
                .collect(Collectors.toList());
        if (tries.size() == 0) {
            Trie t = new Trie();
            t.c = tmpC;
            if (chars.length > 1)
                t.addWord(word.substring(1));
            childs.add(t);
        } else {
            tries.get(0).addWord(word.substring(1));
        }
    }

    public boolean searchWord(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        char tmpC = chars[0];
        List<Trie> tries = childs.stream()
                .filter(trie -> trie.c == tmpC)
                .collect(Collectors.toList());
        if (tries.size() == 0) {
            return false;
        } else {
            if (chars.length > 1)
                return tries.get(0).searchWord(word.substring(1));
            else
                return true;
        }
    }

}
