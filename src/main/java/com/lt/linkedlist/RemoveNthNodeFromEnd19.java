package com.lt.linkedlist;

public class RemoveNthNodeFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        if (n <= 0) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        if (n > 0) return head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
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
