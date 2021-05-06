package com.moonspirit.leetcode.p0690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 深度优先搜索（迭代）。O(n) O(n)
 */
class SolutionB {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        int res = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(id);
        while (!stk.isEmpty()) {
            Employee e = map.get(stk.pop());
            res += e.importance;
            for (int i : e.subordinates) {
                stk.push(i);
            }
        }
        return res;
    }
}
