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
}
