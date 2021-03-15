package com.shravan.learn.problems.medium.sortandsearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {
    private Map<Integer, Integer> frequencyMap;
    private int[] keys;

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] topKFrequent = solution.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        System.out.println("topKFrequent = " + Arrays.toString(topKFrequent));
    }

    private static Map<Integer, Integer> frequency(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        return frequency;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) return nums;
        frequencyMap = frequency(nums);
        System.out.println("frequencyMap = " + frequencyMap);
        int n = frequencyMap.size();
        keys = new int[n];
        int i = 0;
        for (int key : frequencyMap.keySet()) {
            keys[i++] = key;
        }
        quickSelect(0, n - 1, n - k);
        System.out.println("keys = " + Arrays.toString(keys));
        return Arrays.copyOfRange(keys, n - k, n);
    }

    private void quickSelect(int left, int right, int k_smallest) {
        if (left >= right) return;
        int pivotIndex = partition(left, right, right);
        if (pivotIndex == k_smallest) {
            return;
        } else if (k_smallest < pivotIndex) {
            // go left - we need more elements
            quickSelect(left, pivotIndex - 1, k_smallest);
        } else {
            // go right - we need less elements
            quickSelect(pivotIndex + 1, right, k_smallest);
        }

    }

    // Lomuto's Partition Scheme
    // move elements less than pivotFrequency to left and greater than pivotFrequency to right
    // return index where pivot is placed
    private int partition(int left, int right, int pivotIndex) {
        int pivotFrequency = frequencyMap.get(keys[pivotIndex]);
        swap(keys, pivotIndex, right);
        int store_index = left;
        for (int i = left; i <= right; i++) {
            if (frequencyMap.get(keys[i]) < pivotFrequency) {
                swap(keys, store_index, i);
                store_index++;
            }
        }
        swap(keys, store_index, right);
        return store_index;
    }

    // alternatively, use min heap and keep only k elements
    /*public int[] topKFrequent(int[] nums, int k) {
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
    }*/
}
