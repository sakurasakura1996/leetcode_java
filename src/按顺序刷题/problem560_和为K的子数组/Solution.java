package 按顺序刷题.problem560_和为K的子数组;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] preSum = new int[n+1];
        // 前缀和
        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                if (preSum[j] - preSum[i-1] == k){
                    ans ++;
                }
            }
        }
        return ans;
    }

    public int subarraySum2(int[] nums, int k){
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0, 1);
        int preSum = 0;
        for (int num :
                nums) {
            preSum += num;
            if (hashmap.containsKey(preSum - k)) {
                ans += hashmap.get(preSum - k);
            }
            hashmap.put(preSum, hashmap.getOrDefault(preSum, 0)+1);
        }
        return ans;
    }
}
