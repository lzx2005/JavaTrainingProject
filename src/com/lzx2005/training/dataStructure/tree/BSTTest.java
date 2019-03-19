package com.lzx2005.training.dataStructure.tree;

/**
 * Created by hzlizx on 2019/3/19
 */
public class BSTTest {

    public static void main(String[] args) {
        BST<String, String> bst = new BST<>();
        bst.insert("c", "c");
        bst.insert("b", "b");
        bst.insert("d", "d");
        bst.insert("e", "e");
        bst.insert("a", "a");
        System.out.println(bst.minimum());
        System.out.println(bst.maximum());
        System.out.println(bst.size());
        bst.preOrder();
        System.out.println("--------");
        bst.delete("c");
        System.out.println(bst.minimum());
        System.out.println(bst.maximum());
        System.out.println(bst.size());
        bst.preOrder();

    }
}
