package 按顺序刷题.problem198_打家劫舍;

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        if (n == 3) return Math.max(nums[1], nums[0]+nums[2]);
        int[] dp = new int[n]; // 注意dp[i]表示当前小偷偷了第i户的时候，可以偷盗的最大金额
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
        }
        return Math.max(dp[n-1], dp[n-2]);
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int rob = new Solution().rob(nums);
        System.out.println(rob);
    }
}
