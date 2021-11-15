package 每日一题.problem725_分隔链表;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n ++;
            temp = temp.next;
        }
        int quotient = n / k, remainder = n % k;
        ListNode[] ans = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            ans[i] = cur;
            int partSize = quotient + (i < remainder ? 1:0);
            for (int j = 1; j < partSize; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ans;
    }
}
