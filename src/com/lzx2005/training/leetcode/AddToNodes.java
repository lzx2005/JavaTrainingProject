package com.lzx2005.training.leetcode;

/**
 * Created by Lizhengxian on 2017/3/27.
 */

import com.lzx2005.training.node.ListNode;
import org.w3c.dom.NodeList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class AddToNodes {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2);
    }

    public ListNode add(ListNode l1,ListNode l2){
        int addVal = l1.val+l2.val;
        int value = 0;
        if(addVal<10){
            value = addVal;
        }
        ListNode nowNode = new ListNode(value);
        if(l1.next!=null&&l2.next!=null){
            nowNode.next = add(l1.next,l2.next);
            if(addVal>=10){
                nowNode.next.val+=1;
            }
        }else{
            if(addVal>=10){
                ListNode listNode = new ListNode(1);
                nowNode.next=listNode;
            }
        }
        return nowNode;
    }

    public static void main(String[] args) {
        /*
        *    [2,4,3]
        *    [5,6,4]
        * */

        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = new AddToNodes().addTwoNumbers(listNode1, listNode4);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}