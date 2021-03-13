package com.shravan.learn.problems.easy.linkedlist;

import com.shravan.learn.model.ListNode;

public class LinkedListCycle {
    // 2 pointers, slow pointers moves one step at a time, fast pointer moves 2 steps at a time
    // if slow and fast pointer meet, there is cycle in linked list
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
