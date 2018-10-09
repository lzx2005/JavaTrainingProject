package com.lzx2005.training.nowcoder;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 912931, 2, 5, 1, 4, 3, 7, 6, 4, 10};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        //优化点：随机快排
        int less = L - 1;
        int more = R;
        int p = L;

        //交换
        while (p < more) {
            if (arr[p] < arr[R]) {
                swap(arr, ++less, p++);
            } else if (arr[p] > arr[R]) {
                swap(arr, --more, p);
            } else {
                p++;
            }
        }

        //替换最后一位数字跟more+1
        swap(arr, p, R);
        quickSort(arr, 0, less);
        quickSort(arr, more + 1, R);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
