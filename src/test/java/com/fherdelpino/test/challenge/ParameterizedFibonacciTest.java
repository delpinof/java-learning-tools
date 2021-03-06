package com.fherdelpino.test.challenge;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.fherdelpino.challenge.Fibonacci;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedFibonacciTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1,0}, {2,1}, {3,1}, {4,2}, {5,3}, {6,5}, {7,8}, {8,13}
        });
    }

    private int fInput;

    private int fExpected;

    public ParameterizedFibonacciTest(int input, int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }

    @Test
    public void testCompute() {
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }

    @Test
    public void testComputeWithMemo() {
        assertEquals(fExpected, Fibonacci.computeWithMemo(fInput));
    }
}
