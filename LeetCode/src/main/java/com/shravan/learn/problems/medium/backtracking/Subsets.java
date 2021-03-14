package com.shravan.learn.problems.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private List<List<Integer>> result = new ArrayList<>();
    private int k;

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3, 4});
        System.out.println("subsets = " + subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        // create combinations for each size from 0 to nums.length
        for (k = 0; k <= nums.length; k++) {
            backtrack(nums, 0, new ArrayList<>());
        }
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> row) {
        // if size is reached, add to result list
        if (row.size() == k) {
            // create a new array list since list is pass by reference
            result.add(new ArrayList<>(row));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            row.add(nums[i]);
            backtrack(nums, i + 1, row);
            row.remove(row.size() - 1);
        }
    }
}
