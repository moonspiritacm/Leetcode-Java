package com.moonspirit.leetcode.p0061;

/**
 * 快慢指针。O(n) O(1)
 * ①计算链表长度；
 * ②定义快慢指针，慢指针指向头节点，快指针指向前方k步（第k+1个节点）；
 * ③快慢指针同步前移，直到快指针指向尾节点；
 * ④慢指针指向新链表的尾节点，慢指针的下一个节点即为新链表的头节点。
 */
class Solution1 {
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

        k %= n;
        if (k == 0) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode res = slow.next;
        fast.next = head;
        slow.next = null;
        return res;
    }
}
