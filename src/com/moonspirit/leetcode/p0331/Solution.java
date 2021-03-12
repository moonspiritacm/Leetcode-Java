package com.moonspirit.leetcode.p0331;

class Solution {
    public static void main(String[] args) {
        new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

    private int cnt = 0;

    private boolean isValid(String[] strs, int i) {
        cnt = Math.max(cnt, i);
        if (i >= strs.length) {
            return false;
        }

        if (strs[i].equals("#")) {
            return true;
        } else {
            return isValid(strs, i + 1) && isValid(strs, i + 2);
        }
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }

        String[] strs = preorder.split(",");
        return isValid(strs, 0) && (cnt == strs.length - 1);
    }
}
