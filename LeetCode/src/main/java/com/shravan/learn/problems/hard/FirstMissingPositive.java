package com.shravan.learn.problems.hard;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();

        int firstMissingPositive1 = solution.firstMissingPositive(new int[]{1, 2, 0});
        System.out.println("firstMissingPositive1 = " + firstMissingPositive1);// 3

        int firstMissingPositive2 = solution.firstMissingPositive(new int[]{3, 4, -1, 1});
        System.out.println("firstMissingPositive2 = " + firstMissingPositive2);// 2

        int firstMissingPositive3 = solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12});
        System.out.println("firstMissingPositive3 = " + firstMissingPositive3);// 1
    }

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int smallestExpected = 1;
        for (int num : nums) {
            if (smallestExpected == num) {
                while (set.contains(++smallestExpected)) {
                }
            }
            set.add(num);
        }
        return smallestExpected;
    }
}
