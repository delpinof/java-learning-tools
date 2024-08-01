package com.fherdelpino.challenge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubStringTest {

    @Test
    void TestGetLongestSubList() {
        int n = LongestSubString.getLongestSubList("abcabcabc");
        assertThat(n).isEqualTo(3);
    }
}