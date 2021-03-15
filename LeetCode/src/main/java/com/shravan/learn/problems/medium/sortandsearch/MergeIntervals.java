package com.shravan.learn.problems.medium.sortandsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    private static void swap(int[][] nums, int i, int j) {
        int[] t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        int[][] merge = solution.merge(new int[][]{
                new int[]{1, 3},
                new int[]{8, 10},
                new int[]{15, 18},
                new int[]{2, 6},
        });
        System.out.println("merge = " + Arrays.deepToString(merge));
    }

    public int[][] merge(int[][] intervals) {
        // Alternatively sort using library
        // Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        quickSort(intervals, 0, intervals.length - 1);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] prevInterval = list.get(list.size() - 1);
            int[] currInterval = intervals[i];
            if (currInterval[0] < prevInterval[1]) {
                prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
            } else {
                list.add(currInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    private void quickSort(int[][] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    private int partition(int[][] nums, int left, int right, int pivotIndex) {
        swap(nums, right, pivotIndex);
        int storeIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i][0] < nums[pivotIndex][0]) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }
}
