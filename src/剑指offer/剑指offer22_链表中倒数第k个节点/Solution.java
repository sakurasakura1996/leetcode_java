package 剑指offer.剑指offer22_链表中倒数第k个节点;

import 链表.ListNode;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k - 1; i++) {
            cur = cur.next;
        }
        while(cur.next != null){
            cur = cur.next;
            head = head.next;
        }
        return head;
    }
}
