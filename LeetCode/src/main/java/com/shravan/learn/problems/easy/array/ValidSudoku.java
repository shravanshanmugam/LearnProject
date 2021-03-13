package com.shravan.learn.problems.easy.array;

import com.shravan.learn.common.CommonUtil;
import com.shravan.learn.common.StringUtil;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // set for each row, column and box
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] columns = new HashSet[9];
        Set<Integer>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int boxNumber = CommonUtil.sudokuBoxNumber(i, j);
                    int num = StringUtil.charToInt(c);
                    // if number already exists in row set then not valid sudoku
                    boolean rowAdd = rows[i].add(num);
                    if (!rowAdd) return false;
                    // if number already exists in column set then not valid sudoku
                    boolean columnAdd = columns[j].add(num);
                    if (!columnAdd) return false;
                    // if number already exists in box set then not valid sudoku
                    boolean boxAdd = boxes[boxNumber].add(num);
                    if (!boxAdd) return false;
                }
            }
        }
        return true;
    }
}
