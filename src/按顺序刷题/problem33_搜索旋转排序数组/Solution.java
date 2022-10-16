package 按顺序刷题.problem33_搜索旋转排序数组;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 还是二分搜索的问题。
 * @date 2021/12/16-22:09
 */
public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target? 0 : -1;
        int left = 0, right = n-1;
        while (left <= right) {   //这里为什么要加等于号
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                // 说明mid在左半边
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;   // 为什么这里要加一
                }
            } else {
                if (nums[mid] < target && target <= nums[n-1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;  // 为什么这里要减一。还是搞不太懂啊
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int search = new Solution().search(nums, target);
        System.out.println(search);
    }
}
