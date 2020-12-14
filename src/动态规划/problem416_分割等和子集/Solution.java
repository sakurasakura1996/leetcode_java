package 动态规划.problem416_分割等和子集;

/**
 * @ClassName Solution
 * @Date 2020/9/29 11:00
 * @Created by sakura
 **/
class Solution{
    public boolean canPartition(int[] nums){
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum%2 != 0){
            return false;
        }
        boolean[][] dp = new boolean[n+1][sum/2+1];
//      初始化边界
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum/2; j++) {
                if (j - nums[i-1] >= 0){
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum/2];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 5, 11, 5};
        boolean ans = solution.canPartition(nums);
        System.out.println(ans);
    }
}
