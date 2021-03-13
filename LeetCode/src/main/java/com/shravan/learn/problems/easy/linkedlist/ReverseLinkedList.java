package com.shravan.learn.problems.easy.linkedlist;

import com.shravan.learn.model.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // create empty previous node
        ListNode temp = null;
        while (head != null) {
            ListNode prev = head;
            // shift head node
            head = head.next;
            // set next to empty previous node
            prev.next = temp;
            temp = prev;
        }
        return temp;
    }
}
