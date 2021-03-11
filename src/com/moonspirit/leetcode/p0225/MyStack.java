package com.moonspirit.leetcode.p0225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 双队列。O(n) O(n)
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.2 MB, 在所有 Java 提交中击败了 51.73% 的用户
 */
class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q1 = new LinkedList<>();  // 辅助
        q2 = new LinkedList<>();  // 栈
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.offer(x);
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        q2 = new LinkedList<>(q1);
        q1.clear();
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q2.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q2.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q2.isEmpty();
    }
}
