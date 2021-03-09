package com.moonspirit.leetcode.p0061;

/**
 * 循环链表。O(n) O(1)
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了 48.46% 的用户
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        iter.next = head;

        k = n - k % n - 1;
        while (k > 0) {
            head = head.next;
            k--;
        }
        ListNode node = head.next;
        head.next = null;
        return node;
    }
}
