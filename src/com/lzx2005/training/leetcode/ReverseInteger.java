package com.lzx2005.training.leetcode;

public class ReverseInteger {

    public int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == 0) {
                if ("-".equals(s.charAt(i) + "")) {
                    sb.insert(0, s.charAt(i));
                    break;
                }
            }
            sb.append(s.charAt(i));
        }
        try {
            return Integer.valueOf(sb.toString());
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public static void main(String[] args) {
        int reverse = new ReverseInteger().reverse(1534236469);
        System.out.println(reverse);
    }
}
