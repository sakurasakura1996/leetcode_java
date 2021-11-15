package 按顺序刷题.problem19_删除链表的倒数第N个结点;

import java.util.Deque;
import java.util.LinkedList;

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

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 很多链表类的题目可以想想双指针的思路, 这道题要注意考虑特殊情况 如果删除的是头节点呢？
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, next = dummy;
        for (int i = 0; i < n; i++) {
            next = next.next;
        }
        while (next.next != null) {
            prev = prev.next;
            next = next.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 使用栈先进后出的思路也可以呀。
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }
}
