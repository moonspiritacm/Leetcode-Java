package com.moonspirit.leetcode.p0477;

/**
 * 逐位统计。O(32n) O(1)
 */
class SolutionA {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += num >>> i & 1;
            }
            res += cnt * (nums.length - cnt);
        }
        return res;
    }
}
