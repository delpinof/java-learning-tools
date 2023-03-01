package com.fherdelpino.matrix;

public class LandMass {

    public static int findLandMasses(int[][] m) {
        int count = 0;
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[0].length; c++) {
                if (m[r][c] == 1) {
                    dfs(m, r, c, --count);
                }
            }
        }
        return count * -1;
    }

    public static void dfs(int[][] m, int r, int c, int count) {
        if (c < 0 || r < 0 || c >= m[0].length || r >= m.length) {
            return;
        } else if (m[r][c] <= 0) {
            return;
        }

        m[r][c] = count;

        dfs(m, r - 1, c, count);
        dfs(m, r, c + 1, count);
        dfs(m, r + 1, c, count);
        dfs(m, r, c - 1, count);
    }
}
