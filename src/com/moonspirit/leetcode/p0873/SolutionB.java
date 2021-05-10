package com.moonspirit.leetcode.p0873;

import java.util.HashMap;
import java.util.Map;

/**
 * 暴力搜索。O(n^3) O(n)
 */
class SolutionB {
    public int lenLongestFibSubseq(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map.containsKey(arr[i] + arr[j])) {
                    int a = arr[j];
                    int b = arr[i] + arr[j];
                    int c = a + b;
                    int res = 3;
                    while (map.containsKey(c)) {
                        a = b;
                        b = c;
                        c = a + b;
                        res++;
                    }
                    max = Math.max(max, res);
                }
            }
        }
        return max;
    }
}
