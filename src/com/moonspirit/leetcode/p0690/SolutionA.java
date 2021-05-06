package com.moonspirit.leetcode.p0690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 深度优先搜索（递归）。O(n) O(n)
 */
class SolutionA {
    private int dfs(Map<Integer, Employee> map, int id) {
        int res = 0;
        if (map.containsKey(id)) {
            Employee e = map.get(id);
            res = e.importance;
            for (int i : e.subordinates) {
                res += dfs(map, i);
            }
        }
        return res;
    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(map, id);
    }
}
