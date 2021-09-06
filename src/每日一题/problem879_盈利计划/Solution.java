package 每日一题.problem879_盈利计划;

public class Solution {
    // 要注意，java不像python，有变量溢出的情况，所以每次更改ans值的时候，我们都要取一次余。
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        int MOD = (int)1e9 + 7;
        
        int[][][] dp = new int[m+1][n+1][minProfit+1];
        dp[0][0][0] = 1;

        for (int i = 1; i < m+1; i++) {
            int members = group[i-1];
            int pro = profit[i-1];
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < minProfit + 1; k++) {
                    if (j < members){
                        dp[i][j][k] = dp[i-1][j][k];
                    }else{
                        dp[i][j][k] = (dp[i-1][j][k] + dp[i-1][j-members][Math.max(0, k-pro)])%MOD;
                    }
                }
            }
            
        }
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            ans = (ans + dp[m][i][minProfit])%MOD;
        }
        return ans;
    }
}
