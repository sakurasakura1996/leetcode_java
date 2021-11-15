package 按顺序刷题.problem46_全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrace(ans, nums, new ArrayList<Integer>(), visited);
        return ans;

    }

    public void backtrace(List<List<Integer>> ans, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrace(ans, nums, tmp, visited);
            visited[i] = 0;   //backtrace完以后，一定要记得还原现场哈哈。
            tmp.remove(tmp.size()-1);
        }
    }
}
