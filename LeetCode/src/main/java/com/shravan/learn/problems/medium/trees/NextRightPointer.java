package com.shravan.learn.problems.medium.trees;

public class NextRightPointer {
    public Node connect(Node root) {
        recurse(root, null);
        return root;
    }

    public void recurse(Node current, Node next) {
        if (current == null) return;
        current.next = next;
        // for left node, next node is the right node
        recurse(current.left, current.right);
        // for right node, next node is the left node of parent's next node
        recurse(current.right, next == null ? null : next.left);
    }

    //                4
//       /                 \
//      2 (curr)     (next) 6
//     /       \           / \
//    1 (left)   3 (right) 5   7
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
}
