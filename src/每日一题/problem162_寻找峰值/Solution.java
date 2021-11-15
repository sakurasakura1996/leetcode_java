package 每日一题.problem162_寻找峰值;
/* 题目要求使用 O(logn)的时间复杂度来解决问题。找到任意一个峰值的位置索引 */
public class Solution {
    public int findPeakElement(int[] nums) {
        // 感觉还是可以通过二分来做
        if (nums.length == 1) return 0;
        else if (nums[0] > nums[1]) return 0;
        else if (nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        int left = 1, right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if (nums[mid] > nums[mid -1] && nums[mid] < nums[mid+1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2,3, 1};
        int ans = solution.findPeakElement(nums);
        System.out.println(ans);
    }
}
