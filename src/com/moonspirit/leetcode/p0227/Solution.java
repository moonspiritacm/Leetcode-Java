package com.moonspirit.leetcode.p0227;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 双栈模拟，逆波兰表达式。O(n) O(n)
 * <p>
 * 执行用时：19 ms, 在所有 Java 提交中击败了 32.81% 的用户
 * 内存消耗：40.6 MB, 在所有 Java 提交中击败了 35.83% 的用户
 */
class Solution {
    private void calc(Stack<Long> nums, char op) {
        if (nums.size() == 0) {
            return;
        }

        long a = 0;
        long b = nums.pop();
        if (nums.size() > 0) {
            a = nums.pop();
        }
        if (op == '+') {
            nums.push(a + b);
        } else if (op == '-') {
            nums.push(a - b);
        } else if (op == '*') {
            nums.push(a * b);
        } else if (op == '/') {
            nums.push(a / b);
        }
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chs = s.toCharArray();
        Stack<Long> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                long num = 0;
                while (i < chs.length && chs[i] >= '0' && chs[i] <= '9') {
                    num = num * 10 + chs[i] - '0';
                    i++;
                }
                nums.push(num);
                i--;
            } else if (chs[i] == '(') {
                ops.push(chs[i]);
            } else if (chs[i] == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    calc(nums, ops.pop());
                }
                ops.pop();
            } else if (map.containsKey(chs[i])) {
                if (ops.isEmpty() || map.get(chs[i]) > map.get(ops.peek())) {
                    ops.push(chs[i]);
                } else {
                    while (!ops.isEmpty() && ops.peek() != '(' && map.get(chs[i]) <= map.get(ops.peek())) {
                        calc(nums, ops.pop());
                    }
                    ops.push(chs[i]);
                }
            }
        }
        while (!ops.isEmpty() && ops.peek() != '(') {
            calc(nums, ops.pop());
        }
        return nums.pop().intValue();
    }
}
