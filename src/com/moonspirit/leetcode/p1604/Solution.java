package com.moonspirit.leetcode.p1604;

import java.util.*;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        if (keyName == null || keyTime == null || keyName.length != keyTime.length) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            int hour = Integer.parseInt(keyTime[i].substring(0, 2));
            int minute = Integer.parseInt(keyTime[i].substring(3, 5));
            int time = hour * 60 + minute;
            if (map.containsKey(keyName[i])) {
                map.get(keyName[i]).add(time);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(time);
                map.put(keyName[i], list);
            }
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 2) <= 60) {
                    res.add(entry.getKey());
                    break;
                }
            }
        }
        return res;
    }
}
