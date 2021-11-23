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
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        // 递归解法
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next); // 先递归，然后在处理前面的部分。
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
