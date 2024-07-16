package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class NonDivisibleSubsetTest {

    @Test
    public void testLargeIntegers() {
        int s = Integer.MAX_VALUE;
        int n = Integer.MAX_VALUE;

        int result = s+1;
        log.info("{}", result);
    }

    @ParameterizedTest
    @MethodSource
    public void testNonDivisibleSubset(int k, List<Integer> s, int expected) {
        int result = NonDivisibleSubset.find(k, s);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> testNonDivisibleSubset() {
        return Stream.of(
                Arguments.of(3,
                        List.of(1, 7, 2, 4),
                        3),
                Arguments.of(7,
                        List.of(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436),
                        11),
                Arguments.of(5,
                        List.of(770528134, 663501748, 384261537, 800309024, 103668401, 538539662, 385488901, 101262949, 557792122, 46058493),
                        6)
        );
    }
}
