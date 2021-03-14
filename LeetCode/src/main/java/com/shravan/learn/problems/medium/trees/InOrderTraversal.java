package com.shravan.learn.problems.medium.trees;

import com.shravan.learn.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // push all left nodes into stack
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // pop left most node
            curr = stack.pop();
            // add to inorder list
            inorder.add(curr.val);
            // go to right node of current node
            curr = curr.right;
        }
        return inorder;
    }

}
