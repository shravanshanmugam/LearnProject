package com.shravan.learn.problems.easy.array;

import com.shravan.learn.common.ArrayUtil;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int zero_pointer = 0;
        int non_zero_pointer = 1;
        while (zero_pointer < nums.length && non_zero_pointer < nums.length) {
            // if zero pointer is 0 and non-zero pointer is non zero then swap
            if (nums[zero_pointer] == 0) {
                if (nums[non_zero_pointer] != 0) {
                    ArrayUtil.swap(nums, zero_pointer, non_zero_pointer);
                    zero_pointer++;
                }
            } else {
                // if zero pointer is not zero, then move to next number
                zero_pointer++;
            }
            non_zero_pointer++;
        }
    }
}
