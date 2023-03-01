package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Matrix {


    public static int[][] crossProduct(int[][] a, int[][] b) {

        if (a[0].length != b.length) {
            throw new IllegalArgumentException("Size not correct!");
        }

        int size = b.length;

        int[][] product = new int[size][size];

        /*
        product[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0] + a[0][2] * b[2][0];
        product[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1] + a[0][2] * b[2][1];
        product[0][2] = a[0][0] * b[0][2] + a[0][1] * b[1][2] + a[0][2] * b[2][2];

        product[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0] + a[1][2] * b[2][0];
        product[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1] + a[1][2] * b[2][1];
        product[1][2] = a[1][0] * b[0][2] + a[1][1] * b[1][2] + a[1][2] * b[2][2];

        product[2][0] = a[2][0] * b[0][0] + a[2][1] * b[1][0] + a[2][2] * b[2][0];
        product[2][1] = a[2][0] * b[0][1] + a[2][1] * b[1][1] + a[2][2] * b[2][1];
        product[2][2] = a[2][0] * b[0][2] + a[2][1] * b[1][2] + a[2][2] * b[2][2];
        */

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                for (int i = 0; i < size; i++) {
                    product[row][col] += a[row][i] * b[i][col];
                }
            }
        }

        return product;
    }

    public static Map<Integer, Map<Integer, Integer>> convert(int[][] m) {
        Map<Integer, Map<Integer, Integer>> result = new HashMap<>();
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[0].length; col++) {
                if (!result.containsKey(row)) {
                    result.put(row, new HashMap<>());
                }
                result.get(row).put(col, m[row][col]);
            }
        }
        return result;
    }

    public static Map<Integer, Map<Integer, Integer>> invert(Map<Integer, Map<Integer, Integer>> m) {
        Map<Integer, Map<Integer, Integer>> result = new HashMap<>();
        //TODO
        return result;
    }

    public static Map<Integer, Map<Integer, Integer>> crossProduct(Map<Integer, Map<Integer, Integer>> a, Map<Integer, Map<Integer, Integer>> b) {
        Map<Integer, Map<Integer, Integer>> result = new HashMap<>();
        for (Integer rowIndex : a.keySet()) {
            Map<Integer, Integer> row = a.get(rowIndex);
            for (Integer colIndex : row.keySet()) {
                Integer value = row.get(colIndex);
                //TODO

            }
        }
        return result;
    }

    static class KeyPair {

        private Integer value;
        private int log = 1;

        public KeyPair(int row, int col) {
            value = col;
            while (col > 0) {
                col /= 10;
                log *= 10;
            }
            value += row * log;
        }

        public int getRow() {
            return value / log;
        }

        public int getCol() {
            return value % log;
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof KeyPair) {
                return this.value.equals(((KeyPair) obj).value);
            }
            return false;
        }
    }
}
