package com.fherdelpino.challenge;

import java.util.List;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertEquals;

@Slf4j
public class StringPermutationsTest {

    @Test
    public void smallInBigStringTest() {
        String s = "abbc";
        String b = "cbabadcbbabbcbabaabccbabc";
        int numberOfPermutations = new StringPermutations().findPermutations(s, b);
        assertEquals(7, numberOfPermutations);
    }

    @Test
    public void findPermutationsTest() {
        String s = "abcd";
        List<String> permutations = new StringPermutations().findPermutations(s);
        log.info("permutations={}", permutations);
    }

}
