package com.lzx2005.training.leetcode;

import java.util.HashMap;

public class RomanToInteger {

    private static final HashMap<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (null == s || "".equals(s)) return 0;
        int sum = 0;
        if (s.contains("IV")) {
            sum += 4;
            s = s.replace("IV", "");
        }
        if (s.contains("IX")) {
            sum += 9;
            s = s.replace("IX", "");
        }
        if (s.contains("XL")) {
            sum += 40;
            s = s.replace("XL", "");
        }
        if (s.contains("XC")) {
            sum += 90;
            s = s.replace("XC", "");
        }
        if (s.contains("CD")) {
            sum += 400;
            s = s.replace("CD", "");
        }
        if (s.contains("CM")) {
            sum += 900;
            s = s.replace("CM", "");
        }
        for (int i = 0; i < s.length(); i++) {
            Integer integer = map.get(s.charAt(i));
            if (null != integer) {
                sum += integer;
            } else {
                sum += Integer.parseInt(s.charAt(i) + "");
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int mcmxciv = new RomanToInteger().romanToInt("MCMXCIV");
        System.out.println(mcmxciv);
    }
}
