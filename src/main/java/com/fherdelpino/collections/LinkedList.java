package com.fherdelpino.collections;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinkedList {

    private Node head;

    public void append(int n) {
        if (head == null) {
            head = new Node(n);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(n);
        }
    }

    public void prepend(int n) {
        Node current = new Node(n);
        if (head != null)
            current.next = head;
        head = current;
    }

    public int getFront() {
        if (head == null)
            throw new RuntimeException("The list is empty.");
        int n = head.data;
        head = head.next;
        return n;
    }

    public int getLast() {
        if (head == null)
            throw new RuntimeException("The list is empty.");
        if (head.next == null) {
            int n = head.data;
            head = null;
            return n;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int n = current.next.data;
        current.next = null;
        return n;
    }

    public boolean removeByValue(int n) {
        if (head == null)
            return false;
        if (head.data == n) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == n) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printList() {
        if (head == null)
            return;

        Node current = head;
        do {
            log.info("data={}", current.data);
            current = current.next;
        } while (current != null);
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
