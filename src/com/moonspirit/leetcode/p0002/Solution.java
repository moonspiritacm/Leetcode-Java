package com.moonspirit.leetcode.p0002;

/**
 * 链表。O(max(m,n)) O(max(m,n))
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了 87.49% 的用户
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyRoot = new ListNode();
        ListNode head = dummyRoot;
        int num = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(num % 10);
            head = head.next;
            num /= 10;
        }
        if (num != 0) {
            head.next = new ListNode(num);
        }
        return dummyRoot.next;
    }
}
