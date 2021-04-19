package com.moonspirit.leetcode.p0027;

/**
 * 前移。O(n) O(1)
 */
class SolutionA {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0){
            return 0;
        }

        int len = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=val) {
                nums[len++]=nums[i];
            }
        }
        return len;
    }
}
