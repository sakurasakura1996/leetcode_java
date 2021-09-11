package JianZhiOffer.剑指offer06_从尾到头打印链表;

/*链表长度 0-10000 */
import JianZhiOffer.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
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
}
