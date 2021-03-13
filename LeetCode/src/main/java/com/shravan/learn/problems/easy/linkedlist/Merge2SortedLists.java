package com.shravan.learn.problems.easy.linkedlist;

import com.shravan.learn.model.ListNode;

public class Merge2SortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);
        ListNode head = merged;
        while (l1 != null && l2 != null) {
            // if list1 is less, then add to new list
            if (l1.val < l2.val) {
                merged.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l2.val < l1.val) {
                // if list2 is less, then add to new list
                merged.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                // if list1 = list2 then add both to new list
                merged.next = new ListNode(l1.val);
                merged = merged.next;
                merged.next = new ListNode(l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }
            merged = merged.next;
        }
        // add remaining list1 items into new list
        while (l1 != null) {
            merged.next = new ListNode(l1.val);
            l1 = l1.next;
            merged = merged.next;
        }
        // add remaining list2 items into new list
        while (l2 != null) {
            merged.next = new ListNode(l2.val);
            l2 = l2.next;
            merged = merged.next;
        }
        return head.next;
    }
}
