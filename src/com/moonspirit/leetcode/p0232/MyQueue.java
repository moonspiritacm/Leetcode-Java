package com.moonspirit.leetcode.p0232;

import java.util.Stack;

/**
 * 双栈模拟。均摊时间复杂度 O(1) O(n)
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了 52.73% 的用户
 */
class MyQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stk1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stk2.isEmpty()) {
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
        return stk2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stk2.isEmpty()) {
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
        return stk2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty();
    }
}

