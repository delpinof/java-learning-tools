package com.fherdelpino.recursion;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MathUtilsTest {

    MathUtils sut;

    @Before
    public void setUp() {
        sut = new MathUtils();
    }

    @Test
    public void sumaRecursivaTest() {
        LinkedList<Integer> numeros = new LinkedList<>(Arrays.asList(4, 3, 4, 5, 6, 4, 8));
        int resultado = sut.sum(numeros);
        assertEquals(34, resultado);
    }

    @Test
    public void sumaStream() {
        List<Integer> numeros = Arrays.asList(4, 3, 4, 5, 6, 4, 8);
        int resultado = numeros.stream().reduce(0, Integer::sum);
        assertEquals(34, resultado);
    }

    @Test
    public void testProduct() {
        var result = MathUtils.product(5, 7);
        assertEquals(35, result);
    }

    @Test
    public void testFactorial() {
        var result = MathUtils.factorial(5);
        assertEquals(120, result);
    }

    @Test
    public void testCombinatorics() {
        int result = MathUtils.combinatorics(5, 3);
        assertEquals(10, result);
    }
}