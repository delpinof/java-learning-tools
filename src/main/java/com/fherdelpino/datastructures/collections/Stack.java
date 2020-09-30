package com.fherdelpino.datastructures.collections;

public class Stack<T> {

    class Node<T> {
        T value;
        Node next;

        public Node(T n) {
            this.value = n;
        }
    }

    Node head;

    public T pop() {
        if (head == null)
            throw new RuntimeException("Can't pop, stack is empty");
        T v = (T) head.value;
        head = head.next;
        return v;
    }

    public void push(T n) {
        if (head == null) {
            head = new Node(n);
        } else {
            Node tmpNode = new Node(n);
            tmpNode.next = head;
            head = tmpNode;
        }
    }

    public T peek() {
        if (head == null)
            throw new RuntimeException("Can't peek, stack is empty");
        return (T) head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
