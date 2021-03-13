package com.shravan.learn.problems.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] indices = solution.twoSum(new int[]{
                2, 7, 11, 15
        }, 9);
        System.out.println("indices = " + Arrays.toString(indices));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int required = target - num;
            // check if complement is present in the sum such that the sum of the two numbers equals target
            Integer requiredIndex = map.get(required);
            if (requiredIndex != null) {
                return new int[]{i, requiredIndex};
            }
            // put number and corresponding index in the map
            map.put(num, i);
        }
        return null;
    }
}
