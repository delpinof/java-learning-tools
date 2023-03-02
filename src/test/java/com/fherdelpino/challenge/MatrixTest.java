package com.fherdelpino.challenge;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MatrixTest {

    @ParameterizedTest(name = "{index} => {arguments}")
    @MethodSource("matrixProductDataProvider")
    public void testMatrixCrossProduct(int[][] m, int[][] n, int[][] expected) {

        int[][] result = Matrix.crossProduct(m, n);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("matrixProductDataProvider")
    public void testMatrixMapCrossProduct(int[][] m, int[][] n, int[][] expected) {
        var result = Matrix.crossProduct(Matrix.convert(m), Matrix.convert(n));
        printMatrix(result);
        assertThat(result).isEqualTo(Matrix.convert(expected));
    }

    public static Stream<Arguments> matrixProductDataProvider() {
        int[][] m = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        int[][] expected = {
                {6, 12, 18},
                {6, 12, 18},
                {6, 12, 18}
        };

        int[][] identity = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        return Stream.of(
                arguments(m, m, expected),
                arguments(m, identity, m)
        );
    }

    @ParameterizedTest
    @MethodSource("keyPairTestDataProvider")
    public void testKeyPair(int row, int col, int hashCode) {
        Matrix.KeyPair keyPair = new Matrix.KeyPair(row, col);
        assertThat(keyPair.getRow()).isEqualTo(row);
        assertThat(keyPair.getCol()).isEqualTo(col);
        assertThat(keyPair.hashCode()).isEqualTo(hashCode);
    }

    private static Stream<Arguments> keyPairTestDataProvider() {
        return Stream.of(
                arguments(1, 1, 11),
                arguments(5, 8, 58),
                arguments(11, 22, 1122)
        );
    }

    @ParameterizedTest
    @MethodSource("matrixConverterDataProvider")
    public void testConvert(int[][] m, Map<Integer, Map<Integer, Integer>> expected) {
        Map<Integer, Map<Integer, Integer>> result = Matrix.convert(m);
        printMatrix(result);
        assertThat(result).isEqualTo(expected);
    }

    private void printMatrix(Map<Integer, Map<Integer, Integer>> m) {
        for (Map<Integer, Integer> row : m.values()) {
            for (int value : row.values()) {
                System.out.print(value);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    private static Stream<Arguments> matrixConverterDataProvider() {
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Map<Integer, Map<Integer, Integer>> map = Map.of(
                0, Map.of(0, 1, 1, 2, 2, 3),
                1, Map.of(0, 4, 1, 5, 2, 6),
                2, Map.of(0, 7, 1, 8, 2, 9)
        );
        int[][] m2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        Map<Integer, Map<Integer, Integer>> map2 = Map.of(
                0, Map.of(0, 1),
                1, Map.of(1, 1),
                2, Map.of(2, 1)
        );

        return Stream.of(
                arguments(m, map),
                arguments(m2, map2)
        );
    }

    @ParameterizedTest
    @MethodSource("matrixInversionDataProvider")
    public void testMatrixArrayInversion(int[][] m, int[][] inverted) {
        int[][] result = Matrix.invert(m);
        assertThat(result).isEqualTo(inverted);
        System.out.println(Arrays.deepToString(result));
    }

    @ParameterizedTest
    @MethodSource("matrixInversionDataProvider")
    public void testMatrixMapInversion(int[][] m, int[][] inverted) {
        Map<Integer, Map<Integer, Integer>> originalMatrix = Matrix.convert(m);
        Map<Integer, Map<Integer, Integer>> result = Matrix.invert(originalMatrix);
        assertThat(result).isEqualTo(Matrix.convert(inverted));
    }


    private static Stream<Arguments> matrixInversionDataProvider() {
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] inverted = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        int[][] identity = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        return Stream.of(
                arguments(m, inverted),
                arguments(identity, identity)
        );
    }
}
