package com.lzx2005.training.nowcoder;

/**
 * 归并排序
 * O(n*log(n))
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 1, 4, 3, 7, 6, 10};
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int p = 0;
        //外排
        while (p1 <= mid && p2 <= R) {
            if (arr[p1] <= arr[p2]) {
                temp[p] = arr[p1];
                p1++;
            } else {
                temp[p] = arr[p2];
                p2++;
            }
            p++;
        }
        //把剩下的数组拷贝进辅助数组
        while (p1 <= mid) {
            temp[p] = arr[p1];
            p1++;
            p++;
        }
        while (p2 <= R) {
            temp[p] = arr[p2];
            p2++;
            p++;
        }
        //将辅助数组写入原数组
        for (int i = L, ip = 0; i <= R; i++, ip++) {
            arr[i] = temp[ip];
        }
    }


    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
