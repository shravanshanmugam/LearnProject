package com.shravan.learn.problems.medium.sortandsearch;

public class SearchA2DMatrix {

    // matrix is sorted in increasing order from left to right and top to bottom
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        // start from end of first row
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                // if element is lower, search left in row
                j--;
            } else {
                // if element is high, search down in column
                i++;
            }
        }
        return false;
    }

    // Alternative solution - divide and conquer
    /*public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        return search(matrix, target, 0, rows, 0, columns);
    }

    private boolean search(int[][] matrix, int target, int startRow, int rows, int startColumn, int columns) {
        if (startRow < 0) return false;
        if (startColumn >= columns) return false;
        int mid = (startColumn + columns) / 2;
        for (int i = startRow; i < rows; i++) {
            int e = matrix[i][mid];
            if (e == target) {
                return true;
            }
            if (e > target) {
                // search bottom left and top right
                return search(matrix, target, i, rows, 0, mid) || search(matrix, target, 0, i, mid + 1, columns);
            }
        }
        // search right side of matrix
        return search(matrix, target, 0, rows, mid + 1, columns);
    }*/
}
