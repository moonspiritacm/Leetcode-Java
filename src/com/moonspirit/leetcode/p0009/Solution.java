package com.moonspirit.leetcode.p0009;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
