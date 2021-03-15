package com.shravan.learn.problems.medium.math;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int columnNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            columnNumber = columnNumber * 26 + ((int) (s.charAt(i)) - 64);
        }
        return columnNumber;
    }
}
