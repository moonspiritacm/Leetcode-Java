package com.moonspirit.nowcode.p022;

/**
 * 快慢指针。O(n) O(1)
 * ①初始化：快慢指针都指向头结点；
 * ②构建指针距离：快指针前移k步，指向第k+1节点；
 * ③指针同步前移：直到快指针为空；
 * ④此时，慢指针指向倒数第k个节点。
 */
class Solution1 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
