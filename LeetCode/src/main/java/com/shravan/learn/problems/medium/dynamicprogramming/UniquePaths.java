package com.shravan.learn.problems.medium.dynamicprogramming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int uniquePaths = solution.uniquePaths(3, 7);
        System.out.println("uniquePaths = " + uniquePaths);
    }

    private static void print(int[][] matrix) {
        System.out.println("BOARD");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("=====");
    }

    // m * n matrix
    // start from (0,0) and reach (m-1, n-1)
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        // only one way to reach from any cell in last row to end
        for (int j = n - 1; j >= 0; j--) {
            matrix[m - 1][j] = 1;
        }
        // only one way to reach from any cell in last column to end
        for (int i = m - 1; i >= 0; i--) {
            matrix[i][n - 1] = 1;
        }
        // number of ways to reach from a cell to end = number of ways from right cell + number of ways from bottom cell
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
            }
        }
        return matrix[0][0];
    }
}
