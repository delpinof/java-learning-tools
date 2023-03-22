package com.fherdelpino.datastructures.collections;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class DoubleLinkedList {

    private Node head;
    private Node tail;

    public void insertWord(String s) {
        head = new Node("");
        Node pointer = head;
        for (String letter : s.split("")) {
            pointer.next = new Node(letter);
            pointer.next.prev = pointer;
            pointer = pointer.next;
            tail = pointer;
        }
    }

    public String getValues() {
        StringBuilder sb = new StringBuilder();
        Node pointer = head;
        while (pointer != null) {
            sb.append(pointer.value);
            pointer = pointer.next;
        }
        return sb.toString();
    }

    public String getValuesReversed() {
        StringBuilder sb = new StringBuilder();
        Node pointer = tail;
        while (pointer != null) {
            sb.append(pointer.value);
            pointer = pointer.prev;
        }
        return sb.toString();
    }

    /**
     * Removes the string s and concatenates the two remaining substrings,
     * if the concatenated result string happens to have the same string s, it will remove it again.
     */
    public String remove(String s) {
        String[] letters = s.split("");
        var pointer = head;
        while (nonNull(pointer)) {
            if (check(pointer.next, letters)) {
                for (int i = 0; i < letters.length; i++) {
                    pointer.next = pointer.next.next;
                }
                pointer = pointer.prev;
            } else {
                pointer = pointer.next;
            }
        }
        return getValues();
    }

    private boolean check(Node node, String[] letters) {
        if (isNull(node)) {
            return false;
        }
        for (var letter : letters) {
            if (!letter.equals(node.value)) {
                return false;
            }
            node = node.next;
        }
        return true;
    }


    @RequiredArgsConstructor
    static class Node {
        @NonNull
        String value;
        Node next;
        Node prev;
    }
}
