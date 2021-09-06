package 剑指offer.剑指offer57_和为s的两个数字;

public class Solution {
    public int[] twoSum(int[] nums, int target){
        int n = nums.length;
        int left = 0, right = n-1;
        int[] ans = new int[2];
        while (left <= right){
            int tmp = nums[left] + nums[right];

            if (tmp == target){
                ans[0] = nums[left];
                ans[1] = nums[right];
                break;
            } else if (tmp < target){
                left ++;
            } else{
                right --;
            }
        }
        return ans;
    }
}
