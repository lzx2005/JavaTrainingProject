package com.lzx2005.training.leetcode;

/**
 * Created by hzlizx on 2019/3/11
 */
public class ConvertANumberToHexadecimal {
    private static final char[] HEX_MAP = "0123456789abcdef".toCharArray();
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (; num != 0; num >>>= 4) {
            int x = num & 0b1111;
            sb.append(HEX_MAP[x]);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = new ConvertANumberToHexadecimal().toHex(1234);
        System.out.println(s);
    }
}
