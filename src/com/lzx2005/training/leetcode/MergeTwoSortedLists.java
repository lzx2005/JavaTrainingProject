package com.lzx2005.training.leetcode;

import com.lzx2005.training.node.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            if(l1==null) return l2;
            else return l1;
        }
        ListNode listNode;
        if(l1.val <= l2.val){
            listNode = new ListNode(l1.val);
            l1 = l1.next;
        }else {
            listNode = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode firstNode = listNode;
        while (l1 !=null && l2 !=null){
            if(l1.val <= l2.val){
                listNode.next = new ListNode(l1.val);
                listNode = listNode.next;
                l1 = l1.next;
            }else {
                listNode.next = new ListNode(l2.val);
                listNode = listNode.next;
                l2 = l2.next;
            }
        }
        while (l1!=null){
            listNode.next = new ListNode(l1.val);
            listNode = listNode.next;
            l1 = l1.next;
        }
        while (l2!=null){
            listNode.next = new ListNode(l2.val);
            listNode = listNode.next;
            l2 = l2.next;
        }
        return firstNode;
    }

}
