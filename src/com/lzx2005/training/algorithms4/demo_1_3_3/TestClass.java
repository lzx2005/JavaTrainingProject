package com.lzx2005.training.algorithms4.demo_1_3_3;

/**
 * Created by hzlizx on 2018/3/15 0015
 */
public class TestClass {

    public static void main(String[] args) {
        testLinkedStack();
    }

    private static void testLinkedStack() {
        LinkedStack<String> stringLinkedStack = new LinkedStack<>();
        stringLinkedStack.push("a");
        stringLinkedStack.push("b");
        stringLinkedStack.push("c");
        stringLinkedStack.push("d");
        System.out.println(stringLinkedStack.pop());
        System.out.println(stringLinkedStack.pop());
        System.out.println(stringLinkedStack.pop());
        System.out.println(stringLinkedStack.pop());
        System.out.println(stringLinkedStack.pop());
        for (int i = 0; i < 11000; i++) {
            stringLinkedStack.push(i + "");
        }
        for (String value : stringLinkedStack) {
            System.out.println(value);
        }
    }

}
