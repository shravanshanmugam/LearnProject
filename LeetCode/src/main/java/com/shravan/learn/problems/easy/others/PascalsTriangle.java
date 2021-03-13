package com.shravan.learn.problems.easy.others;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> one = List.of(1);
        result.add(one);
        if (numRows == 1) return result;
        List<Integer> two = List.of(1, 1);
        result.add(two);
        if (numRows == 2) return result;
        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(numRows);
            list.add(1);
            List<Integer> previous = result.get(result.size() - 1);
            for (int j = 0; j < previous.size() - 1; j++) {
                list.add(previous.get(j) + previous.get(j + 1));
            }
            list.add(1);
            result.add(list);
        }

        return result;
    }
}
