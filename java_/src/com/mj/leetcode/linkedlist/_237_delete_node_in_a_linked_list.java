package com.mj.leetcode.linkedlist;


public class _237_delete_node_in_a_linked_list {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


}
