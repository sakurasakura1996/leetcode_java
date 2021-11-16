package 按顺序刷题.problem70_爬楼梯;

public class Solution {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // 更高效的方法
    public int climbStairs2(int n) {
        if (n < 3) return n;
        int p = 0, q = 1, r = 2;
        for (int i = 3; i <=n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
