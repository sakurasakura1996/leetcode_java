package 按顺序刷题.problem300_最长递增子序列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 最长递增子序列，子序列并不是子数组，是可以不连续的。
 * @date 2021/12/19-13:31
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int size = nums.length;
        for (int i = 1; i < nums.length; i++) {
            int left = 0, right = list.size() - 1;
            if (nums[i] > list.get(right)) {
                list.add(nums[i]);
            } else {
                // 利用二分来插值
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (list.get(mid) < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(left, nums[i]);
            }

        }
        return list.size();
    }

    public int lengthOfLIS2(int[] nums) {
        // 动态规划方法
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
    }
    return maxans;}

    public static void main(String[] args) {
        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
        int ans = new Solution().lengthOfLIS(nums);
        System.out.println(ans);
    }
}
