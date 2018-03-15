package com.lzx2005.training.algorithms4.demo_1_3_2;

import java.util.Iterator;

/**
 * 可变容量的栈
 * Created by hzlizx on 2018/3/15 0015
 */
public class VariableCapacityStack<T> implements Iterable<T>,CustomStack<T> {

    private T[] values;
    private int N;

    /**
     * 初始化参数
     *
     * @param capacicy 定义长度
     */
    public VariableCapacityStack(int capacicy) {
        values = (T[]) new Object[capacicy];
    }

    /**
     * 返回当前长度
     *
     * @return 长度
     */
    @Override
    public int size() {
        return N;
    }

    /**
     * 入栈
     *
     * @param value
     */
    @Override
    public void push(T value) {
        if (N == values.length) resize(values.length * 2);
        values[N++] = value;
    }

    /**
     * 出栈
     *
     * @return 被弹出的值
     */
    @Override
    public T pop() {
        if (N == 0) return null;
        T value = values[--N];
        values[N] = null; // 避免对象游离
        if (N > 0 && N == values.length / 4) resize(values.length / 2);
        return value;
    }

    private void resize(int max) {
        T[] newValues = (T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }

    /**
     * 实现迭代方法
     * @return
     */
    @Override
    public Iterator<T> iterator() {

        final int[] i = {N};

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return i[0] > 0;
            }

            @Override
            public T next() {
                return values[--i[0]];
            }
        };
    }
}
