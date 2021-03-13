package com.shravan.learn.problems.easy.array;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int length = solution.removeDuplicates(new int[]{
                1, 1, 2
        });
        System.out.println("length = " + length);
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;// start index
        int j = 0;// index to find new element
        int count = 1;
        while (j < nums.length - 1) {
            // check if consecutive elements are equal
            if (nums[j] == nums[j + 1]) {
                j++;
            } else {
                // set new element at start
                nums[++i] = nums[++j];
                // each new element is a unique element
                count++;
            }
        }
        return count;
    }
}
