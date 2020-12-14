package 动态规划.problem887_鸡蛋掉落;

/**
 * @ClassName Solution
 * @Date 2020/10/1 14:08
 * @Created by sakura
 **/
// 这道题的思考过程还是挺复杂的啊，简单的动态规划想法，总是会超时
public class Solution {
    public int superEggDrop(int K, int N){
        int[][] dp = new int[K+1][N+1];

        int m = 0;
        while (dp[K][m] < N){
            m ++;
            for (int i = 1; i <= K; i++) {
                dp[i][m] = dp[i-1][m-1]+1+dp[i][m-1];
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.superEggDrop(4, 5000);
        System.out.println(ans);
    }
}
