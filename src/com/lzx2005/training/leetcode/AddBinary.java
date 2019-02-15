package com.lzx2005.training.leetcode;

public class AddBinary {

    public String addBinary(String a, String b) {
        boolean aLonger = true;
        if (a.length() < b.length()) aLonger = false;
        int min = Math.abs(b.length() - a.length());
        StringBuilder bBuilder = new StringBuilder(b);
        StringBuilder aBuilder = new StringBuilder(a);
        for (int i = 0; i < min; i++) {
            if (aLonger) {
                bBuilder.insert(0, "0");
            } else {
                aBuilder.insert(0, "0");
            }
        }
        System.out.println(aBuilder.toString());
        System.out.println(bBuilder.toString());
        StringBuilder result = new StringBuilder(aBuilder.toString());
        String plus = plus(aBuilder.toString(), bBuilder.toString(), aBuilder.length()-1, false, result);
        if(plus.equals("1")) result.insert(0, plus);
        return result.toString();
    }

    private String plus(String a, String b, int index, boolean plusOne, StringBuilder result) {
        if (index == -1) {
            return plusOne ? "1" : "0";
        }
        char aa = a.charAt(index);
        char bb = b.charAt(index);
        if (aa == '1' && bb == '1') {
            result.replace(index, index + 1, plusOne ? "1" : "0");
            return plus(a, b, index - 1, true, result);
        } else if (aa == '0' && bb == '0') {
            result.replace(index, index + 1, plusOne ? "1" : "0");
            return plus(a, b, index - 1, false, result);
        } else {
            if (plusOne) {
                result.replace(index, index + 1, "0");
                return plus(a, b, index - 1, true, result);
            } else {
                result.replace(index, index + 1, "1");
                return plus(a, b, index - 1, false, result);
            }
        }
    }

    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String s = new AddBinary().addBinary(a, b);
        System.out.println(s);
    }

}
