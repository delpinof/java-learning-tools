package com.fherdelpino.challenge;


import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KeyPad2Test {

    private final KeyPad2 sut = new KeyPad2();

    @Test
    public void testGetFirstLetter() {
        String actualResult = sut.getFirstChar("word");
        assertThat(actualResult).isEqualTo("w");
    }

    @Test
    public void testGetSubString() {
        String actualResult = sut.getTrieSubString("word");
        assertThat(actualResult).isEqualTo("ord");
    }

    @Test
    public void testAddNumber() {
        sut.addNumber(23);
        List<String> words = sut.getWords();
        List<String> expectedResults = List.of("AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF");
        assertThat(words)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedResults);
    }
}
