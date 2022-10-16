package 按顺序刷题.problem39_组合总和;

import leetcode周赛.第272周赛.Solution4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 主要考察回溯，看清题目，数组没有重复元素，但是每个元素可以重复使用
 * @date 2021/12/19-21:25
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        backtrace(candidates, new ArrayList<>(), 0, target, 0);
        return ans;

    }

    public void backtrace(int[] candidates, List<Integer> tmp, int sum, int target, int pos) {
        if (sum == target) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum > target) {
                sum -= candidates[i];
                break;
            }
            tmp.add(candidates[i]);
            backtrace(candidates, tmp, sum, target, i);
            tmp.remove(tmp.size()-1);
            sum-=candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = new Solution().combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.println(i);
            }
        }
    }
}
