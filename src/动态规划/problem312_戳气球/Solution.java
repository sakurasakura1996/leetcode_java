package 动态规划.problem312_戳气球;

import java.util.HashMap;

/**
 * @ClassName Solution
 * @Date 2020/10/2 10:38
 * @Created by sakura
 **/
public class Solution {
    public int maxCoins(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        int[] val = new int[n+2];
        val[0] = 1;
        val[n+1] = 1;
        for (int i = 1; i < n+1; i++) {
            val[i] = nums[i-1];
        }
        // 下面的边界具体是多少一定要注意。
        for (int i = n; i > -1 ; i--) {
            for (int j = i+1; j < n+2; j++) {

                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + val[i]*val[k]*val[j]);
                }
            }
        }
        return dp[0][n+1];
    }


    HashMap<int[], Integer> hashMap = new HashMap<int[], Integer>();
    int[] val;

    public int maxCoins2(int[] nums){
        //采用反向思考的方法，将戳气球变为向其中加入气球
        int n = nums.length;
        int[] val = new int[n+2];
        val[0] = val[n+1] = 1;
        for (int i = 1; i < n+1; i++) {
            val[i] = nums[i - 1];
        }

        return 2;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        Solution solution = new Solution();
        int ans = solution.maxCoins(nums);
        System.out.println(ans);

    }
}
