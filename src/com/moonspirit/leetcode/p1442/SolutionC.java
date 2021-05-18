package com.moonspirit.leetcode.p1442;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。O(n) O(n)
 */
class SolutionC {
    public int countTriplets(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> ids = new HashMap<>();
        int[] xors = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        for (int k = 0; k < arr.length; k++) {
            if (cnt.containsKey(xors[k + 1])) {
                res += cnt.get(xors[k + 1]) * k - ids.get(xors[k + 1]);
            }
            cnt.put(xors[k], cnt.getOrDefault(xors[k], 0) + 1);
            ids.put(xors[k], ids.getOrDefault(xors[k], 0) + k);
        }
        return res;
    }
}
