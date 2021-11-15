package JianZhiOffer.剑指offer42_连续子数组的最大和;

import java.util.ArrayList;
import java.util.List;

/* 剑指offer给到的是动态规划思路，这道题一看到，想到的是使用滑动窗口来写，那么两种方法都实现一下吧。。。*/
public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        while (left < n && right < n) {
            sum += nums[right++];
            ans = Math.max(ans, sum);
            if (sum < 0) {    // 这道题使用滑动窗口，要记住，只要sum小于0的时候，我们就不要在考虑什么左边界往后滑动了，这一整个区间和是负的，我们还要着它干嘛呢，是吧，直接全部舍弃掉
                left = right;
                sum = 0;
            }
        }
        return ans;
    }

    public int maxSubArray2(int[] nums) {
        // 使用动态规划来做，或者说利用前缀和来计算也行啊。
        int n = nums.length;
        int[] dp = new int[n+1];
        int ans = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n ; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
