package com.fherdelpino.datastructures;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Trie {
    private final Character c;
    private final Map<Character, Trie> children;
    private boolean isFinal;


    public Trie() {
        this(null);
    }

    public Trie(Character c) {
        this.c = c;
        children = new HashMap<>();
    }

    public void addWord(String s) {
        addWord(s, 0);
    }

    private void addWord(String s, int i) {
        char c = s.charAt(i);
        if (!children.containsKey(c)) {
            children.put(c, new Trie(c));
        }
        Trie t = children.get(c);
        if (i < s.length() - 1) {
            t.addWord(s, i + 1);
        } else {
            t.isFinal = true;
        }
    }

    public List<String> getWords() {
        String thisChar = Objects.isNull(this.c) ? "": String.valueOf(this.c);
        List<String> words = new ArrayList<>();
        if (this.isFinal) {
            words.add(thisChar);
        } else {
            for (Trie t : children.values()) {
                for (String word : t.getWords()) {
                    words.add(thisChar + word);
                }
            }
        }
        return words;
    }

    public List<String> getWords(String prefix) {
        return getWords(prefix, 0);
    }

    private List<String> getWords(String prefix, int i) {
        List<String> words = new ArrayList<>();
        if (i == prefix.length()) {
            return this.getWords();
        } else if (children.containsKey(prefix.charAt(i))) {
            Trie t = children.get(prefix.charAt(i));
            String thisChar = Objects.isNull(this.c) ? "": String.valueOf(this.c);
            for (String word : t.getWords(prefix, i + 1)) {
                words.add(thisChar + word);
            }
        }
        return words;
    }

    public boolean searchWord(String word) {
        return true;
    }
}
