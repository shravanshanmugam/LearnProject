package com.shravan.learn.problems.medium.sortandsearch;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    // only 3 digits - 0, 1 and 2 are present in the array
    public void sortColors(int[] nums) {
        int zero_count = 0;
        int one_count = 0;
        for (int num : nums) {
            if (num == 0) zero_count++;
            else if (num == 1) one_count++;
        }

        int i = 0;
        while (i < nums.length) {
            if (i < zero_count) {
                nums[i] = 0;
            } else if (i < zero_count + one_count) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
            i++;
        }
    }
}
