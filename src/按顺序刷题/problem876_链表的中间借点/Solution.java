package 按顺序刷题.problem876_链表的中间借点;

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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode ans = head;
        while (fast != null){
            if (fast.next == null) {
                ans = slow;
                break;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast == null || fast.next == null) {
                ans = slow;
                break;
            } else {
                fast = fast.next;
            }
        }
        return ans;
    }

    public ListNode middleNode2(ListNode head) {
        // 上面方法写的太丑了。。。
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
