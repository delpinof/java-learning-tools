package com.fherdelpino.test.challenge;

import com.fherdelpino.challenge.Matrix;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MatrixTest {

    @Test
    public void testMatrixCrossProduct() {
        int[][] a = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };

        int[][] result = Matrix.crossProduct(a, a);

        int[][] expected = {
                {6, 12,18},
                {6, 12,18},
                {6, 12,18}
        };

        assertTrue(Arrays.deepEquals(expected, result));
    }
}
