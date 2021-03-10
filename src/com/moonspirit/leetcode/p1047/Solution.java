package com.moonspirit.leetcode.p1047;

import java.util.Stack;

/**
 * 栈操作。O(n) O(n)
 * <p>
 * 执行用时：32 ms, 在所有 Java 提交中击败了 39.84% 的用户
 * 内存消耗：39.2 MB, 在所有 Java 提交中击败了 30.07% 的用户
 */
class Solution {
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        char[] chs = S.toCharArray();
        Stack<Character> stk = new Stack<>();
        for (char ch : chs) {
            if (stk.isEmpty() || stk.peek() != ch) {
                stk.push(ch);
            } else {
                stk.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return sb.reverse().toString();
    }
}
