package com.shravan.learn.problems.easy.array;

import com.shravan.learn.common.ArrayUtil;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        int[] nums = {
                1, 2, 3, 4, 5, 6, 7
        };
        solution.rotate(nums, 3);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }

    // 1 2 3 4 5 6 7, 3
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        // reverse entire list
        // 7 6 5 4 3 2 1
        ArrayUtil.reverse(nums, 0, nums.length - 1);
        // reverse first k numbers
        // 5 6 7 4 3 2 1
        ArrayUtil.reverse(nums, 0, k - 1);
        // reverse last n-k numbers
        // 5 6 7 1 2 3 4
        ArrayUtil.reverse(nums, k, nums.length - 1);
    }
}
