package com.lzx2005.training.leetcode;

public class ImplementStrstr {

    public int strStr(String haystack, String needle) {
        if (haystack == null) return 0;
        if (needle == null) return 0;
        if (needle.equals("")) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            boolean find = true;
            for (int j = 0; j < needle.length(); j++) {
                if (i + j >= haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    find = false;
                    break;
                }
            }
            if (find) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issipi";
        int i = new ImplementStrstr().strStr(haystack, needle);
        System.out.println(i);
    }
}
