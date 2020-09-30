package com.fherdelpino.test.collections;

import com.fherdelpino.datastructures.collections.Stack;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class StackTest {

    @Test
    public void testPush() {
        Stack stack = new Stack();
        for (int i = 1; i<=5; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            log.info("data={}", stack.peek());
        }
    }
}
