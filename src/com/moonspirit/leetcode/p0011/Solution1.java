package com.moonspirit.leetcode.p0011;

/**
 * 双指针。O(n) O(1)
 * 流程：定义双指针分别指向左右边界，每次选定较小者，向中间收窄，同时更新最大值，直到指针重合。
 * 证明：
 * 盛水量等于短板长度与宽度的乘积，即min(h[l], h[r])*(r-l)。
 * 无论长板或短板收窄，都会导致宽度减一；
 * 如果向内移动短板，短板长度有可能增加，从而使盛水量增加；
 * 如果向内移动长板，短板长度不变或者更小，盛水量不可能增加。
 */
class Solution1 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
