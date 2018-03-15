package com.lzx2005.training.algorithms4.demo_1_3_2_1;

/**
 * 测试类
 * Created by hzlizx on 2018/3/15 0015
 */
public class TestClass {
    public static void main(String[] args) {
        FixedCapacicyStackOfStrings fixedCapacicyStackOfStrings = new FixedCapacicyStackOfStrings(5);
        fixedCapacicyStackOfStrings.push("a");
        fixedCapacicyStackOfStrings.push("b");
        fixedCapacicyStackOfStrings.push("c");
        fixedCapacicyStackOfStrings.push("d");
        System.out.println(fixedCapacicyStackOfStrings.size());
        System.out.println(fixedCapacicyStackOfStrings.pop());
        System.out.println(fixedCapacicyStackOfStrings.pop());
        System.out.println(fixedCapacicyStackOfStrings.pop());
        System.out.println(fixedCapacicyStackOfStrings.pop());
        fixedCapacicyStackOfStrings.push("a");
        fixedCapacicyStackOfStrings.push("b");
        fixedCapacicyStackOfStrings.push("c");
        fixedCapacicyStackOfStrings.push("d");
        fixedCapacicyStackOfStrings.push("e");
        fixedCapacicyStackOfStrings.push("f");
    }
}
