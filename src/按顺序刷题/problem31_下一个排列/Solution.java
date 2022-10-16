package 按顺序刷题.problem31_下一个排列;

import java.util.Arrays;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 这题有一个这样的规律，我们从后往前找到一个倒序排列的序列(正向角度看的），然后这个序列的前一个数就会被替换，替换成这个倒序序列里面第一个比这个数大的数。
 * 然后在把剩下的数加这个替换的数顺序排序。
 * @date 2021/12/16-16:53
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for (int i = n-1; i >=0 ; i--) {
            if (i > 0 && nums[i] > nums[i-1]) {
                idx = i;
                break;
            }
        }
        if (idx == 0) {
            Arrays.sort(nums);
            return;
        }
        int cur = nums[idx-1];
        // 找到cur后面第一个比cur大的数。
        for (int i = n-1; i >=idx; i--) {
            if (nums[i] > cur) {
                nums[idx-1] = nums[i];
                nums[i] = cur;
                break;
            }
        }

        // 然后再两两交换 交换 [idx,n-1]区间内的元素
        for (int i = idx; i <= (idx + n-1)/2; i++) {
            int temp = nums[i];
            nums[i] = nums[n-i+idx-1];
            nums[n-i+idx-1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        new Solution().nextPermutation(nums);
        for (int i : nums) {
            System.out.println(i);

        }
    }
}
