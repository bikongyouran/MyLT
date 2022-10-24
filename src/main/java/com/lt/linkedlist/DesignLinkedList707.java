package com.lt.linkedlist;

public class DesignLinkedList707 {
    ListNode head;
    int size;

    public DesignLinkedList707() {

    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            if (count == index) {
                return tmp.val;
            }
            count++;
            tmp = tmp.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) {
            index = 0;
        }

        if (index == 0) {
            ListNode newNode = new ListNode(val, null);
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        ListNode pre = head;
        ListNode cur = head;
        if (index == size) {
            for (int i = 0; i < index - 1; i++) {
                pre = cur;
                cur = cur.next;
            }
            ListNode newNode = new ListNode(val, null);
            cur.next = newNode;
            size++;
            return;
        }

        for (int i = 0; i < index; i++) {
            pre = cur;
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val, null);
        newNode.next = cur;
        pre.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        ListNode pre = head;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        size--;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode node) {
            this.val = val;
            this.next = node;
        }
    }

    public static void main(String[] args) {
        DesignLinkedList707 myList = new DesignLinkedList707();
        myList.addAtHead(1);
        myList.addAtTail(3);
        myList.addAtIndex(1,2);
        int res = myList.get(1);
        myList.deleteAtIndex(1);
        int res2 = myList.get(1);
        System.out.println(res);
        System.out.println(res2);
    }
}
