package com.moonspirit.leetcode.p0300;

/**
 * 贪心算法+二分查找。O(nlogn) O(n)
 * 递增子序列增长越缓慢，最终长度越长。定义tails[i]为长度为i的最长递增子序列的最小末尾，tails保持有序。
 * 对于任一元素，如果它大于当前tails数组的所有值（即末尾值），那么把它添加到tails数组后面，最长递增子序列长度加1；
 * 对于任一元素，如果它不大于tails数组的所有值，说明在某长度上存在更小末尾的可能性，使用二分查找找到该长度，更新其最小末尾。
 */
class Solution1 {
    private int binSearch(int[] nums, int len, int target) {
        int left = 0, right = len - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                return mid;
        }
        return left;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] tails = new int[nums.length + 1];
        tails[1] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[len]) {
                tails[++len] = nums[i];
            } else {
                int pos = binSearch(tails, len + 1, nums[i]);
                tails[pos] = nums[i];
            }
        }
        return len;
    }
}
