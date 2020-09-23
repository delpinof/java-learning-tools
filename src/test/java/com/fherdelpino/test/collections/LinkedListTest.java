package com.fherdelpino.test.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class LinkedListTest {

    @Test
    public void testQueue() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        while (!queue.isEmpty()) {
            log.info("result={}", queue.poll());
        }
    }

    @Test
    public void testMyLinkedList_append() {
        com.fherdelpino.collections.LinkedList linkedList = new com.fherdelpino.collections.LinkedList();
        for (int i = 5; i > 0; i--) {
            linkedList.append(i);
        }

        linkedList.printList();
    }

    @Test
    public void testMyLinkedList_prepend() {
        com.fherdelpino.collections.LinkedList linkedList = new com.fherdelpino.collections.LinkedList();
        for (int i = 5; i > 0; i--) {
            linkedList.prepend(i);
        }

        linkedList.printList();
    }

    @Test
    public void testMyLinkedList_removeByValue() {
        com.fherdelpino.collections.LinkedList linkedList = new com.fherdelpino.collections.LinkedList();
        for (int i = 5; i > 0; i--) {
            linkedList.prepend(i);
        }

        linkedList.removeByValue(5);
        linkedList.printList();
    }

    @Test
    public void testMyLinkedList_removeFront() {
        com.fherdelpino.collections.LinkedList linkedList = new com.fherdelpino.collections.LinkedList();
        for (int i = 5; i > 0; i--) {
            linkedList.prepend(i);
        }
        linkedList.printList();
        log.info("getFront={}", linkedList.getFront());
        linkedList.printList();
        log.info("getFront={}", linkedList.getFront());
        linkedList.printList();
        log.info("getFront={}", linkedList.getFront());
        linkedList.printList();
    }

    @Test
    public void testMyLinkedList_removeLast() {
        com.fherdelpino.collections.LinkedList linkedList = new com.fherdelpino.collections.LinkedList();
        for (int i = 5; i > 0; i--) {
            linkedList.prepend(i);
        }
        linkedList.printList();
        log.info("getFront={}", linkedList.getLast());
        linkedList.printList();
        log.info("getFront={}", linkedList.getLast());
        linkedList.printList();
        log.info("getFront={}", linkedList.getLast());
        linkedList.printList();
    }
}
