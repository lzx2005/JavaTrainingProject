package com.lzx2005.training.leetcode;

/**
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 * Created by hzlizx on 2019/3/11
 */
public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};
        int k = 8;

        int i = new KthSmallestElementInASortedMatrix().kthSmallest(matrix, k);
        System.out.println(i);


        int[][] matrix1 = {
                {1, 2},
                {1, 3}};
        int k1 = 2;

        int i1 = new KthSmallestElementInASortedMatrix().kthSmallest(matrix1, k1);
        System.out.println(i1);

        int[][] matrix2 = {
                {1,  5,  9, 12},
                {3, 10, 11, 13},
                {6, 12, 13, 15},
                {6, 16, 18, 20}};
    }
}
