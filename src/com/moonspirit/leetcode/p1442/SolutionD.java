package com.moonspirit.leetcode.p1442;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表（存储优化）。O(n) O(1)
 */
class SolutionD {
    public int countTriplets(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int res = 0;
        int xor = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> ids = new HashMap<>();
        for (int k = 0; k < arr.length; k++) {
            int tmp = xor ^ arr[k];
            if (cnt.containsKey(tmp)) {
                res += cnt.get(tmp) * k - ids.get(tmp);
            }
            cnt.put(xor, cnt.getOrDefault(xor, 0) + 1);
            ids.put(xor, ids.getOrDefault(xor, 0) + k);
            xor = tmp;
        }
        return res;
    }
}
