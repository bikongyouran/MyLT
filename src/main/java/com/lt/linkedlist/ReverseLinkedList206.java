package com.lt.linkedlist;

public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode node) {
            this.val = val;
            this.next = node;
        }
    }
}
