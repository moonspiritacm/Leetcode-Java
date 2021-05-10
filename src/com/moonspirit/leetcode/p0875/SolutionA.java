package com.moonspirit.leetcode.p0875;

/**
 * 二分查找。O(nlogm) O(1)
 */
class SolutionA {
    private boolean isOkay(int[] piles, int h, int k) {
        for (int pile : piles) {
            h -= (pile + k - 1) / k;
        }
        return h >= 0;
    }

    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0 || piles.length > h) {
            return 0;
        }

        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isOkay(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
