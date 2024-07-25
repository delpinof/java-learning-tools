package com.fherdelpino.datastructures.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class PriorityQueueTest {

    @Test
    public void testPriorityQueue() {
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        q.addAll(List.of(9, 7, 2, 5, 6, 1, 4, 5));
        int last = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int current = q.poll();
            log.info("{}", current);
            assertThat(last).isGreaterThanOrEqualTo(current);
            last = current;

        }
    }

    @Test
    public void testKLargest() {
        List<Integer> elements = List.of(9, 7, 2, 5, 6, 1, 4, 5);
        int k = 3;
        Queue<Integer> q = new PriorityQueue<>();
        for (int n : elements) {
            q.add(n);
            if (q.size() > k) {
                q.poll();
            }
        }
        assertThat(q.size()).isEqualTo(k);
        assertThat(q.poll()).isEqualTo(6);
        assertThat(q.poll()).isEqualTo(7);
        assertThat(q.poll()).isEqualTo(9);
    }

}
