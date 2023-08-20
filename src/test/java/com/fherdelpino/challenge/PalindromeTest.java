package com.fherdelpino.challenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeTest {

    @Test
    public void test() {
        var palindrome = "Dabale arroz a la zorra el abad";
        var isPalindrome = Palindrome.isPalindrome(palindrome);
        assertThat(isPalindrome).isTrue();
    }

    @ParameterizedTest
    @MethodSource
    public void testFindPalindrome(String input, String expectedOutput) {
        String actualOutput = Palindrome.findPalindrome(input);
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> testFindPalindrome() {
        return Stream.of(
                Arguments.of("abcdefgabccbahijklm", "abccba"),
                Arguments.of("abcdefghijklmnopqzxyxz", "zxyxz"),
                Arguments.of("abcdefghijklmnopq", ""),
                Arguments.of("zxyxzabcdefghijklmnopq", "zxyxz"),
                Arguments.of("abccbaabcdefghijklmnopq", "abccba")
        );
    }
}
