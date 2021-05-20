package com.moonspirit.leetcode.p0740;

import java.util.*;

class SolutionA {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                list.add(num);
                map.put(num, 1);
            }
        }
        Collections.sort(list);
        for (int num : list) {
            System.out.printf("%d ", num);
        }
        return 0;
    }
}
