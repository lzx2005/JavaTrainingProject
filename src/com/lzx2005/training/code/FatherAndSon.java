package com.lzx2005.training.code;

/**
 * Created by Lizhengxian on 2017/3/27.
 */
public class FatherAndSon {
    public static void main(String[] args) {
        Father father = new Son();
        father.fMe();
    }
}

class Father{
    public void fMe(){
        System.out.println("fMe");
        fMe1();
        System.out.println(this);
        this.fMe1();
    }
    private void fMe1(){
        System.out.println("fMe1");
    }
}

class Son extends Father{
    /*public void fMe(){
        System.out.println("sMe");
        fMe1();
        System.out.println(this);
        this.fMe1();
    }*/

    public void fMe1(){
        System.out.println("sMe1");
    }
}