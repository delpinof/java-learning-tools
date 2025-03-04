package com.fherdelpino.datastructures;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class TrieTest {

    @Test
    public void testOneLetter() {
        Trie t = new Trie();
        t.addWord("d");
        log.info("trie={}", t);
    }

    @Test
    public void testOneWord() {
        Trie t = new Trie();
        t.addWord("dog");
        log.info("trie={}", t);
    }

    @Test
    public void testMultipleWords() {
        Trie t = new Trie();
        t.addWord("dog");
        t.addWord("deer");
        t.addWord("deal");
        log.info("trie={}", t);
    }

    @Test
    public void testContainsWords() {
        Trie t = new Trie();
        t.addWord("dog");
        t.addWord("deer");
        t.addWord("deal");
        List<String> words = t.getWords();
        assertThat(words).containsExactlyInAnyOrder("dog", "deer", "deal");
    }

    @Test
    public void testContainsWordsPrefix() {
        Trie t = new Trie();
        t.addWord("dog");
        t.addWord("deer");
        t.addWord("deal");
        List<String> words = t.getWords("de");
        assertThat(words).containsExactlyInAnyOrder("deer", "deal");
    }

    @Test
    public void testSearchExistingWord() {
        String word = "dog";
        Trie t = new Trie();
        t.addWord(word);
        assertTrue(t.searchWord(word));
    }

    @Test
    public void testSearchNonExistingWord() {
        String word = "dog";
        Trie t = new Trie();
        t.addWord(word);
        assertFalse(t.searchWord("nonExistingWord"));
    }

    @Test
    public void testSearchMultipleWords() {
        Trie t = new Trie();
        t.addWord("dog");
        t.addWord("deer");
        t.addWord("deal");
        assertFalse(t.searchWord("nonExistingWord"));
        assertTrue(t.searchWord("dog"));
        assertTrue(t.searchWord("deer"));
        assertTrue(t.searchWord("deal"));
    }

}
