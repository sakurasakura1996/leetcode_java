package JianZhiOffer.剑指offer18_删除链表的节点;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        else if (head.val == val) {
            return head.next;
        } else {
            ListNode cur = head;
            ListNode prev = null;
            while (cur != null) {
                if (cur.val == val) {
                    cur.next = cur.next.next;
                }
                cur = cur.next;
            }
        }
        return head;
    }
}
