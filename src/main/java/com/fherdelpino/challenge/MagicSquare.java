package com.fherdelpino.challenge;

public class MagicSquare {
    public int[][] build(int size) {
        int[][] matrix = new int[size][size];
        int rowIndex = 0;
        int colIndex = 0;
        for (int n = 1; n <= size * size; n++) {
            matrix[rowIndex][colIndex] = n;
            int[] newPosition = getNextPosition(rowIndex, colIndex, matrix);
            rowIndex = newPosition[0];
            colIndex = newPosition[1];
        }
        return matrix;
    }

    public int[] getNextPosition(int row, int col, int[][] m) {
        int newRow = row;
        int newCol = col;
        newRow++;
        newCol--;
        if (newRow >= m.length) {
            newRow = 0;
        }
        if (newCol < 0) {
            newCol = m.length - 1;
        }
        if (m[newRow][newCol] != 0) {
            newRow = row;
            newCol--;
            if (newCol < 0) {
                newCol = m.length - 1;
            }
        }
        return new int[]{newRow, newCol};
    }
}
