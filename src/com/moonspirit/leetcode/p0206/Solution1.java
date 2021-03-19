package com.moonspirit.leetcode.p0206;

/**
 * 递归。O(n) O(n)
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了 37.83% 的用户
 */
class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }
}
