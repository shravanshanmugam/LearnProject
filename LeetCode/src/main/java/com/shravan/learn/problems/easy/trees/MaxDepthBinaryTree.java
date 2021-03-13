package com.shravan.learn.problems.easy.trees;

import com.shravan.learn.model.TreeNode;

public class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // max height of tree = 1 + max(height of left subtree, height of right subtree)
        return 1 + Math.max(left, right);
    }
}
