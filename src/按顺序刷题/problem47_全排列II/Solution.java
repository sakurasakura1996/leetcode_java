package 按顺序刷题.problem47_全排列II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenz
 * @ClassName Solution
 * @Description TODO
 * @date 2021/12/20-18:55
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        backtrace(nums, new ArrayList<>(), 0);
        return ans;

    }

    public void backtrace(int[] nums, List<Integer> tmpList, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1])) {
                continue;
            }
            tmpList.add(nums[i]);
            vis[i] = true;
            backtrace(nums, tmpList, idx+1);
            vis[i] = false;
            tmpList.remove(idx);
        }
    }
}
