package com.fherdelpino.challenge;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;


public class StringUtilsTest {

    @Test
    public void testGetLongestSubstring() {
        String result = StringUtils.getLongestSubstring("abcdefg", "xyzcdekq");
        assertThat(result).isEqualTo("cde");
    }

    @Test
    public void testGetLongestSubstringMulti() {
        String result = StringUtils.getLongestSubstring("reflower", "flow");
        assertThat(result).isEqualTo("flow");
    }

    @Test
    public void testIndexOf() {

        String prefix = "leets";
        while ("leetcode".indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
        }
        assertThat(prefix).isEqualTo("leet");
    }
}
