package com.moonspirit.leetcode.p0002;

/**
 * 模拟加法。O(n) O(n)
 */
class SolutionA {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyRoot = new ListNode();
        ListNode curr = dummyRoot;
        int add = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                add += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                add += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(add % 10);
            curr = curr.next;
            add = add / 10;
        }
        if (add != 0) {
            curr.next = new ListNode(add);
        }
        return dummyRoot.next;
    }
}
