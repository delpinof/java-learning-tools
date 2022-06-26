package com.fherdelpino.algorithms.sort;

public interface Sorteable {

    void sort(int[] elements);

    default void swap(int[] elements, int source, int dest) {
        elements[source] += elements[dest];
        elements[dest] = elements[source] - elements[dest];
        elements[source] -= elements[dest];
    }
}
