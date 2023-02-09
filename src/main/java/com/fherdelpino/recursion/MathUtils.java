package com.fherdelpino.recursion;

import java.util.LinkedList;

public class MathUtils {

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

    public static long factorial(long n) {
        return factorial(n, n);
    }

    public static long factorial(long n, long r) {
        return r <= 1 ? n : n * factorial(n - 1, r - 1);
    }

    public static long permutationsWithRepetitions(int n, int r) {
        return (long) Math.pow(n, r);
    }

    public static long permutationsNoRepetitions(int n, int r) {
        return factorial(n, r);
    }

    public static long combinationsWithRepetitions(int n, int r) {
        return factorial(n + r - 1) / (factorial(r) * factorial(n - 1));
    }

    public static long combinationsNoRepetitions(int n, int r) {
        return permutationsNoRepetitions(n, r) / factorial(r);
    }
}
