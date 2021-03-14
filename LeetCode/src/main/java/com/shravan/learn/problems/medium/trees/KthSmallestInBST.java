package com.shravan.learn.problems.medium.trees;

import com.shravan.learn.model.TreeNode;

import java.util.Stack;

public class KthSmallestInBST {
    // inorder traversal gives increasing order of elements
    // kth element in inorder traversal gives kth smallest element
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int index = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            index++;
            // check if current element is the kth element
            if (index == k)
                return curr.val;
            curr = curr.right;
        }
        return -1;
    }

}
