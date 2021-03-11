package com.moonspirit.leetcode.p0227;

import java.util.Stack;

/**
 * 计算器简化版。O(n) O(n)
 * 只有加减乘除，没有括号。如果将加减视为数值自身属性，则运算符只有一种优先级，运算符栈可省略。
 * <p>
 * 执行用时：6 ms, 在所有 Java 提交中击败了 96.41% 的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了 54.67%的用户
 */
class Solution1 {
    public static void main(String[] args) {
        new Solution1().calculate("1+1+1");
    }

    private void calc(Stack<Long> stk, long num, char sign) {
        switch (sign) {
            case '+':
                stk.push(num);
                break;
            case '-':
                stk.push(-num);
                break;
            case '*':
                stk.push(stk.pop() * num);
                break;
            case '/':
                stk.push(stk.pop() / num);
        }
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chs = s.toCharArray();
        Stack<Long> stk = new Stack<>();
        char sign = '+';
        long num = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                while (i < chs.length && chs[i] >= '0' && chs[i] <= '9') {
                    num = num * 10 + chs[i] - '0';
                    i++;
                }
                i--;
            } else if (chs[i] != ' ') {
                calc(stk, num, sign);
                sign = chs[i];
                num = 0;
            }
        }
        calc(stk, num, sign);
        long res = 0;
        while (!stk.isEmpty()) {
            res += stk.pop();
        }
        return (int) res;
    }
}
