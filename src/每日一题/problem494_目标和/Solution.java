package 每日一题.problem494_目标和;

public class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target){
        backtrace(nums, target, 0, 0);
        return ans;
    }

    public void backtrace(int[] nums, int target, int index, int summ){
        if (index == nums.length){
            if (summ == target){
                ans ++;
            }
        }else{
            backtrace(nums, target, index+1, summ + nums[index]);
            backtrace(nums, target, index + 1, summ - nums[index]);
        }
    }
}
