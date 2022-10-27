package com.lt.linkedlist;

public class IntersectionOfTwoLinkedLists160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while (curA != null) {
            lengthA++;
            curA = curA.next;
        }
        while (curB != null) {
            lengthB++;
            curB = curB.next;
        }
        if (lengthA > lengthB) {
            curA = shortLongList(headA, lengthA - lengthB);
            curB = headB;
        } else {
            curB = shortLongList(headB, lengthB - lengthA);
            curA = headA;
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    private ListNode shortLongList(ListNode longList, int length) {
        ListNode cur = longList;
        for (int i = 0; i < length; i++) {
            cur = cur.next;
        }
        return cur;
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
