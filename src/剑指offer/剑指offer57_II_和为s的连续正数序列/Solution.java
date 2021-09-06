package 剑指offer.剑指offer57_II_和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<int[]> ans = new ArrayList<>();
    // 回溯法写的太狗屎了，我都吐了，这就是暴力法，暴力法还比这个写法简单多了呢。
    public int[][] findContinuousSequence(int target){
        for (int i = 1; i < target; i++) {
            backtrace(new ArrayList<>(), i, 0, target);
        }
        return ans.toArray(new int[0][]);
    }

    void backtrace(List<Integer> cur, int idx, int sum, int target){
        // cur表示当前已选的数字序列，idx表示在候选开始的索引位置，sum表示 cur的数字和
        if (sum == target){
            int[] tmp = cur.stream().mapToInt(Integer::valueOf).toArray();
            ans.add(tmp);
        }
        if (sum + idx <= target){
            cur.add(idx);
            idx ++;
            backtrace(cur, idx, sum + idx -1, target);
            return;
        }else{
            return;
        }
    }

    public int[][] findContinuousSequence2(int target){
        // 滑动窗口， 双指针应该是比较好的解法。
        List<int[]> ans = new ArrayList<>();
        int left = 1, right = 2, window = 1;
        while (right < target){
            window += right;
            right ++;
            while (window > target){
                window -= left;
                left ++;
            }
            if (window == target) {
                int[] cur = new int[right-left];
                for (int i = left; i < right; i++) {
                    cur[i-left] = i;
                }
                ans.add(cur);
            }
        }
        return ans.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ans = solution.findContinuousSequence(9);

    }
}
