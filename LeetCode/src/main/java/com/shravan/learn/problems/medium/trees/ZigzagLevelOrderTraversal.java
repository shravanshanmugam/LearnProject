package com.shravan.learn.problems.medium.trees;

import com.shravan.learn.model.TreeNode;

import java.util.*;

public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) return levelOrder;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean forward = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            while (size > 0) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    row.add(curr.val);
                    if (curr.left != null)
                        q.add(curr.left);
                    if (curr.right != null)
                        q.add(curr.right);
                    size--;
                }
            }
            // if not forward, then reverse row and then insert into list
            if (!forward)
                Collections.reverse(row);
            levelOrder.add(row);
            // switch the order
            forward = !forward;
        }
        return levelOrder;
    }









    /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean direction = false;
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int rowSize = queue.size();
            while (rowSize > 0) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                row.add(current.val);
                rowSize--;
            }
            if (direction) Collections.reverse(row);
            direction = !direction;
            ret.add(row);
        }
        return ret;
    }*/
}
