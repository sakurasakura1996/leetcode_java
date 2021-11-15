package 按顺序刷题.problem21_合并两个有序链表;

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
//        if (l1 != null) {
//            cur.next = l1;
//        } else {
//            cur.next = l2;
//        }
        //注释部分完全可以用三元表达式来写啊，以后形成习惯把
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
