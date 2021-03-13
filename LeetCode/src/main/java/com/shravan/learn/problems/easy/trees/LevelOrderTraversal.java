package com.shravan.learn.problems.easy.trees;

import com.shravan.learn.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) return levelOrder;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int size = q.size();
            // processing each row
            while (size > 0) {
                TreeNode curr = q.poll();
                // for each node, insert left and right children into queue
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
                row.add(curr.val);
                size--;
            }
            levelOrder.add(row);
        }
        return levelOrder;
    }
}
