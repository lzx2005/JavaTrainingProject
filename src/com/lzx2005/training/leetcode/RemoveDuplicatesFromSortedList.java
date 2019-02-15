package com.lzx2005.training.leetcode;

import com.lzx2005.training.node.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }
            if (head.next == null) {
                break;
            }
            if (head.val != head.next.val) {
                head = head.next;
            }
        }
        return first;
    }

    public static void main(String[] args) {

    }
}
