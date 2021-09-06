package 按顺序刷题.problem2_两数相加;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    // 我特么自己都笑了，写的java代码又臭又长。。。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int flag = 0;
        ListNode ans = l1;
        ListNode cur = l1;
        // 将相加结果放在链表 l1上面
        while(l1!=null && l2!=null){
            int num = l1.val + l2.val + flag;
            cur = l1;
            if(num >= 10) {
                flag = 1;
                l1.val = num - 10;
            }else {
                flag = 0;
                l1.val = num;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int num = l1.val + flag;
            cur = l1;
            if(num >= 10){
                l1.val = num - 10;
                flag = 1;
            }else{
                l1.val = num;
                flag = 0;
            }
            l1 = l1.next;
        }
        while(l2 != null){
            int num = l2.val + flag;
            cur.next = l2;
            cur = l2;
            if(num >= 10){
                l2.val = num - 10;
                flag = 1;
            }else{
                l2.val = num;
                flag = 0;
            }
            l2 = l2.next;
        }
        if(flag == 1){
            cur.next = new ListNode(1);
        }
        return ans;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        // 直接开辟节点来实现
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int flag = 0;
        while (p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + flag;
            flag = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (flag > 0){
            curr.next = new ListNode(flag);
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummyHead;
        int flag = 0;
        while (p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + flag;
            flag = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p!= null) p = p.next;
            if (q != null) q = q.next;
        }
        if (flag != 0){
            cur.next = new ListNode(flag);
        }

        return dummyHead.next;
    }
}