package com.fherdelpino.datastructures.collections;

public class Stack {

    class Node {
        int value;
        Node next;

        public Node(int n) {
            this.value = n;
        }
    }

    Node head;

    public int pop() {
        if (head == null)
            throw new RuntimeException("Can't pop, stack is empty");
        int v = head.value;
        head = head.next;
        return v;
    }

    public void push(int n) {
        if (head == null) {
            head = new Node(n);
        } else {
            Node tmpNode = new Node(n);
            tmpNode.next = head;
            head = tmpNode;
        }
    }

    public int peek() {
        if (head == null)
            throw new RuntimeException("Can't peek, stack is empty");
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
