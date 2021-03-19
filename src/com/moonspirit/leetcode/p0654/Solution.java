package com.moonspirit.leetcode.p0654;

/**
 * 递归。O(n^2)/O(nlogn) O(n)/O(logn)
 */
class Solution {
    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int id = 0;
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                id = i;
            }
        }
        TreeNode root = new TreeNode(nums[id]);
        root.left = helper(nums, l, id - 1);
        root.right = helper(nums, id + 1, r);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }
}
