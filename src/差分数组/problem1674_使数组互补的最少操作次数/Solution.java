package 差分数组.problem1674_使数组互补的最少操作次数;
/* 这道题，晃着一看，我想到的方法应该是二分搜索法，因为 nums[i]+nums[n-1-i] = x
* 这个x是多少啊，不知道，我们可以确定它的范围是 2 ~ 2 * limit 那么是不是可以使用二分搜索来搜索呢
* 想了想，肯定不能这样做，应为二分的前提是有序的，x 越小不代表互补的操作次数越少，所以二分没用
*
* 还是在先验知识基础上，应该使用差分数组来解决问题。这道题很难说直接想到要用差分数组来做，而且，这道题也没有使用差分数组的
* 题眼，数组区间进行加减这样的提示，更多的，这道题使用差分数组是为了降低复杂度，在解题过程中发现可以用差分数组来简化
*
* */
public class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] val = new int[2 * limit + 2];
        int n = nums.length;
        for (int i = 0; i < n/2; i++) {
            range(val, nums[i], nums[n-1-i], limit);
        }
        int sum = 0, ans = Integer.MAX_VALUE;
        for (int i = 2; i < 2*limit+1; i++) {
            sum += val[i];
            if (sum < ans) {
                ans = sum;
            }
        }
        return ans;
    }

    public static void range(int[] val, int left, int right, int limit) {
        // [limit, 2*limit]之前的，只需要操作一次就可以了。 [A,B]为0次，其余操作需要2次了
        val[2] += 2;
        val[2*limit+1] -= 2;
        val[1+Math.min(left, right)] -= 1;
        val[limit+Math.max(left, right)+1] += 1;
        val[left+right] -= 1;
        val[left+right+1] += 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 4, 3};
        int limit = 4;
        int ans = solution.minMoves(nums, limit);
        System.out.println(ans);
    }
}
