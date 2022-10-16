package 按顺序刷题.problem22_括号生成;

import java.util.*;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 这道题回溯法肯定是可以的，但是比较麻烦，这道题，可以用一个插入的思想，然后用set来存储，去除重复元素。
 * @date 2021/12/15-14:54
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrace(ans, new StringBuffer(), 0, 0, n);
        return ans;
    }

    public void backtrace(List<String> ans, StringBuffer cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        // 我们要思考的是，为什么下面的遍历过程一定都是有效的，因为有效可以归纳成，递归的过程中，总是先加左括号，所以左括号肯定时刻是比右括号多的。
        if (open < max) {
            cur.append('(');
            backtrace(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrace(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length()-1);
        }
    }


}
