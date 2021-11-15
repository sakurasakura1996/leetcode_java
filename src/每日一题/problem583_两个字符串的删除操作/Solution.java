package 每日一题.problem583_两个字符串的删除操作;
/* 这道题目，等同于考察的是，两个字符串的最长公共子序列 ，然后直接用两个字符串的长度 - 2 * 最长公共子序列长度 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return word1.length() + word2.length();
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        // dp[i][j] 表示的是 字符串word1 0-i区间内的字符串，和 word2 0-j区间内的字符串的最长公共子序列长度
        for (int i = 1; i <= m; i++) {
            char a = word1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char b = word2.charAt(j-1);
                if (a == b) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }
        int len = dp[m][n];
        return m + n - 2 * len;
    }
}



