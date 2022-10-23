package com.lt.linkedlist;

public class RemoveLinkedListElements203 {
    public ListNode removeElements(ListNode head, int val) {
        //solution 1: add a dummy node(-1, head), then set pre node and curr node.
        //solution 2: remove head if qualified, then set pre node and curr node. OR without pre node.
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;

        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
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



