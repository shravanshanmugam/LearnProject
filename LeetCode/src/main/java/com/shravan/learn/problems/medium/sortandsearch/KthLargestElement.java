package com.shravan.learn.problems.medium.sortandsearch;

import com.shravan.learn.algorithms.QuickSelect;

import java.util.Arrays;
import java.util.stream.IntStream;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        int kthLargest1 = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println("kthLargest1 = " + kthLargest1);//5
        int kthLargest2 = solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println("kthLargest2 = " + kthLargest2);//4
        int kthLargest3 = solution.findKthLargest(new int[]{2, 1}, 2);
        System.out.println("kthLargest3 = " + kthLargest3);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == k) {
            return IntStream.of(nums).min().getAsInt();
        }
        QuickSelect solution = new QuickSelect();
        int[] largestKElements = solution.largestKElements(nums, k);
        System.out.println("largestKElements = " + Arrays.toString(largestKElements));
        return largestKElements[0];
    }
}
