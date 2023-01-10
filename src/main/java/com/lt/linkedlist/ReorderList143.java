package com.lt.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReorderList143 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        int len = list.size();
        int left = 1;
        int right = len - 1;
        int count = 1;
        ListNode cur = head;
        while (count < len) {
            if (count % 2 == 1) {
                cur.next = list.get(right);
                cur = cur.next;
                right--;
            } else {
                cur.next = list.get(left);
                cur = cur.next;
                left++;
            }
            count++;
        }
        cur.next = null;
    }
}
