package com.fherdelpino.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    T data;
    List<Node<T>> adjacent = new ArrayList<>();
    public Node(T t) {
        this.data = t;
    }
}
