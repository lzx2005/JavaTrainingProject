package com.lzx2005.training.algorithms4.demo_1_3_2;

/**
 * 测试类
 * Created by hzlizx on 2018/3/15 0015
 */
public class TestClass {
    public static void main(String[] args) {
        testFixedCapacityStackOfStrings();
        testFixedCapacityStack();
    }

    private static void testFixedCapacityStackOfStrings(){
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

    private static void testFixedCapacityStack(){
        FixedCapacityStack<Integer> fixedCapacityStackOfStrings = new FixedCapacityStack<>(5);
        fixedCapacityStackOfStrings.push(1);
        fixedCapacityStackOfStrings.push(2);
        fixedCapacityStackOfStrings.push(3);
        fixedCapacityStackOfStrings.push(4);
        System.out.println(fixedCapacityStackOfStrings.size());
        System.out.println(fixedCapacityStackOfStrings.pop());
        System.out.println(fixedCapacityStackOfStrings.pop());
        System.out.println(fixedCapacityStackOfStrings.pop());
        System.out.println(fixedCapacityStackOfStrings.pop());
    }
}
