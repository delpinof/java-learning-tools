package com.fherdelpino.datastructures.collections;

import java.util.ArrayList;
import java.util.List;

public class PrefixTree {

    private String c;
    private final List<PrefixTree> nodes;

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
        String firstLetter = word.substring(0, 1);
        this.nodes.stream()
                .filter(node -> firstLetter.equalsIgnoreCase(node.c))
                .findFirst()
                .ifPresentOrElse(node -> node.addWord(word.substring(1)),
                        () -> {
                            // firstLetter not found
                            // create a new PrefixTree and add it to the nodes.
                            PrefixTree node = new PrefixTree(firstLetter);
                            node.addWord(word.substring(1));
                            nodes.add(node);
                        });

    }

    public List<String> getWords(String prefix) {
        List<String> words = new ArrayList<>();
        if (prefix == null || prefix.isEmpty()) {
            return this.getWords();
        }
        String firstLetter = prefix.substring(0, 1);
        nodes.stream()
                .filter(node -> firstLetter.equalsIgnoreCase(node.c))
                .findFirst()
                .ifPresent(node -> {
                    node.getWords(prefix.substring(1))
                            .forEach(word -> words.add(this.c + word));
                });
        return words;
    }

    public List<String> getWords() {
        List<String> words = new ArrayList<>();
        if (this.nodes == null || this.nodes.isEmpty()) {
            words.add(this.c);
            return words;
        }
        // get the words for each child node and prepend the current char c
        this.nodes.forEach(node -> node.getWords()
                .forEach(word -> words.add(this.c + word))
        );
        if (isTerminal) {
            // this is a saved word
            // even though it has child nodes
            words.add(this.c);
        }
        return words;
    }
}
