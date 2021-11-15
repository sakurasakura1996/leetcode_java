package 按顺序刷题.problem77_组合;

import java.util.ArrayList;
import java.util.List;
// 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 你可以按 任何顺序 返回答案。
// 这道题是标准的 回溯算法，python以前写这道题很简单，java还是得好好熟悉
public class Solution {
    static List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i+1);
        }
        ans.clear();  //注意，因为ans是全局的，多组样例会一直往ans里面添加，所以不行。
        backtrace(new ArrayList<Integer>(), nums, 0, k);
        return ans;
    }

    public static void backtrace(List<Integer> cur, List<Integer> nums, int start, int num) {
        if (num == 0) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            cur.add(nums.get(i));
            backtrace(cur, nums, i+1, num-1);
            cur.remove(nums.get(i));
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> combine = new Solution().combine(n, k);
    }
}
