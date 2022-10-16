package 按顺序刷题.problem24_两两交换链表其中的节点;

/**
 * @author chenz
 * @ClassName Solution
 * @Description TODO
 * @date 2021/12/16-16:05
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null) {
            ListNode p = cur.next;
            ListNode q = cur.next.next;
            ListNode next = q.next;
            cur.next = q;
            q.next = p;
            cur = p;
            cur.next = next;
        }
        return dummy.next;
    }
}
