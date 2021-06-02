package com.moonspirit.leetcode.p0523;

/**
 * 数组前缀和。O(n^2) O(n)
 */
class SolutionA {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i + 2; j <= nums.length; j++) {
                if ((prefix[j] - prefix[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
