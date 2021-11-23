package 按顺序刷题.problem16_最接近的三数之和;

import java.util.Arrays;

// 直接遍历了first以后，直接开始双指针即可。
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 10000000;
        for (int first = 0; first < n; ++first) {
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            int thrid = n - 1;
            int second = first + 1;
            while (second < thrid) {
                int sum = nums[first] +nums[second] + nums[thrid];
                if (sum == target) return target;
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    int thrid2 = thrid - 1;
                    while (second < thrid2 && nums[thrid2] == nums[thrid]) {
                        --thrid2;
                    }
                    thrid = thrid2;
                } else {
                    int second2 = second + 1;
                    while (second2 < thrid && nums[second2] == nums[second]) {
                        ++second2;
                    }
                    second = second2;
                }
            }
        }
        return ans;
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;
        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }


    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        int i = new Solution().threeSumClosest(nums, target);
        System.out.println(i);
    }
}
