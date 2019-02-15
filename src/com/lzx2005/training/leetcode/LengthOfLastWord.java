package com.lzx2005.training.leetcode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean trim = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(trim && s.charAt(i) != ' '){
                trim = false;
            }
            if(!trim && s.charAt(i) == ' '){
                return s.length() - 1 - i;
            }
        }
        if(trim){
            return 0;
        }else{
            return s.length();
        }
    }

    public static void main(String[] args) {
        int a = new LengthOfLastWord().lengthOfLastWord("a ");
        System.out.println(a);
    }
}
