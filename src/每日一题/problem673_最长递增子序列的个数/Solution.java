package 每日一题.problem673_最长递增子序列的个数;
/* 给定一个未排序的整数数组，找到最长递增子序列的个数
* 一看到题目，第一反应还是滑动窗口就能解决吧 ,妈的，看错题目了，说的是递增子序列，并没有要求是连续的啊。。。。那滑动窗口好像并不太行啊
* 那是不是应该用回溯来写呢。自己还是得多用java来写动态规划和回溯的题目啊。。结果是动态规划。。。
*
* 注意啊，子序列并不是连续的*/
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];  // dp[i]用来存储以i结尾的数组，最长子序列的长度
        int[] values = new int[n];  // values[i]表示 nums[i] 结尾的最长上升子序列的个数
        int maxLen = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            values[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        values[i] = values[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        values[i] += values[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = values[i];
            } else if (dp[i] == maxLen) {
                ans += values[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int ans = new Solution().findNumberOfLIS(nums);
        System.out.println(ans);
    }
}
