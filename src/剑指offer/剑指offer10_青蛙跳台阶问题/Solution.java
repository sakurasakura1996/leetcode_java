package 剑指offer.剑指offer10_青蛙跳台阶问题;

public class Solution {
    public int numWays(int n){
        int MOD = (int)1e9+7;
        int[] dp = new int[n+1];
        if (n==0) return 1;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%MOD;
        }
        return dp[n];
    }
}
