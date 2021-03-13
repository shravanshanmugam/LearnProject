package com.shravan.learn.problems.easy.array;

public class RotateImage {
    // rotated = transposed + reversed left to right - transpose and reflect in linear algebra
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int e = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = e;
            }
        }
    }

    public void reverse(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            reverse(row, 0, matrix.length - 1);
        }
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
