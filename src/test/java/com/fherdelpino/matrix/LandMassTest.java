package com.fherdelpino.matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LandMassTest {

    @ParameterizedTest
    @MethodSource("findLandMassesTestDataProvider")
    public void testFindLandMasses(int[][] matrix, int landMassesExpected) {
        int actualResult = LandMass.findLandMasses(matrix);
        assertThat(actualResult).isEqualTo(landMassesExpected);
    }

    public static Stream<Arguments> findLandMassesTestDataProvider() {
        int[][] m1 = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int[][] m2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        return Stream.of(
                Arguments.of(m1, 1),
                Arguments.of(m2, 3)
        );
    }
}
