package com.lzx2005.training.leetcode;

import java.util.HashSet;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String shortestString = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (shortestString.length() > strs[i].length()) {
                shortestString = strs[i];
            }
        }
        StringBuilder sb = new StringBuilder(shortestString.length());
        for (int i = 0; i < shortestString.length(); i++) {
            HashSet<Character> characters = new HashSet<>();
            Character character = null;
            for (int j = 0; j < strs.length; j++) {
                character = strs[j].charAt(i);
                characters.add(character);
            }
            if (characters.size() > 1) {
                break;
            }
            if (null != character) {
                sb.append(character);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"cog","cacecar","car","c"};
        String s = new LongestCommonPrefix().longestCommonPrefix(strings);
        System.out.println(s);

    }
}
