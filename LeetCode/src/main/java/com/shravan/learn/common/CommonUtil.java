package com.shravan.learn.common;

public class CommonUtil {
    public static int sudokuBoxNumber(int row, int column) {
        return (row / 3) * 3 + column / 3;
    }
}
