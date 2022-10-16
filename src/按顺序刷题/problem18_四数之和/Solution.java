package 按顺序刷题.problem18_四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 数组长度200以内，应该 三次方的时间复杂度都能通过的
 * 这个题目提交了三次都没有通过，我们可以检讨下，这个问题到底自己在做的时候有哪些没考虑到。。。
 * @date 2021/12/14-22:47
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1; j < n-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int cur = target - nums[i] - nums[j];
                int left = j + 1, right = n-1;
                while (left < right) {
                    if (left > j + 1 && nums[left] == nums[left - 1]) {
                        left ++;  // 这里也要left++，不然这里满足条件了，直接continue，那么left和right的值都没有变就会陷入到死循环啊。。。。
                        continue;
                    }
                    if (nums[left] + nums[right] == cur) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        ans.add(temp);
                        left++;   // 这里不应该是 break，比如考虑后两位数的时候，两数目标值是3  [0,1,2,3]，如果 0+3=3以后直接break，那么会漏掉 1+2=3的情况
                    }else if (nums[left] + nums[right] < cur) {
                        left++;
                    } else {
                        right --;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> lists = new Solution().fourSum(nums, target);
        for (List<Integer> list : lists) {
            for (int num : list) {
                System.out.println(num);
            }
        }
    }
}
