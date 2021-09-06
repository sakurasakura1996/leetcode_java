package 剑指offer.problem06_从尾到头打印链表;

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

public class Solution {
    public int[] reversePrint(ListNode head){
        Deque<Integer> ans = new ArrayDeque<>();
        while (head != null){
            ans.push(head.val);
            head = head.next;
        }
        System.out.println(ans);
//        System.out.println(ans);
        int n = ans.size();
        int[] ret = new int[n];

        for (int i = 0; i < n; i++) {    //ans.size()是动态的，每次循环的时候都会重新判断哦。和python不一样。
            ret[i] = ans.pop();
            System.out.println(ret[i]);
        }
        return ret;
    }
    // 上面的方法运行效率很低，不应该这样转换的。
    public int[] reversePrint2(ListNode head){
        List<Integer> ans = new ArrayList<>();
        while (head != null){
            ans.add(head.val);
            head = head.next;
        }
        int n = ans.size();
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = ans.get(n-i-1);
        }
        return ret;
    }

    public static void main(String[] args) {
        Object a = new Object();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        int[] ans = new Solution().reversePrint(head);
        System.out.println(ans);  // 这样写，返回的结果没用，因为 ans 是一个引用，打印它肯定返回的是 引用地址啊。sout直接打印ArrayList等容器时
        // 之所以可以显示 数据结构，是因为这些类已经重写了 toString方法， 没有重写的话，直接就是返回地址了。
    }

}
