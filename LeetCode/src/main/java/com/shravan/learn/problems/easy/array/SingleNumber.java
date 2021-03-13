package com.shravan.learn.problems.easy.array;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        int singleNumber = solution.singleNumber(new int[]{
                1, 1, 2, 3, 3, 2, 9
        });
        System.out.println("singleNumber = " + singleNumber);
    }

    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
//          x ^ 0 = x, x ^ x = 0
            x ^= num;
        }
        return x;
    }
}
