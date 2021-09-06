package 每日一题.problem377_组合总和IV;

public class Solution {
    public int combinationSum4(int[] nums, int target){
        int n = nums.length;

        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target ; i++) {
            for (int num :
                    nums) {
                if (num <= i){
                    dp[i] += dp[i-num];
                }
            }

        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int target = 4;
        int ans = solution.combinationSum4(nums, target);
        System.out.println(ans);
    }
}
