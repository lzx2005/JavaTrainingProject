package com.lzx2005.training.algorithms4.demo_1_3_2;

/**
 * 测试类
 * Created by hzlizx on 2018/3/15 0015
 */
public class TestClass {
    public static void main(String[] args) {
        //testFixedCapacityStackOfStrings();
        //testFixedCapacityStack();
        testVariableCapacityStack();
    }

    private static void testFixedCapacityStackOfStrings() {
        FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(5);
        fixedCapacityStackOfStrings.push("a");
        fixedCapacityStackOfStrings.push("b");
        fixedCapacityStackOfStrings.push("c");
        fixedCapacityStackOfStrings.push("d");
        System.out.println(fixedCapacityStackOfStrings.size());
        System.out.println(fixedCapacityStackOfStrings.pop());
        System.out.println(fixedCapacityStackOfStrings.pop());
        System.out.println(fixedCapacityStackOfStrings.pop());
        System.out.println(fixedCapacityStackOfStrings.pop());
    }

    private static void testFixedCapacityStack() {
        FixedCapacityStack<Integer> fixedCapacityStack = new FixedCapacityStack<>(5);
        fixedCapacityStack.push(1);
        fixedCapacityStack.push(2);
        fixedCapacityStack.push(3);
        fixedCapacityStack.push(4);
        System.out.println(fixedCapacityStack.size());
        System.out.println(fixedCapacityStack.pop());
        System.out.println(fixedCapacityStack.pop());
        System.out.println(fixedCapacityStack.pop());
        System.out.println(fixedCapacityStack.pop());
    }

    private static void testVariableCapacityStack() {
        VariableCapacityStack<Integer> variableCapacityStack = new VariableCapacityStack<>(5);
        variableCapacityStack.push(1);
        variableCapacityStack.push(2);
        variableCapacityStack.push(3);
        variableCapacityStack.push(4);
        variableCapacityStack.push(5);
        variableCapacityStack.push(6);
        variableCapacityStack.push(7);
        variableCapacityStack.push(8);
        variableCapacityStack.push(9);
        variableCapacityStack.push(10);
        System.out.println(variableCapacityStack.size());
        System.out.println(variableCapacityStack.pop());
        System.out.println(variableCapacityStack.pop());
        System.out.println(variableCapacityStack.pop());
        System.out.println(variableCapacityStack.pop());
        System.out.println(variableCapacityStack.pop());
        System.out.println(variableCapacityStack.pop());
        System.out.println(variableCapacityStack.pop());
        System.out.println(variableCapacityStack.pop());
        System.out.println(variableCapacityStack.pop());
        System.out.println(variableCapacityStack.pop());
        System.out.println(variableCapacityStack.pop());
        System.out.println(variableCapacityStack.pop());
        variableCapacityStack.push(1);
        variableCapacityStack.push(2);
        variableCapacityStack.push(3);
        variableCapacityStack.push(4);
        variableCapacityStack.push(5);
        variableCapacityStack.push(6);
        variableCapacityStack.push(7);
        variableCapacityStack.push(8);
        variableCapacityStack.push(9);
        variableCapacityStack.push(10);

        for (Integer i : variableCapacityStack) {
            System.out.println(i);
        }
    }
}
