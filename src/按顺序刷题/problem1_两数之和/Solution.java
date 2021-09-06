package 按顺序刷题.problem1_两数之和;

import java.awt.print.PrinterGraphics;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 简单题直接暴力法解决问题吧，
        int []ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    public int[] twoSum2(int[] nums, int target){
        int[] ans = new int[2];
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])){
                ans[0] = hashtable.get(target - nums[i]);
                ans[1] = i;
                break;
            }else{
                hashtable.put(nums[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums = {3, 2, 4};
        int target = 6;
        Solution solution = new Solution();
        int []ans = solution.twoSum(nums, target);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);

        }
    }
}
