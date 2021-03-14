package com.shravan.learn.problems.medium.linkedlist;

import com.shravan.learn.model.ListNode;

public class IntersectionOf2LinkedLists {
    // A = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
    // B = 9 -> 10 -> 3 -> 4 -> 5 -> 6 -> NULL
    // intersection = 3
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        // compare node itself, not just value
        while (tempA != tempB) {
            tempA = tempA != null ? tempA.next : headB;
            tempB = tempB != null ? tempB.next : headA;
        }
        return tempA;
    }
}
