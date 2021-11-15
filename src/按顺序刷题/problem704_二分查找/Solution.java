package 按顺序刷题.problem704_二分查找;

public class Solution {
    public int search(int[] nums, int target) {
        int ans = -1, left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return ans;
    }
}
