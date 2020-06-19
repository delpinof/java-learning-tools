package com.fherdelpino.recursividad;

import java.util.LinkedList;

public class OperacionesRecursivas {

    private int total;

    public int suma(LinkedList<Integer> elementos) {
        Integer numero = elementos.poll();
        if (numero == null)
            return total;
        total += numero;
        return suma(elementos);
    }
}
