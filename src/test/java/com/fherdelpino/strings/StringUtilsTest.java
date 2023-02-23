package com.fherdelpino.strings;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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
        String abc = "abc";
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

    @ParameterizedTest
    @MethodSource("isPalindromeArgumentsProvider")
    public void testIsPalindrome(String s, boolean expected) {
        boolean actual = StringUtils.isPalindrome(s);
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> isPalindromeArgumentsProvider() {
        return Stream.of(
                Arguments.of("abba", true),
                Arguments.of("abcba", true),
                Arguments.of("abcxba", false),
                Arguments.of("c", true),
                Arguments.of("", false)
        );
    }

    @Test
    public void testLongestPalindrome() {
        String result = StringUtils.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
        assertThat(result).isEqualTo("ranynar");
    }

}
