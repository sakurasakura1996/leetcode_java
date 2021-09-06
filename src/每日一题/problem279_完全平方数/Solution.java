package 每日一题.problem279_完全平方数;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < (int)Math.sqrt(i)+1; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        int ans = new Solution().numSquares(n);
        System.out.println(ans);
    }
}
