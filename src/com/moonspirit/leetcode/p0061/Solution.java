package com.moonspirit.leetcode.p0061;

/**
 * 闭合成环。O(n) O(1)
 * ①计算链表长度，同时将链表成环；
 * ②在`n-k%n`处断开链表（走`n-k%n-1`步），返回链表头。
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        curr.next = head;

        n = n - k % n;
        while (n > 0) {
            curr = curr.next;
            n--;
        }
        ListNode res = curr.next;
        curr.next = null;
        return res;
    }
}
