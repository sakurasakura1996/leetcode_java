package JianZhiOffer.剑指offer24_反转链表;
/* 反转链表，节点个数 0-5000 */
import JianZhiOffer.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        // 时常不要忘记初始情况和特殊情况哦
        if (head == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode prev = null;
        while (next != null) {
            head.next = prev;
            prev = head;
            head = next;
            next = next.next;
        }
        head.next = prev;   // 这里注意 最后一个节点没有连接上
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);

        Solution solution = new Solution();
        ListNode listNode = solution.reverseList(listNode1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }
}
