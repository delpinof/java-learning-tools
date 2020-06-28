package com.fherdelpino.test.challenge;

import org.junit.Test;

import com.fherdelpino.challenge.StringPermutations;

import static org.junit.Assert.assertEquals;

public class StringPermutationsTest {

    @Test
    public void smallInBigStringTest() {
        String s = "abbc";
        String b = "cbabadcbbabbcbabaabccbabc";
        int numberOfPermutations = new StringPermutations().findPermutations(s, b);
        assertEquals(7, numberOfPermutations);
    }

}
