package com.lzx2005.training.spring.aop.jdk;

/**
 * Created by hzlizx on 2019/4/3
 */
public class AopTest {

    public static void main(String[] args) {
        Fruit fruit = (Fruit) DynamicAgent.agent(Fruit.class, new Apple());
        fruit.show();
    }
}
