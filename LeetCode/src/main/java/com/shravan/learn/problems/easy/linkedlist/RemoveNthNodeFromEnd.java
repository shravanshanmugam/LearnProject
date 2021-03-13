package com.shravan.learn.problems.easy.linkedlist;

import com.shravan.learn.model.ListNode;

public class RemoveNthNodeFromEnd {
    // 2 pointers, a starts at head, b starts at n steps from head
    // when b reaches end, a reaches the n+1 node from end
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a = head;
        ListNode b = head;
        while (n-- > 0) {
            b = b.next;
        }
        if (b == null) return a.next;
        while (b.next != null) {
            a = a.next;
            b = b.next;
        }
        a.next = a.next.next;
        return head;
    }
}
