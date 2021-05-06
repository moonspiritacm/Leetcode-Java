package com.moonspirit.leetcode.p0690;

import java.util.*;

/**
 * 广度优先搜索。O(n) O(n)
 */
class SolutionC {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            Employee e = map.get(queue.poll());
            res += e.importance;
            for (int i : e.subordinates) {
                queue.offer(i);
            }
        }
        return res;
    }
}
