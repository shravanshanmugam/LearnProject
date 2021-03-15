package com.shravan.learn.problems.medium.others;

import java.util.Arrays;

public class MajorityElement {
    // Alternative solutions
    // 1. Store frequency in HashMap and return element with largest frequency or frequency >= n/2
    // 2. Boyer-Moore Voting algorithm
    // [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
    // +1 for selected element, -1 for every other element
    /*public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }*/

    // an element that appears atleast half of the time i.e. frequency >= n/2
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
