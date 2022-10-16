package 按顺序刷题.problem40_组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 区别组合总和那道题，这道题不能使用同一个元素，但是数组中是有相同数字的奥
 * @date 2021/12/19-21:48
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, new ArrayList<>(), target, 0, 0);
        return ans;
    }

    public void backtrace(int[] candidates, List<Integer> tmpList, int target, int sum, int pos) {
        if (sum == target) {
            ans.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (i > pos && candidates[i] == candidates[i-1]){
                continue;
            }
            sum += candidates[i];
            if (sum > target) {
                sum -= candidates[i];
                break;
            }
            tmpList.add(candidates[i]);
            backtrace(candidates, tmpList, target, sum, i+1);
            tmpList.remove(tmpList.size()-1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = new Solution().combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.println(i);
            }
        }
    }
}
