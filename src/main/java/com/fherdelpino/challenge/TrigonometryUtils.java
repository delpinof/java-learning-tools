package com.fherdelpino.challenge;

public class TrigonometryUtils {

    public static double distance(int x1, int y1, int x2, int y2) {
        double xDiffSq = Math.pow(x2 - x1, 2);
        double yDiffSq = Math.pow(y2 - y1, 2);
        return Math.sqrt(xDiffSq + yDiffSq);
    }

    public static double getTriangleArea(int[] x, int[] y) {
        double a = distance(x[0], y[0], x[1], y[1]);
        double b = distance(x[1], y[1], x[2], y[2]);
        double c = distance(x[2], y[2], x[0], y[0]);
        //sum them together, then multiply by another three sums, but each time one of the sides is subtracted.
        double tmp = (a + b + c)
                * (-a + b + c)
                * (a - b + c)
                * (a + b - c);
        return Math.sqrt(tmp) / 4;
    }
}
