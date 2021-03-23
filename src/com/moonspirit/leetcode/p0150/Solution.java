package com.moonspirit.leetcode.p0150;

import java.util.Stack;

/**
 * 逆波兰表达式。O(n) O(n)
 */
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stk = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int b = stk.pop();
                int a = stk.pop();
                int c = 0;
                switch (str) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = a / b;
                        break;
                }
                stk.push(c);
            } else {
                stk.push(Integer.valueOf(str));
            }
        }
        return stk.pop();
    }
}
