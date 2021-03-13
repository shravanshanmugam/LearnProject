package com.shravan.learn.problems.easy.trees;

import com.shravan.learn.model.TreeNode;

public class SortedArrayToBST {
    //    1) Get the Middle of the array and make it root.
//    2) Recursively do same for left half and right half.
//            a) Get the middle of left half and make it left child of the root created in step 1.
//            b) Get the middle of right half and make it right child of the root created in step 1.
    public TreeNode sortedArrayToBST(int[] nums) {
        return recurse(nums, 0, nums.length - 1);
    }

    public TreeNode recurse(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = recurse(nums, start, mid - 1);
        curr.right = recurse(nums, mid + 1, end);
        return curr;
    }

}
