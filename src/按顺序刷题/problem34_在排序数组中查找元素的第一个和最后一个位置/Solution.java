package 按顺序刷题.problem34_在排序数组中查找元素的第一个和最后一个位置;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 需要注意的是，左边界比右边界要好写很多，因为又边界需要考虑一些情况，比如target就是数组的最后一个数这种问题， 循环判断也是 left<=right
 * @date 2021/12/16-16:21
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] ans = {-1, -1};
        if (n == 0) return ans;
//        if (n == 1 && nums[0] == target) return new int[] {0,0};
        // 要进行两次二分查找分别寻找左边界和右边界
        while (left < right) {
            // 找左边界
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) return ans;
        ans[0] = left;
        left = 0;
        right = n - 1;
        while (left <= right) {
            // 找右边界
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        ans[1] = left-1;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 7, 7, 8, 8, 10, 10};
        int target = 10;
        int[] ints = new Solution().searchRange(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
