package com.moonspirit.leetcode.p0053;

/**
 * 分治（简易线段树）。O(n) O(logn)
 * 对于区间[l,r]，维护四个状态：
 * lSum：区间内以l为左端点的最大字段和；
 * rSum：区间内以r为右端点的最大字段和；
 * mSum：区间的最大字段和；
 * iSum：区间和。
 * <p>
 * 根据左右子区间状态合并得到区间状态：
 * 更新iSum：左右子区间iSum之和；
 * 更新lSum：①使用部分左区间l.lSum ②使用全部左区间和右区间左侧l.iSum+r.lSum；
 * 更新rSum：①使用部分右区间r.rSum ②使用全部右区间和左区间右侧r.iSum+l.rSum；
 * 更新mSum：①左区间最大字段和l.mSum ②右区间最大字段和r.mSum ③左区间右侧和右区间左侧l.rSum。
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了 12.49% 的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了 51.94% 的用户
 */
class Solution2 {
    private int[] helper(int[] nums, int l, int r) {
        if (l == r) {
            return new int[]{nums[l], nums[l], nums[l], nums[l]};
        }

        int m = l + ((r - l) >> 1);
        int[] ls = helper(nums, l, m);
        int[] rs = helper(nums, m + 1, r);
        return merge(ls, rs);
    }

    private int[] merge(int[] ls, int[] rs) {
        int[] s = new int[4];
        s[1] = ls[1] + rs[1];
        s[2] = Math.max(ls[2], ls[1] + rs[2]);
        s[3] = Math.max(rs[3], rs[1] + ls[3]);
        s[0] = Math.max(Math.max(ls[0], rs[0]), ls[3] + rs[2]);
        return s;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return helper(nums, 0, nums.length - 1)[0];
    }
}
