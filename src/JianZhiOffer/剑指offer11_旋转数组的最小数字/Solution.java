package JianZhiOffer.剑指offer11_旋转数组的最小数字;
/* 最简单的方法，就是遍历一遍，这道题意思是 排序数组进行了旋转，所以肯定有简单方法*/
public class Solution {
    public int minArray(int[] numbers) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < ans) {
                ans = numbers[i];
            }
        }
        return ans;
    }
    /* 数组是有序的，这种问题，多半首先想到的就是二分，这道题目也做过,还做过总结
    * 需要记住的就是，这里是递增的旋转，我们只要和 left比较，如果是递减的，我们就需要和right比较  */
    public int minArray2(int[] numbers) {
        int left = 0, right = numbers.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] >= numbers[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {2, 2, 2, 0, 1};
        int ans = solution.minArray(numbers);
        System.out.println(ans);
    }
}
