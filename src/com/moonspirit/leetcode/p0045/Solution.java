package com.moonspirit.leetcode.p0045;

/**
 * 记录在当前位置可以到达的范围内，下一跳可以到达的最远位置。
 * 从前往后贪心，f[i]表示跳到i位置的最少步数，对于i<j，一定有f[i]≤f[j]，贪心单调性证毕。
 */
//class Solution {
//    public int jump(int[] nums) {
//        if (nums == null || nums.length < 2) {
//            return 0;
//        }
//
//        int pos = 0;
//        int step = 0;
//        int tmp = 0;
//        int len = 0;
//        while (pos < nums.length) {
//            for (int i = 0; i <= nums[pos]; i++) {
//                Math.max(tmp, nums[pos + i]);
//                if (len >= nums.length) {
//                    return step + 1;
//                }
//            }
//        }
//
//    }
//}

class SolutionZ {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
