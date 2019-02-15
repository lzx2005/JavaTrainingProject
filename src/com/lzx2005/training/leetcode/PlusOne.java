package com.lzx2005.training.leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        return plusOne(digits, digits.length - 1);
    }

    private int[] plusOne(int[] digits, int index) {
        if (index == -1) {
            int[] ints = new int[digits.length + 1];
            System.arraycopy(digits, 0, ints, 1, digits.length);
            ints[0] = 1;
            return ints;
        }
        if (digits[index] == 9) {
            digits[index] = 0;
            return plusOne(digits, index - 1);
        } else {
            digits[index]++;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] s = {9, 9};
        int[] ints = new PlusOne().plusOne(s);
        for (int i : ints) {
            System.out.print(i);
        }
    }
}
