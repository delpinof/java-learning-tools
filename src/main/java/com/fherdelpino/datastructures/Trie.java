package com.fherdelpino.datastructures;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class Trie {

    private final char c;
    private final Set<Trie> childs;

    public Trie() {
        c = ' ';
        this.childs = new HashSet<>();
    }

    public Trie(char c) {
        this.c = c;
        this.childs = new HashSet<>();
    }

    public void addWord(String word) {
        if (word.length() < 1) {
            return;
        }
        char tmpC = word.toCharArray()[0];

        Consumer<Trie> addWordToChild = child -> child.addWord(word.substring(1));
        Runnable addNewTrie = () -> {
            Trie t = new Trie(tmpC);
            t.addWord(word.substring(1));
            childs.add(t);
        };
        childs.stream()
                .filter(child -> child.c == tmpC)
                .findFirst()
                .ifPresentOrElse(addWordToChild, addNewTrie);
    }

    public boolean searchWord(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        char tmpC = chars[0];
        List<Trie> tries = childs.stream()
                .filter(trie -> trie.c == tmpC)
                .toList();
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
