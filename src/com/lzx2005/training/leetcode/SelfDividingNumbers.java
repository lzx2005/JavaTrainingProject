package com.lzx2005.training.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lizhengxian on 2018/2/27.
 */
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isDividingNumbers(i)) {
                integers.add(i);
            }
        }
        return integers;
    }

    public boolean isDividingNumbers(int number) {
        for (int i = 0; i < String.valueOf(number).length(); i++) {
            int e = (number / (int) Math.pow(10, i)) % 10;
            if (e == 0 || (number % e) != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean dividingNumbers = new SelfDividingNumbers().isDividingNumbers(10);
        System.out.println(dividingNumbers);
    }
}
