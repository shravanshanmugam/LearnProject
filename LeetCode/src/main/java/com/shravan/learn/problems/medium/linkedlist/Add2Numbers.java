package com.shravan.learn.problems.medium.linkedlist;

import com.shravan.learn.model.ListNode;

public class Add2Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        // init carry over to 0
        int carry = 0;
        while (l1 != null || l2 != null) {
            carry = add(temp, l1, l2, carry);
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            temp = temp.next;
        }
        // if carry over still present then that will be last node (first digit of the number)
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return head.next;
    }

    // sum = digit of number 1 + digit of number 2 + carry over
    // if sum is greater than 9, then carry over = 1 and new digit = one's place of sum
    private int add(ListNode temp, ListNode l1, ListNode l2, int carry) {
        int x = value(l1) + value(l2) + carry;
        if (x >= 10) {
            temp.next = new ListNode(x % 10);
            return 1;
        } else {
            temp.next = new ListNode(x);
            return 0;
        }
    }

    private int value(ListNode current) {
        return current != null ? current.val : 0;
    }
}
