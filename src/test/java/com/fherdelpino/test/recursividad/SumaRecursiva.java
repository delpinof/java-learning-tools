package com.fherdelpino.test.recursividad;

import com.fherdelpino.recursividad.OperacionesRecursivas;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SumaRecursiva {

    OperacionesRecursivas operacionesRecursivas;

    @Before
    public void setUp() {
        operacionesRecursivas = new OperacionesRecursivas();
    }

    @Test
    public void sumaRecursivaTest() {
        LinkedList<Integer> numeros = new LinkedList<>(Arrays.asList(4, 3, 4, 5, 6, 4, 8));
        int resultado = operacionesRecursivas.suma(numeros);
        assertEquals(34, resultado);
    }

    @Test
    public void sumaStream() {
        List<Integer> numeros = Arrays.asList(4, 3, 4, 5, 6, 4, 8);
        int resultado = numeros.stream().reduce(0, Integer::sum);
        assertEquals(34, resultado);
    }
}
