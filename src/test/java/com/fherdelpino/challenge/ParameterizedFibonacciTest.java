package com.fherdelpino.challenge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ParameterizedFibonacciTest {

    public static Stream<Arguments> fData() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(2, 1),
                Arguments.of(3, 1),
                Arguments.of(4, 2),
                Arguments.of(5, 3),
                Arguments.of(6, 5),
                Arguments.of(7, 8),
                Arguments.of(8, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("fData")
    public void testCompute(int fInput, int fExpected) {
        assertThat(Fibonacci.compute(fInput)).isEqualTo(fExpected);
    }

    @ParameterizedTest
    @MethodSource("fData")
    public void testComputeWithMemo(int fInput, int fExpected) {
        assertThat(Fibonacci.computeWithMemo(fInput)).isEqualTo(fExpected);
    }
}
