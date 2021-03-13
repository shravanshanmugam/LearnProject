package com.shravan.learn.problems.easy.array;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        IntersectionOfTwoArrays solution = new IntersectionOfTwoArrays();
        int[] intersect = solution.intersect(new int[]{
                1, 2, 2, 1
        }, new int[]{
                2, 2
        });
        System.out.println("intersect = " + Arrays.toString(intersect));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequency = new HashMap<>();
        // frequency map of number in first array
        for (int num : nums1) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            Integer f = frequency.get(num);
            // if number exists in first array
            if (f != null && f > 0) {
                // add to result
                intersection.add(num);
                // decrease frequency of number in the map
                frequency.put(num, --f);
            }
        }
        int size = intersection.size();
        int[] result = new int[size];
        for (int i = 0; i < intersection.size(); i++) {
            Integer integer = intersection.get(i);
            result[i] = integer;
        }
        return result;
    }
}
