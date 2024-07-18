package com.fherdelpino.datastructures.collections;

import java.util.ArrayList;
import java.util.List;

public class PrefixTree {

    private String c;
    private List<PrefixTree> nodes;

    private boolean isTerminal;

    public PrefixTree() {
        c = "";
        nodes = new ArrayList<>();
        isTerminal = false;
    }

    private PrefixTree(String c) {
        this();
        this.c = c;
    }

    public void addWord(String word) {
        if (word.isEmpty()) {
            this.isTerminal = true;
            return;
        }
        String letter = word.substring(0, 1);
        boolean found = false;
        for (PrefixTree node : nodes) {
            if (letter.equalsIgnoreCase(node.c)) {
                node.addWord(word.substring(1));
                found = true;
            }
        }
        if (!found) {
            PrefixTree node = new PrefixTree(letter);
            node.addWord(word.substring(1));
            nodes.add(node);
        }
    }

    public List<String> getWords(String prefix) {
        List<String> words = new ArrayList<>();
        if (prefix == null || prefix.isEmpty()) {
            return this.getWords();
        }
        String letter = prefix.substring(0,1);
        for (PrefixTree node: nodes) {
            if (letter.equalsIgnoreCase(node.c)) {
                String letters = prefix.substring(1);
                for (String word : node.getWords(letters)) {
                    words.add(this.c + word);
                }
            }
        }
        return words;
    }

    public List<String> getWords() {
        List<String> words = new ArrayList<>();
        if (this.nodes == null || this.nodes.isEmpty()) {
            words.add(this.c);
            return words;
        }
        for (PrefixTree node : this.nodes) {
            for (String word : node.getWords()) {
                words.add(this.c + word);
            }
        }
        if (isTerminal) {
            words.add(this.c);
        }
        return words;
    }
}
