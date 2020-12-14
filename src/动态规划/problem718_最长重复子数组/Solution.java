package 动态规划.problem718_最长重复子数组;

/**
 * @ClassName Solution
 * @Date 2020/10/3 14:12
 * @Created by sakura
 **/
public class Solution {
    public int findLength(int[] A, int[] B){
        int n1 = A.length;
        int n2 = B.length;
        int[][] dp = new int[n1+1][n2+1];
        int ans = 0;  // 这里的动态规划还是和我最初的想法不太一样啊。
        // 这里的dp数组设定是：dp[i][j]表示A[:i]和B[:j]以i，j为结尾的公共长度
        // 意思就是，如果A[i-1] != B[j-1] 那dp[i][j]=0

        for (int i = 1; i < n1+1; i++) {
            for (int j = 1; j < n2+1; j++) {
                if (A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {0, 1, 1, 1, 1};
        int[] B = {1, 0, 1, 0, 1};
        int ans = solution.findLength(A, B);
        System.out.println(ans);
    }
}
