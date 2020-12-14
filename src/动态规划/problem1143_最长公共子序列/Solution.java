package 动态规划.problem1143_最长公共子序列;

/**
 * @ClassName Solution
 * @Date 2020/10/3 14:39
 * @Created by sakura
 **/
// 这道题和718 最长重复子数组很相似，只不过那道题是需要子元素相邻的，这道题只要求前后顺序是相同的，不要求相邻
public class Solution {
    public int longestCommonSubsequence(String text1, String text2){
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];
        // 边界初始化因为是0，所以不用另写了
        for (int i = 1; i < n1+1; i++) {
            for (int j = 1; j < n2+1; j++) {
                int flag = text1.charAt(i-1) == text2.charAt(j-1) ? 1:0;
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + flag);
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text1 = "abc";
        String text2 = "bdefc";
        int ans = solution.longestCommonSubsequence(text1, text2);
        System.out.println(ans);
    }
}
