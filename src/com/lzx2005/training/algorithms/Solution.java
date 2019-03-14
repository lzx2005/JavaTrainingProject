package com.lzx2005.training.algorithms;

import java.util.Stack;

/**
 * Created by Lizhengxian on 2017/3/16.
 * 用两个栈实现一个队列
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        while (!stack1.empty()){
            Integer pop = stack1.pop();
            stack2.push(pop);
        }
        Integer outInteger = stack2.pop();
        while (!stack2.empty()){
            Integer pop = stack2.pop();
            stack1.push(pop);
        }
        return outInteger;
    }
}
