package com.fherdelpino.challenge;

public class MagicSquare {
    public int[][] build(int size) {
        int[][] matrix = new int[size][size];
        int rowIndex = 0;
        int colIndex = 1;
        for (int n = 1; n <= size * size; n++) {
            matrix[rowIndex][colIndex] = n;
            IndexPair newPosition = getNextPosition(rowIndex, colIndex, matrix);
            rowIndex = newPosition.row;
            colIndex = newPosition.col;
        }
        return matrix;
    }

    private IndexPair getNextPosition(int row, int col, int[][] m) {
        int newRow = decrease(row, m.length);
        int newCol = increase(col, m.length);
        if (m[newRow][newCol] != 0) {
            newCol = col;
            newRow = decrease(newRow, m.length);
        }
        return new IndexPair(newRow, newCol);
    }

    private int increase(int index, int size) {
        int result = index + 1;
        if (result >= size) {
            result = 0;
        }
        return result;
    }

    private int decrease(int index, int size) {
        int result = index - 1;
        if (result < 0) {
            result = size - 1;
        }
        return result;
    }

    private record IndexPair(int row, int col) {
    }

}
