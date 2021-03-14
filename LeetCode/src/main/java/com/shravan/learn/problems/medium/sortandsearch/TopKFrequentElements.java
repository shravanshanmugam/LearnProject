package com.shravan.learn.problems.medium.sortandsearch;

import com.shravan.learn.common.ArrayUtil;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] topKFrequent = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println("topKFrequent = " + Arrays.toString(topKFrequent));
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) return nums;
        Map<Integer, Integer> frequency = ArrayUtil.frequency(nums);
        Queue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(frequency::get));

        // insert in increasing order
        for (Integer num : frequency.keySet()) {
            q.add(num);
            // remove small elements and keep top k elements
            if (q.size() > k) {
                q.poll();
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!q.isEmpty()) {
            result[i++] = q.poll();
        }
        return result;
    }
}
