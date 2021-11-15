package 每日一题.problem300_最长递增子序列;
/* 这道题可以明显的使用动态规划来解决问题，这里题目的问题就是 dp[i]要以第i个数字结尾来算
*
* 题解中还有一个贪心+二分，懒得看了。。。*/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        int ans = new Solution().lengthOfLIS(nums);
        System.out.println(ans);
    }
}
