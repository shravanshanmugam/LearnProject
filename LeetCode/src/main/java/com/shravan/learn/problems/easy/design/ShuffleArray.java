package com.shravan.learn.problems.easy.design;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ShuffleArray {
    private int[] original;
    private int[] shuffle;

    public ShuffleArray(int[] nums) {
        original = nums;
        // create copy of original array
        shuffle = Arrays.copyOf(original, original.length);
    }

    private static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        ShuffleArray solution = new ShuffleArray(new int[]{1, 2, 3});
        int[] shuffle = solution.shuffle();
        System.out.println("shuffle = " + Arrays.toString(shuffle));
        int[] reset = solution.reset();
        System.out.println("reset = " + Arrays.toString(reset));
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        // Fisher-Yates Algorithm - pick current index and random index starting from current index and swap them
        for (int i = 0; i < shuffle.length; i++) {
            swap(shuffle, i, random(i, shuffle.length - 1));
        }
        return shuffle;
    }
}
