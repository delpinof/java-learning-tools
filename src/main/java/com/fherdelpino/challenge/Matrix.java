package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Matrix {

    private final int SIZE;

    private int[][] matrix;

    public Matrix(int size) {
        SIZE = size;
    }

    public void add(int row, int column, int value) {
        matrix[row][column] = value;
    }


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
}
