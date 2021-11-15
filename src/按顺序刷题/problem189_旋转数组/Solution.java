package 按顺序刷题.problem189_旋转数组;

import javax.print.event.PrintEvent;

public class Solution {
    public void rotate(int[] nums, int k) {
        // 直接搞一个数组
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        // 空间复杂度为O(1)的算法
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
