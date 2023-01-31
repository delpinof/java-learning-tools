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

    public static int factorial(int n) {
        return n <= 1 ? n : n * factorial(n - 1);
    }

    public static int combinatorics(int total, int sample) {
        int total_f = factorial(total);
        int sample_f = factorial(sample);
        int dividend_f = factorial(total-sample);

        return total_f / (sample_f * dividend_f);
    }
}
