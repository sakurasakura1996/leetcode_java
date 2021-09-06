package 剑指offer.剑指offer21_调整数组顺序使奇数位于偶数前面;

public class Solution {
    public int[] exchange(int[] nums){
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right){
            while (left < n && nums[left] % 2 == 1){
                left ++;
            }
            while (right >= 0 && nums[right] % 2 == 0){
                right --;
            }
            if (left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5};
        int[] ans = solution.exchange(nums);
        System.out.println(ans);
    }
}
