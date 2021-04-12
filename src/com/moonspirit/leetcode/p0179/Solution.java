package com.moonspirit.leetcode.p0179;

class Solution {
    private String res = "";

    private boolean compare(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) < s2.charAt(i);
            }
        }
        return false;
    }

    private void backtrace(int[] nums, boolean[] flag, int index, StringBuilder sb) {
        if (index == nums.length) {
            String str = new String(sb);
            if (res.equals("") || compare(res, str)) {
                res = str;
            }
        }

        for (int i = index; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                sb.append(nums[i]);
                backtrace(nums, flag, index + 1, sb);
                sb.delete(String.valueOf(nums[i]).length());
                sb.remove(nums[i]);
                flag[i] = false;
            }
        }
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        backtrace(nums, new boolean[nums.length], 0, new StringBuilder());
        return res;
    }
}
