package com.moonspirit.leetcode.p0554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 哈希表。O(mn) O(mn)
 */
class SolutionA {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int pos = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                pos += list.get(i);
                if (map.containsKey(pos)) {
                    map.put(pos, map.get(pos) + 1);
                } else {
                    map.put(pos, 1);
                }
            }
        }

        int max = 0;
        for (int value : map.values()) {
            max = Math.max(max, value);
        }
        return wall.size() - max;
    }
}
