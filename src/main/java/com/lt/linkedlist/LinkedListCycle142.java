package com.lt.linkedlist;

public class LinkedListCycle142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode tmp = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (fast != tmp) {
                    fast = fast.next;
                    tmp = tmp.next;
                }
                return tmp;
            }
        }
        return null;
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
