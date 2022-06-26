package com.fherdelpino.recursion;

import java.util.LinkedList;

public class MathRecursion {

    private int total;

    public int sum(LinkedList<Integer> elements) {
        Integer n = elements.poll();
        if (n == null)
            return total;
        total += n;
        return sum(elements);
    }

    public static int product(int a, int b) {
        if (b == 1) {
            return a;
        } else {
            return a + product(a, b - 1);
        }
    }

    public static int factorial(int n) {
        return n == 1 ? 1 : n * factorial(n - 1);
    }
}
