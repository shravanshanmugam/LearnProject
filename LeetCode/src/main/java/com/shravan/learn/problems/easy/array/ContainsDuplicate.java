package com.shravan.learn.problems.easy.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        boolean containsDuplicate = solution.containsDuplicate(new int[]{
                1, 2, 3, 1
        });
        System.out.println("containsDuplicate = " + containsDuplicate);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // if set already contains a number, add method will return false
            boolean add = set.add(num);
            if (!add) return true;
        }
        return false;
    }
}
