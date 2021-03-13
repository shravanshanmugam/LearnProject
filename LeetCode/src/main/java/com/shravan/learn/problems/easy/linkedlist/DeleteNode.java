package com.shravan.learn.problems.easy.linkedlist;

import com.shravan.learn.model.ListNode;

public class DeleteNode {
    // 1 -> 2 -> 3 -> 4 -> 5 -> NULL, 3
    // node is the node to be deleted in linked list
    // value shifting, equivalent to replacing 3 with 4 and deleting 4
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
