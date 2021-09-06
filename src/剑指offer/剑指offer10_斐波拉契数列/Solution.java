package 剑指offer.剑指offer10_斐波拉契数列;

public class Solution {
    public int fib(int n){
        int MOD = (int)1e9+7;
        int[] dp = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            if (i == 0){
                dp[i] = 0;
            }else if (i == 1){
                dp[i] = 1;
            }else{
                dp[i] = (dp[i-1] + dp[i-2])%MOD;
            }
        }
        return dp[n];
    }
}
