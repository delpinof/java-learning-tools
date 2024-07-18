package com.fherdelpino.datastructures;

import com.fherdelpino.datastructures.collections.PrefixTree;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class PrefixTreeTest {

    private static String BOOK;

    @BeforeAll
    public static void load() throws IOException {
        InputStream is = PrefixTreeTest.class.getClassLoader().getResourceAsStream("data/the_picture_of_dorian_gray.txt");
        BOOK = new String(is.readAllBytes());
    }

    @Test
    public void test() {
        PrefixTree pt = new PrefixTree();
        pt.addWord("avengers");
    }

    @Test
    public void testGetWords() {
        PrefixTree pt = new PrefixTree();
        pt.addWord("bull");
        pt.addWord("bullying");
        pt.addWord("bulk");
        assertThat(pt.getWords()).containsExactlyInAnyOrder("bull", "bullying", "bulk");
    }

    @Test
    public void testGetWordsParameterized() {
        PrefixTree pt = new PrefixTree();
        pt.addWord("macrocosm");
        pt.addWord("mac");
        pt.addWord("madman");
        pt.addWord("ant");
        pt.addWord("and");
        assertThat(pt.getWords("an")).containsExactlyInAnyOrder("ant", "and");
    }

    @Test
    public void testGetExactWord() {
        PrefixTree pt = new PrefixTree();
        pt.addWord("ab");
        pt.addWord("a");
        assertThat(pt.getWords("a")).containsExactlyInAnyOrder("a", "ab");
    }

    @Test
    public void testAddDuplicates() {
        PrefixTree pt = new PrefixTree();
        pt.addWord("ant");
        pt.addWord("ant");
        pt.addWord("ant");
        pt.addWord("ant");
        assertThat(pt.getWords().size()).isEqualTo(1);
    }

    @Test
    public void testMassive() {
        PrefixTree pt = new PrefixTree();
        String[] words = BOOK.split("\\W+");
        for(String word : words) {
            pt.addWord(word.toLowerCase());
        }
        log.info("{}", pt.getWords("ex"));
    }
}
