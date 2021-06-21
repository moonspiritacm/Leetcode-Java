package com.moonspirit.leetcode.p0402;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 贪心+单调栈。O(n) O(n)
 */
class SolutionA {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k <= 0) {
            return num;
        }
        if (num.length() <= k) {
            return "0";
        }

        Deque<Character> deque = new LinkedList<>();
        for (char ch : num.toCharArray()) {
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > ch) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(ch);
        }
        while (k-- > 0) {
            deque.pollLast();
        }
        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            deque.pollFirst();
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.length() == 0 ? "0" : new String(sb);
    }
}
