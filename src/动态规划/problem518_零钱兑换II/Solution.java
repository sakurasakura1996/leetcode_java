package 动态规划.problem518_零钱兑换II;

/**
 * @ClassName Solution
 * @Date 2020/9/29 15:18
 * @Created by sakura
 **/
public class Solution {
    public int change(int amount, int[] coins){
        int n = coins.length;

        int[][] dp = new int[n+1][amount+1];
        // 边界初始化
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < amount+1; j++) {
                if(j-coins[i-1]>=0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];

    }

    public static void main(String[] args) {
//        int[][] dp = new int[2][2];
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                System.out.println(dp[i][j]);
//            }
//        }
//
        Solution solution = new Solution();
        int amount = 3;
        int[] coins = {2};
        int ans = solution.change(amount, coins);
        System.out.println(ans);
    }


}
