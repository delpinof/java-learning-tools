package com.fherdelpino.datastructures.collections;

public class Queue {

    class Node {
        int value;
        Node next;

        public Node(int n) {
            this.value = n;
        }
    }

    Node head;
    Node tail;

    public void enqueue(int n) {
        Node tmp = new Node(n);
        if (head == null) {
            head = tmp;
            tail = head;
        } else {
            tail.next = tmp;
            tail = tmp;
        }
    }

    public int dequeue() {
        int tmp = head.value;
        head = head.next;
        return tmp;
    }

    public int peek() {
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
