package com.moonspirit.leetcode.p0739;

import java.util.Stack;

/**
 * 单调栈。O(n) O(n)
 */
class SolutionA {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }

        int n = T.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && T[i] > T[stk.peek()]) {
                int j = stk.pop();
                res[j] = i - j;
            }
            stk.push(i);
        }
        return res;
    }
}
