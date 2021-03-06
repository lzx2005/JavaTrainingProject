package com.lzx2005.training.algorithms4.demo_1_3_3;

import com.lzx2005.training.algorithms4.demo_1_3_2.CustomStack;

import java.util.Iterator;

/**
 * Created by hzlizx on 2018/3/15 0015
 */
public class LinkedStack<T> implements CustomStack<T>,Iterable<T> {
    private Node<T> firstNode;

    @Override
    public int size() {
        int i = 0;
        for (Node node = firstNode; node.next != null; node = node.next) i++;
        return i;
    }

    @Override
    public void push(T value) {
        Node<T> objectNode = new Node<>();
        objectNode.value = value;
        if (firstNode == null) {
            firstNode = objectNode;
        } else {
            objectNode.next = firstNode;
            firstNode = objectNode;
        }
    }

    @Override
    public T pop() {
        Node<T> node = firstNode;
        if(node != null){
            firstNode = node.next;
            return node.value;
        }else{
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> node = firstNode;

            @Override
            public boolean hasNext() {
                return node !=null;
            }

            @Override
            public T next() {
                T v = node.value;
                node = node.next;
                return v;
            }
        };
    }

    class Node<T> {
        T value;
        Node next;
    }
}