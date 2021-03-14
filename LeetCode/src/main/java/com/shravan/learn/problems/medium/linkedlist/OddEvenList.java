package com.shravan.learn.problems.medium.linkedlist;

import com.shravan.learn.model.ListNode;

public class OddEvenList {
    // 1     ->     2     ->     3     ->     4     ->     5     ->     6     ->     NULL
    // odd         even       even.next
    // odd.next = even.next
    // odd = odd.next
    // even.next = odd.next
    // even = even.next;
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // link end of odd list to head of ven list
        odd.next = evenHead;
        return head;
    }
}
