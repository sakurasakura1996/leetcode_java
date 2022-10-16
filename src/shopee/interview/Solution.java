package shopee.interview;

import java.util.Arrays;

/**
 * @author chenz
 * @ClassName Solution
 * @Description TODO
 * @date 2021/12/10-11:43
 */
public class Solution {
    public int numTaget(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            if (left > 0 && nums[left] == nums[left-1]) {
                left ++;
                right--;
            }
            if (nums[left] + nums[right] == target) {
                ans ++;
                left ++;
                right --;
            } else if (nums[left] + nums[right] < target) {
                left ++;
            } else {
                right --;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 3, 5, 0, 6, 7, 8, -1, 3, 5, 1, 3, 2, 0, 9, 10};
        int target = 6;
        int ans = new Solution().numTaget(nums, target);
        System.out.println(ans);
    }
}
