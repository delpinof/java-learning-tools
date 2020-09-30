package com.fherdelpino.datastructures.collections;

public class Queue<T> {

    class Node<T> {
        T value;
        Node next;

        public Node(T n) {
            this.value = n;
        }
    }

    Node head;
    Node tail;

    public void enqueue(T n) {
        Node<T> tmp = new Node<>(n);
        if (head == null) {
            head = tmp;
            tail = head;
        } else {
            tail.next = tmp;
            tail = tmp;
        }
    }

    public T dequeue() {
        T tmp = (T) head.value;
        head = head.next;
        return tmp;
    }

    public T peek() {
        return (T) head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
