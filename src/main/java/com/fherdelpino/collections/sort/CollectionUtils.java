package com.fherdelpino.collections.sort;

public class CollectionUtils {

    public static void swap(int[] arr, int posX, int posY) {
        int tmp = arr[posX];
        arr[posX] = arr[posY];
        arr[posY] = tmp;
    }
}
