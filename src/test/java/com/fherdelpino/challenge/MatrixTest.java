package com.fherdelpino.challenge;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class MatrixTest {

    @ParameterizedTest
    @MethodSource("matrixProductDataProvider")
    public void testMatrixCrossProduct(int[][] m, int[][] n, int[][] expected) {

        int[][] result = Matrix.crossProduct(m, n);

        assertThat(result).isEqualTo(expected);
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
        return Stream.of(
                Arguments.of(m, m, expected)
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
                Arguments.of(1, 1, 11),
                Arguments.of(5, 8, 58),
                Arguments.of(11, 22, 1122)
        );
    }

    @ParameterizedTest
    @MethodSource("matrixConverterDataProvider")
    public void testConvert(int[][] m, Map<Integer, Map<Integer, Integer>> expected) {
        Map<Integer, Map<Integer, Integer>> result = Matrix.convert(m);
        assertThat(result).isEqualTo(expected);
        for (Map<Integer, Integer> row : result.values()) {
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
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        map.put(0, new HashMap<>());
        map.put(1, new HashMap<>());
        map.put(2, new HashMap<>());
        map.get(0).put(0, 1);
        map.get(0).put(1, 2);
        map.get(0).put(2, 3);
        map.get(1).put(0, 4);
        map.get(1).put(1, 5);
        map.get(1).put(2, 6);
        map.get(2).put(0, 7);
        map.get(2).put(1, 8);
        map.get(2).put(2, 9);
        return Stream.of(
                Arguments.of(m, map)
        );
    }
}
