package com.lzx2005.training.algorithms4.demo_1_3_2_1;


/**
 * 定容字符串栈
 * 书第82页
 * Created by hzlizx on 2018/3/15 0015
 */

public class FixedCapacicyStackOfStrings{

    /**
     * 储存值，数组，定长
     */
    private String[] values;
    private int N;

    /**
     * 初始化参数
     * @param capacicy  定义长度
     */
    public FixedCapacicyStackOfStrings(int capacicy) {
        values = new String[capacicy];
    }

    /**
     * 返回当前长度
     * @return  长度
     */
    public int size(){
        return N;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(String value){
        values[N++] = value;
    }

    /**
     * 出栈
     * @return  被弹出的值
     */
    public String pop(){
        return values[--N];
    }
}
