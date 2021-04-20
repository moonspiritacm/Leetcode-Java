package com.moonspirit.leetcode.p1019;

import java.util.Stack;

/**
 * 单调栈（同时存储位置和大小）。O(n) O(n)
 */
class SolutionA {
    public int[] nextLargerNodes(ListNode head) {
        int num = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            num++;
        }

        int index = 0;
        int[] res = new int[num];
        Stack<int[]> stk = new Stack<>();
        while (head != null) {
            while (!stk.isEmpty() && head.val > stk.peek()[1]) {
                int[] tmp = stk.pop();
                res[tmp[0]] = head.val;
            }
            stk.push(new int[]{index++, head.val});
            head = head.next;
        }
        return res;
    }
}
