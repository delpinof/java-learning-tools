package com.fherdelpino.collections.sort;

public class CollectionUtils<T> {

    public void swap(T[] arr, int posX, int posY) {
        T tmp = arr[posX];
        arr[posX] = arr[posY];
        arr[posY] = tmp;
    }
}
