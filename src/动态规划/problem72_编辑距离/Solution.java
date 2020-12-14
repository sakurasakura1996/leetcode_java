package 动态规划.problem72_编辑距离;

/**
 * @ClassName Solution
 * @Date 2020/9/30 20:33
 * @Created by sakura
 **/
public class Solution {
    public int minDistance(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i-1] + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                int diff = word1.charAt(i-1) == (word2.charAt(j-1)) ? 0:1;
                dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j-1]+1);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+diff);
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "intention";
        String word2 = "execution";
        int ans = solution.minDistance(word1, word2);
        System.out.println(ans);
    }
}
