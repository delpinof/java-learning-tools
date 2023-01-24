package com.fherdelpino.challenge;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Objects.isNull;

public class KeyPad2 {
    private final Trie ROOT = new Trie("root");
    private final List<String> WORDS = new ArrayList<>();

    private final Map<String, String[]> KEY_PAD = Map.of(
            "0", new String[]{""},
            "1", new String[]{""},
            "2", new String[]{"A", "B", "C"},
            "3", new String[]{"D", "E", "F"},
            "4", new String[]{"G", "H", "I"},
            "5", new String[]{"J", "K", "L"},
            "6", new String[]{"M", "N", "O"},
            "7", new String[]{"P", "Q", "R", "S"},
            "8", new String[]{"T", "U", "V"},
            "9", new String[]{"W", "X", "Y", "Z"}
    );

    public void addNumber(int number) {
        addNumber(String.valueOf(number), ROOT);
    }

    private void addNumber(String number, Trie trie) {
        if (number.length() == 0) {
            return;
        }
        String firstDigit = getFirstChar(number);
        for (String letter : KEY_PAD.get(firstDigit)) {
            Trie child = new Trie(letter);
            trie.getChildren().add(child);
            addNumber(getTrieSubString(number), child);
        }
    }

    public List<String> getWords() {
        WORDS.clear();
        getWords(ROOT, "", WORDS);
        return WORDS;
    }

    private void getWords(Trie trie, String word, List<String> words) {
        Set<Trie> children = trie.getChildren();
        if (isNull(children) || children.isEmpty()) {
            words.add(word);
        } else {
            for (Trie child : children) {
                getWords(child, word + child.getValue(), words);
            }
        }
    }

    String getFirstChar(String word) {
        return word.substring(0, 1);
    }

    String getTrieSubString(String word) {
        return word.substring(1);
    }

    @Getter
    static class Trie {

        private final String value;
        private final Set<Trie> children;

        public Trie(String value) {
            this.value = value;
            children = new HashSet<>();
        }

    }
}
