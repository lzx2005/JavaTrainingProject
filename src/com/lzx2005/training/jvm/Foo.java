package com.lzx2005.training.jvm;

/**
 * Created by hzlizx on 2019/3/14
 */
public class Foo {
    public static void main(String[] args) {
        boolean 吃过饭没 = true; // 直接编译的话 javac 会报错
        if (吃过饭没) System.out.println(" 吃了 ");
        if (true == 吃过饭没) System.out.println(" 真吃了 ");
    }

}
