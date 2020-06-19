package com.fherdelpino.test.datastructures;

import com.fherdelpino.datastructures.Trie;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
