package com.moonspirit.leetcode.p0224;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        new Solution().calculate("0-2147483647");
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        long num = 0;  // 计算数字
        char[] chs = s.toCharArray();
        Stack<Long> stk = new Stack<>();
        for (char ch : chs) {
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            } else if (ch == '+' || ch == '-' || ch == '(') {
                if (num != 0) {
                    stk.push(num);
                }
                stk.push((long) ch);
                num = 0;
            } else if (ch == ')') {
                long add = 0;
                while (stk.peek() != '(') {
                    long tmp = stk.pop();
                    if (tmp == '+') {
                        add += num;
                    } else if (tmp == '-') {
                        add -= num;
                    } else {
                        num = tmp;
                    }
                }
                stk.pop();
                add += num;
                stk.push(add);
            }
        }
        long res = 0;
        while (!stk.isEmpty()) {
            long tmp = stk.pop();
            if (tmp == '+') {
                res += num;
            } else if (tmp == '-') {
                res -= num;
            } else {
                num = tmp;
            }
        }
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '+' || chs[i] == '-') {
                break;
            } else if (chs[i] > '0' && chs[i] <= '9') {
                res += num;
                break;
            }
        }
        return (int)res;
    }
}
