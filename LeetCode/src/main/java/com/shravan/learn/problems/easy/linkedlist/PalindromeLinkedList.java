package com.shravan.learn.problems.easy.linkedlist;

import com.shravan.learn.model.ListNode;

public class PalindromeLinkedList {
    // check if first half of list = reverse(second half of list)
    public boolean isPalindrome(ListNode head) {
        ListNode reverse = findMidAndReverse(head);
        while (reverse != null) {
            if (head.val != reverse.val) return false;
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    private ListNode findMidAndReverse(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // if the length of List is odd
        if (fast != null) {
            slow = slow.next;
        }
        // slow is middle node
        // reverse second half of list
        return reverseList(slow);
    }

    private ListNode reverseList(ListNode head) {
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
