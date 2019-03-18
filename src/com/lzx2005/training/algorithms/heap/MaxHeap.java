package com.lzx2005.training.algorithms.heap;

import com.lzx2005.training.utils.CommonUtils;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Random;

/**
 * 大根堆
 */
public class MaxHeap {

    private Integer[] data;
    private int count;
    private int capacity;

    MaxHeap(int capacity) {
        this.data = new Integer[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    public void insert(int num) {
        if (count >= capacity - 1) throw new IndexOutOfBoundsException("heap is full");
        data[++count] = num;
        shiftUp(count);
    }

    public Integer pop() {
        //弹出堆顶数字
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        Integer top = data[1];
        data[1] = data[count--];
        shiftDown();
        return top;
    }

    private void shiftUp(int index) {
        while (index > 1 && data[index] > data[index / 2]) {
            CommonUtils.swap(data, index, index / 2);
            index /= 2;
        }
    }

    private void shiftDown() {
        int index = 1;
        while (index * 2 <= count) {
            // 至少有一个孩子
            Integer biggerIndex = index * 2;
            if (index * 2 + 1 <= capacity && data[index * 2] < data[index * 2 + 1]) {
                //有两个儿子 且 右孩子比左孩子大
                biggerIndex = index * 2 + 1;
            }
            if (data[index] < data[biggerIndex]) {
                // 当前值比孩子小，交换
                CommonUtils.swap(data, index, biggerIndex);
                index = biggerIndex;
            } else {
                // 如果当前值已经孩子大了，则停止向下调整
                break;
            }
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void print() {
        for (int i : data) {
            System.out.println(i + " ");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (data != null) {
            Arrays.stream(data).forEach(i -> sb.append(i).append(","));
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        Random random = new Random();
        for (int i = 1; i < 20; i++) {
            maxHeap.insert(random.nextInt(1000));
        }
        System.out.println(maxHeap);
        StringBuilder stringBuilder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            stringBuilder.append(maxHeap.pop()).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder.toString());
    }
}
