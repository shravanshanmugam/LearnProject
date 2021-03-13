package com.shravan.learn.problems.easy.array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        int[] incr = solution.plusOne(new int[]{
                1, 9
        });
        System.out.println("incr = " + Arrays.toString(incr));

    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return null;
        int last = digits.length - 1;

        while (last >= 0) {
            // if last digit is 9, set it to 0
            if (digits[last] == 9) {
                digits[last] = 0;
                last--;
            } else {
                // increment otherwise
                digits[last] = digits[last] + 1;
                break;
            }
        }
        // if first digit is 0, we need to put 1 in front of the digits
        if (digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            copy(digits, result);
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public void copy(int[] src, int[] dest) {
        for (int i = 0; i < src.length; i++) {
            dest[i + 1] = src[i];
        }
    }
}
