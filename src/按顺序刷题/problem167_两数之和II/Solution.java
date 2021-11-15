package 按顺序刷题.problem167_两数之和II;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 双指针试试
        int left = 0, right = numbers.length-1;
        int[] ans = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right --;
            } else {
                left ++;
            }
        }
        return ans;
    }
}
