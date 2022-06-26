package com.fherdelpino.test.recursividad;

import com.fherdelpino.recursion.MathRecursion;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MathRecursionTest {

    MathRecursion sut;

    @Before
    public void setUp() {
        sut = new MathRecursion();
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
        var result = MathRecursion.product(5, 7);
        assertEquals(35, result);
    }

    @Test
    public void testFactorial() {
        var result = MathRecursion.factorial(5);
        assertEquals(120, result);
    }
}
