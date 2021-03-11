package com.moonspirit.leetcode.p0225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 单队列。O(n) O(1)
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.2 MB, 在所有 Java 提交中击败了 63.46% 的用户
 */
class MyStack1 {
    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack1() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        while (n-- > 0) {
            queue.offer(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
