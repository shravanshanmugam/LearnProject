package com.shravan.learn.problems.medium.backtracking;

import com.shravan.learn.common.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
        System.out.println("permute = " + permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, nums.length - 1, result);
        return result;
    }

    // alternative solution 2 - using HashSet
    /*public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new HashSet<>(), new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, Set<Integer> set, List<Integer> row, List<List<Integer>> result) {
        if (row.size() == nums.length) {
            result.add(new ArrayList<>(row));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num)) {
                row.add(num);
                set.add(num);
                backtrack(nums, set, row, result);
                set.remove(num);
                row.removeIf(e -> e == num);
            }
        }
    }*/


    // alternative solution 1
    /*public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> row, List<List<Integer>> result) {
        if (nums.length == 0) {
            // create a new array list since list is pass by reference
            result.add(new ArrayList<>(row));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int[] copy = ArrayUtil.remove(nums, i);
            row.add(num);
            backtrack(copy, row, result);
            row.removeIf(e -> e == num);
        }
    }*/

    private void backtrack(int[] nums, int start, int length, List<List<Integer>> result) {
        if (start == length) {
            List<Integer> row = ArrayUtil.toList(nums);
            result.add(row);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // swap start index and current index, add to list
            ArrayUtil.swap(nums, start, i);
            // update start index and recurse
            backtrack(nums, start + 1, length, result);
            // revert swap
            ArrayUtil.swap(nums, start, i);
        }
    }
}
