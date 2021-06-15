package com.moonspirit.leetcode.p0002;

/**
 * 原地运算。O(n) O(1)
 */
class SolutionB {
    private int getLength(ListNode l) {
        int num = 0;
        while (l != null) {
            l = l.next;
            num++;
        }
        return num;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (getLength(l1) < getLength(l2)) {
            ListNode t = l1;
            l1 = l2;
            l2 = t;
        }
        int add = 0;
        ListNode head = l1;
        while (true) {
            if (l2 != null) {
                add += l2.val;
                l2 = l2.next;
            }
            add += l1.val;
            l1.val = add % 10;
            add = add / 10;
            if (l1.next == null) {
                break;
            }
            l1 = l1.next;
        }
        if (add != 0) {
            l1.next = new ListNode(add);
        }
        return head;
    }
}
