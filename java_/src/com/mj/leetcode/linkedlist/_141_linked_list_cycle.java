package com.mj.leetcode.linkedlist;

public class _141_linked_list_cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) return true;
        }
        return false;

    }
}
