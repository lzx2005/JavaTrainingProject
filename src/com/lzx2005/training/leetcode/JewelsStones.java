package com.lzx2005.training.leetcode;

/**
 * Created by Lizhengxian on 2018/2/24.
 */
public class JewelsStones {

    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        for(char c : S.toCharArray()) if(J.contains(String.valueOf(c))) sum++;
        return sum;
    }
}
