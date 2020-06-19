package com.fherdelpino.collections;

import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {
        new ArraysTest().run();
    }

    public void run() {
        int[] intArray = new int[]{4, 8, 3, 1, 5, 9};
        printArray(intArray);
        Arrays.sort(intArray);
        printArray(intArray);
    }

    public void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i< array.length-1)
                System.out.print(",");
        }
        System.out.println("]");
    }
}
