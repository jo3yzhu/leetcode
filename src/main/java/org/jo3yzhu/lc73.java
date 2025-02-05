package org.jo3yzhu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; ++i) {
                if (matrix[j][i] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        // fill rows
        for (int i : columns) {
            Arrays.fill(matrix[i], 0);
        }

        // fill columns
        for (int i : rows) {
            for (int j = 0; j < m; ++j) {
                matrix[j][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] x = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        new lc73().setZeroes(x);
    }
}
