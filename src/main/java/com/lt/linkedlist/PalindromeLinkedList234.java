package com.lt.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList234 {
    //solution 1
//    public boolean isPalindrome(ListNode head) {
//        if (head == null) return false;
//        List<Integer> list = new ArrayList<>();
//        ListNode cur = head;
//        while (cur != null) {
//            list.add(cur.val);
//            cur = cur.next;
//        }
//        int left = 0;
//        int right = list.size() - 1;
//        while (left < right) {
//            if (list.get(left) != list.get(right)) return false;
//            left++;
//            right--;
//        }
//        return true;
//    }

    //solution 2
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = new ListNode(-1, head);
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            pre = pre.next;
        }
        ListNode cur1 = head;
        pre.next = null;
        ListNode cur2 = slow;
        cur2 = reverse(cur2);
        while (cur1 != null) {
            if (cur1.val != cur2.val) return false;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode tmp = null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
