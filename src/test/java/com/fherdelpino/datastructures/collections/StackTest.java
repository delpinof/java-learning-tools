package com.fherdelpino.datastructures.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class StackTest {

    @Test
    public void testPushAndPop() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 5; i > 0; i--) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            log.info("data={}", stack.pop());
        }
    }
}
