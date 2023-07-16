package com.fherdelpino.datastructures.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class QueueTest {
    @Test
    public void testEnqueueAndDequeue() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            log.info("data={}", queue.dequeue());
        }
    }
}
