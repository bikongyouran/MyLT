package com.lt.linkedlist;

public class SwapNodesInPairs24 {
    public class ListNode {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1, head);
            ListNode pre = dummy;
            ListNode cur = head;
            ListNode tmp;
            while (cur != null && cur.next != null) {
                pre.next = cur.next;
                tmp = cur.next.next;
                cur.next.next = cur;
                cur.next = tmp;
                pre = cur;
                cur = tmp;
            }
            return dummy.next;
        }

        int val;
        ListNode next;
        ListNode(int val, ListNode node) {
            this.val = val;
            this.next = node;
        }
    }
}
