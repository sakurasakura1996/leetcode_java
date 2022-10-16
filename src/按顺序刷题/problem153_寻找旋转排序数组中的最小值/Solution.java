package 按顺序刷题.problem153_寻找旋转排序数组中的最小值;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 这个问题肯定还是二分查找的方法，要知道 这个旋转数组是两段有序的数组，还是可以用二分的
 * @date 2021/12/18-19:43
 */
public class Solution {
    public int finMin(int[] nums) {
        int left = 0, right = nums.length-1;
        if (nums[0] < nums[right]) {
            return nums[0];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }


    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1;
        if(nums[0] < nums[right]) {
            return nums[0];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[0] <= nums[mid]) {  // 这里必须加等于号，比如 [2,1]这个样例，如果不加等于号就错了
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
