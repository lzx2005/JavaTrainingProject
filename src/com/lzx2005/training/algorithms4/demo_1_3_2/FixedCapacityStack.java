package com.lzx2005.training.algorithms4.demo_1_3_2;

/**
 * 定长可变类型栈
 * Created by hzlizx on 2018/3/15 0015
 */
public class FixedCapacityStack<T> implements CustomStack<T> {

    private T[] values;
    private int N;

    /**
     * 初始化参数
     * @param capacicy  定义长度
     */
    public FixedCapacityStack(int capacicy) {
        values = (T[])new Object[capacicy];
    }

    /**
     * 返回当前长度
     * @return  长度
     */
    @Override
    public int size(){
        return N;
    }

    /**
     * 入栈
     * @param value
     */
    @Override
    public void push(T value){
        values[N++] = value;
    }

    /**
     * 出栈
     * @return  被弹出的值
     */
    @Override
    public T pop(){
        return values[--N];
    }
}
