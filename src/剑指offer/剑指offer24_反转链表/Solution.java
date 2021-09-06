package 剑指offer.剑指offer24_反转链表;
import 链表.ListNode;
public class Solution {
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode ans = head;
        ListNode nxt = head.next;
        ans.next = null;

        while (nxt != null){
            ListNode temp = nxt.next;
            nxt.next = ans;
            ans = nxt;
            nxt = temp;
        }
        return ans;
    }
}
