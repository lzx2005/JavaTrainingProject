package com.lzx2005.training.suanfa;

/**
 * Created by Lizhengxian on 2017/3/26.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int[] array1 = new int[array.length];
        int[] array2 = new int[array.length];
        int osum = 0;
        int jsum = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                //偶数
                array1[osum++] = array[i];
            }else{
                //奇数
                array2[jsum++] = array[i];
            }
        }

        for(int i=0;i<osum;i++){
            array2[jsum++] = array1[i];
        }

        for(int i=0;i<array.length;i++){
            array[i] = array2[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        new ReOrderArray().reOrderArray(a);
        for(int aa : a){
            System.out.println(aa);
        }
    }
}
