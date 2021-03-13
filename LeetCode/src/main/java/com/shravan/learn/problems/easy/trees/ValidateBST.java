package com.shravan.learn.problems.easy.trees;

import com.shravan.learn.model.TreeNode;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        // set min and max boundary check for each node
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode curr, long min, long max) {
        // if leaf node is reached without condition failing, then return true
        if (curr == null) return true;
        // current node value is within min and max boundary, check for left and right subtree
        if (curr.val > min && curr.val < max) {
            return check(curr.left, min, curr.val) && check(curr.right, curr.val, max);
        }
        return false;
    }
}
