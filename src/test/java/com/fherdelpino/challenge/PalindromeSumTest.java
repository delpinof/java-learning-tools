package com.fherdelpino.challenge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PalindromeSumTest {

    @Test
    public void testSums() {
        var input = new ArrayList<>(List.of(2, 9, 7, 1, 4, 7));
        Assertions.assertThat(PalindromeSum.findSums(input)).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource
    public void testSumPair(List<Integer> input, int left, int right, List<Integer> expectedOutput) {
        Assertions.assertThat(PalindromeSum.sumPair(input, left, right)).isEqualTo(expectedOutput);
    }

    public static Stream<Arguments> testSumPair() {
        return Stream.of(
                Arguments.of(List.of(2, 9, 7, 1, 4, 7), 0, 1, List.of(11, 7, 1, 4, 7)),
                Arguments.of(List.of(2, 9, 7, 1, 4, 7), 4, 5, List.of(2, 9, 7, 1, 11)),
                Arguments.of(List.of(11, 7, 1, 11), 1, 2, List.of(11,8,11))
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testIsPalindrome(List<Integer> arr, boolean expectedResult) {
        Assertions.assertThat(PalindromeSum.isPalindrome(arr)).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> testIsPalindrome() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 3, 2, 1), true),
                Arguments.of(List.of(1, 2, 3, 4, 3, 2, 1), true),
                Arguments.of(List.of(1, 2, 1, 3, 2, 1), false),
                Arguments.of(List.of(1, 2, 3, 1, 1), false)
        );
    }
}
