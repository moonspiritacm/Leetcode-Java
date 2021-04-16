package com.moonspirit.leetcode.p0312;

class SolutionA {
    private int helper(int[] nums, int n) {
        if (n == nums.length) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int ans = nums[i];
                int tmp = nums[i];
                nums[i] = -1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] != -1) {
                        ans *= nums[j];
                        break;
                    }
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != -1) {
                        ans *= nums[j];
                        break;
                    }
                }
                max = Math.max(max, ans + helper(nums, n + 1));
                nums[i] = tmp;
            }
        }
        return max;
    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return helper(nums, 0);
    }
}
