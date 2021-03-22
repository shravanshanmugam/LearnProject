package com.shravan.learn.algorithms.sort;

import com.shravan.learn.model.TreeNode;

/**
 * Insert into BST and use inorder traversal to put into array
 * T(n) = O(n log n)
 * O(n) = O(n)
 */
public class TreeSort {

    // Root of BST
    private TreeNode root;

    // Constructor
    TreeSort() {
        root = null;
    }

    public static void main(String[] args) {
        TreeSort solution = new TreeSort();
        int[] arr = {5, 4, 7, 2, 11};
        solution.treeInsert(arr);
        solution.inorder(solution.root);
    }

    // This method mainly
    // calls insertRec()
    void insert(int key) {
        root = insertIntoBST(root, key);
    }

    TreeNode insertIntoBST(TreeNode root, int key) {
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.val)
            root.left = insertIntoBST(root.left, key);
        else if (key > root.val)
            root.right = insertIntoBST(root.right, key);

        /* return the root */
        return root;
    }

    // A function to do
    // inorder traversal of BST
    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    void treeInsert(int[] arr) {
        for (int value : arr) {
            insert(value);
        }
    }
}
