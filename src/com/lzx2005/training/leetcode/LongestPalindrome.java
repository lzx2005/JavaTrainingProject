package com.lzx2005.training.leetcode;

import java.util.Date;

/**
 * Created by Lizhengxian on 2017/4/2.
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String max = "";
        char[] chars = s.toCharArray();

        for(int i=0;i<s.length();i++){
            for(int j=s.length()-1;j>=i;j--){
                if(j-i<maxLen){
                    break;
                }
                if(chars[i]==chars[j]&&isPalindromic(chars,i,j)){
                    if((j-i)>=maxLen){
                        maxLen = j-i;
                        max = new String(chars,i,maxLen+1);
                        break;
                    }
                }
            }
        }
        return max;
    }

    public boolean isPalindromic(char[] chars,int start,int end){

        while(start<end){
            if(chars[start]!=chars[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        char[] chars = "".toCharArray();


        boolean palindromic = new LongestPalindrome().isPalindromic(chars,0,chars.length-1);
        System.out.println(palindromic);

        Long start = new Date().getTime();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s1 = new LongestPalindrome().longestPalindrome(s);
        System.out.println(s1);

        Long end = new Date().getTime();
        System.out.println((end-start)+"ms");
    }

}
