package com.lzx2005.training.leetcode;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            if (j < i) {
                if (!String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(j)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
