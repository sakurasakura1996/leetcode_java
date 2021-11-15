package JianZhiOffer.剑指offer53;

public class Solution {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    /* 是不是可以再快一些呢， 二分法应该是可以的，利用 nums[i] == i 来判断即可*/
    public int missingNumber2(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                // 说明之前的都还没有问题
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
