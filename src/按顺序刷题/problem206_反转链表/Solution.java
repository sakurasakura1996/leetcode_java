package 按顺序刷题.problem206_反转链表;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
// 进阶要求：使用递归和迭代两种方法来完成这道题。
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode pre = null, cur = head, next = head.next;
        return head;
    }
}
