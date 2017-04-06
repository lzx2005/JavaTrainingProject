package com.lzx2005.training.suanfa;

/**
 * Created by Lizhengxian on 2017/3/26.
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head,int k) {
        int length = 0;
        ListNode node = head;
        while(node!=null){
            length++;
            node = node.next;
        }
        if((length-k)>=0){
            for(int i=0;i<(length-k);i++){
                head = head.next;
            }
            return head;
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = new FindKthToTail().FindKthToTail(listNode1, 6);
        System.out.println(listNode);
    }
}
