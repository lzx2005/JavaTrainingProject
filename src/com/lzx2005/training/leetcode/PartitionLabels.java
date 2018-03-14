package com.lzx2005.training.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lizhengxian on 2018/3/13.
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";

        List<Integer> integers = new PartitionLabels().partitionLabels(S);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

}
