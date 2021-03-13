package com.shravan.learn.problems.medium.array;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();
        boolean increasingTriplet = solution.increasingTriplet(new int[]{
                2, 1, 5, 0, 4, 6
//                1, 2, 1, 3
//                1, 5, 0, 4, 1, 3
//                1, 1, 1, 1
        });
        System.out.println("increasingTriplet = " + increasingTriplet);
    }

    // i < j < k && nums[i] < nums[j] < nums[k]
    public boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < firstMin) {
                firstMin = num;
            } else if (num < secondMin && num != firstMin) {
                secondMin = num;
            } else if (num != firstMin && num != secondMin) {
                return true;
            }
        }
        return false;
    }
}
