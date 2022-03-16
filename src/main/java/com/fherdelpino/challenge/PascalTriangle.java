package com.fherdelpino.challenge;

import java.util.Arrays;

public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();

        int[] line = {1};

        for (int i = 0; i<5; i++) {
            System.out.println(Arrays.toString(line));
            line = pt.buildPascalTriangle(line);
        }
    }

    public int[] buildPascalTriangle(int[] previousRow) {
        int[] newRow = new int[previousRow.length+1];
        newRow[0] = 1;
        newRow[newRow.length-1] = 1;
        for (int i = 0; i<previousRow.length-1; i++) {
            newRow[i+1] = previousRow[i] + previousRow[i+1];
        }
        return newRow;
    }

}
