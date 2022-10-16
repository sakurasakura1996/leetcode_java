package leetcode周赛.第271周赛;

/**
 * @author chenz
 * @ClassName Solution2
 * @Description TODO
 * @date 2021/12/12-12:11
 */
public class Solution2 {
    public long subArrayRanges(int[] nums) {
        // 直接暴力，肯定也能解决问题，我看题解还有一个 单调栈的解法，一个动态规划的解法。
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i, right = i + 1;
            int maxValue = nums[left], minValue = nums[left];
            while (right < nums.length) {
                if (nums[right] > maxValue) {
                    maxValue = nums[right];
                }
                if (nums[right] < minValue) {
                    minValue = nums[right];
                }
                ans += (maxValue - minValue);
                right ++;
            }
        }
        return ans;
    }

    public long subArrayRanges2(int[] nums) {
        // 记录下题解中的动态规划， 使用两个矩阵max和min来记录最大值和最小值。max[i][j]存储了nums[i..j]中的最大值
        // 动态规划能解决但是，时间空间复杂度都不是很好啊，只是作为一种思路记录一下吧，这题最好的解法应该是下面的单调栈 O(n)的时间复杂度
        long ans = 0;
        int[][] min_ = new int[nums.length][nums.length];
        int[][] max_ = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            min_[i][i] = nums[i];
            max_[i][i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int min = Math.min(nums[j], min_[i][j-1]);
                int max = Math.max(nums[j], max_[i][j-1]);
                min_[i][j] = min;
                max_[i][j] = max;
                ans += (max - min);
            }
        }
        return ans;
    }

    public long subArrayRanges3(int[] nums) {
        // 使用题解中说的单调栈来解决问题。
        // 我们可以考虑每个元素作为最大值出现在了多少个子数组中，以及作为最小值出现在了多少个子数组中。以最大值为例，我们可以求出nums[i]左侧
        // 严格大于它的最近元素位置left[i]，以及右侧大于等于它的元素位置right[i]。注意nums中可能有重复元素，所以这里右侧取大于等于，这样可以避免
        // 在有重复元素的情况下，重复统计相同的子数组。
        // 单调栈方法感觉好难想，这里就不做了
        long ans = 0;
        return ans;

    }
}
