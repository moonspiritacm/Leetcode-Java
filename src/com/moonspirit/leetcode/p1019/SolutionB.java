package com.moonspirit.leetcode.p1019;

import java.util.Stack;

/**
 * 单调栈（预先存储为数组）。O(n) O(n)
 */
class SolutionB {
    public int[] nextLargerNodes(ListNode head) {
        int num = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            num++;
        }

        int[] nums = new int[num];
        curr = head;
        for (int i = 0; i < num; i++) {
            nums[i] = curr.val;
            curr = curr.next;
        }

        int[] res = new int[num];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < num; i++) {
            while (!stk.isEmpty() && nums[i] > nums[stk.peek()]) {
                res[stk.pop()] = nums[i];
            }
            stk.push(i);
        }
        return res;
    }
}
