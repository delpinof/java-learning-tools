package com.fherdelpino.strings;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
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

    @Test
    public void testGetSubstrings() {
        String abc= "abc";
        List<String> result = StringUtils.getSubstrings(abc);

        assertThat(result).contains("a", "b", "c", "ab", "bc", "abc");
    }

    @Test
    public void testTwoStrings() {
        String abc = "abc";
        String bcz = "bcz";
        boolean result = StringUtils.twoStrings(abc, bcz);
        assertThat(result).isTrue();
    }

    @Test
    public void testIsPalindrome() {
        boolean result = StringUtils.isPalindrome("abcxcba");
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void testLongestPalindrome2() {
        String result = StringUtils.longestPalindrome("jrjnbctoqgzimtoklkxcknwmhiztomaofwwzjnhrijwkgmwwuazcowskjhitejnvtblqyepxispasrgvgzqlvrmvhxusiqqzzibcyhpnruhrgbzsmlsuacwptmzxuewnjzmwxbdzqyvsjzxiecsnkdibudtvthzlizralpaowsbakzconeuwwpsqynaxqmgngzpovauxsqgypinywwtmekzhhlzaeatbzryreuttgwfqmmpeywtvpssznkwhzuqewuqtfuflttjcxrhwexvtxjihunpywerkktbvlsyomkxuwrqqmbmzjbfytdddnkasmdyukawrzrnhdmaefzltddipcrhuchvdcoegamlfifzistnplqabtazunlelslicrkuuhosoyduhootlwsbtxautewkvnvlbtixkmxhngidxecehslqjpcdrtlqswmyghmwlttjecvbueswsixoxmymcepbmuwtzanmvujmalyghzkvtoxynyusbpzpolaplsgrunpfgdbbtvtkahqmmlbxzcfznvhxsiytlsxmmtqiudyjlnbkzvtbqdsknsrknsykqzucevgmmcoanilsyyklpbxqosoquolvytefhvozwtwcrmbnyijbammlzrgalrymyfpysbqpjwzirsfknnyseiujadovngogvptphuyzkrwgjqwdhtvgxnmxuheofplizpxijfytfabx");
        assertThat(result).isEqualTo("qosoq");
    }

}
