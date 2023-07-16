package com.fherdelpino.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {

    MathUtils sut;

    @BeforeEach
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
    public void testPermutationsWithRepetitions() {
        long result = MathUtils.permutationsWithRepetitions(10, 3);
        assertEquals(1000, result);
    }

    @Test
    public void testPermutationsNoRepetitions() {
        long result = MathUtils.permutationsNoRepetitions(16, 3);
        assertEquals(16 * 15 * 14, result);
    }

    @Test
    public void testCombinationsNoRepetitions() {
        long result = MathUtils.combinationsNoRepetitions(16, 3);
        assertEquals(560, result);
    }

    @Test
    public void testCombinationsWithRepetitions() {
        long result = MathUtils.combinationsWithRepetitions(5,3);
        assertEquals(35, result);
    }
}
