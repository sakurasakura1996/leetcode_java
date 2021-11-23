package 按顺序刷题.problem15_三数之和;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; first++){
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            int thrid = n - 1;
            int target = -nums[first];
            for (int second = first+1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second-1]) {
                    continue;
                }
                while (second < thrid && nums[second]+nums[thrid] > target) {
                    --thrid;
                }
                if (second == thrid) {
                    break;
                }
                if (nums[second] + nums[thrid] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[thrid]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            int thrid = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < thrid && nums[second] + nums[thrid] > target) {
                    --thrid;
                }
                if (second == thrid) {
                    break;
                }
                if (nums[second] + nums[thrid] == target) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[first]);
                    tmpList.add(nums[second]);
                    tmpList.add(nums[thrid]);
                    ans.add(tmpList);
                }
            }
        }
        return ans;
    }
}
