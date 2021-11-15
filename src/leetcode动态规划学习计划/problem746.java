package leetcode动态规划学习计划;
/* 使用最小花费爬楼梯
* 相当于爬上不同的楼梯需要花费的力气是不一样的。*/
public class problem746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len+1];
        // 边界初始化 dp[0] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }
        return dp[len];
    }
}
