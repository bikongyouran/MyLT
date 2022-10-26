package com.lt.linkedlist;

public class SwapNodesInPairs24 {
    public class ListNode {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1, head);
            ListNode pre = dummy;
            ListNode cur = head;
            // format 1
//            ListNode tmp;
//            while (cur != null && cur.next != null) {
//                pre.next = cur.next;
//                tmp = cur.next.next;
//                cur.next.next = cur;
//                cur.next = tmp;
//                pre = cur;
//                cur = tmp;
//            }
            //format 2
            while (cur != null && cur.next != null) {
                pre.next = cur.next;
                cur.next = cur.next.next;
                pre.next.next = cur;
                pre = pre.next.next;
                cur = cur.next;
            }
            return dummy.next;
        }

        //递归
//        public ListNode swapPairs(ListNode head) {
//            // base case 退出提交
//            if(head == null || head.next == null) return head;
//            // 获取当前节点的下一个节点
//            ListNode next = head.next;
//            // 进行递归
//            ListNode newNode = swapPairs(next.next);
//            // 这里进行交换
//            next.next = head;
//            head.next = newNode;
//
//            return next;
//        }

        int val;
        ListNode next;
        ListNode(int val, ListNode node) {
            this.val = val;
            this.next = node;
        }
    }
}
