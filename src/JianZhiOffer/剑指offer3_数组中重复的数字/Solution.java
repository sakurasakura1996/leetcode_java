package JianZhiOffer.剑指offer3_数组中重复的数字;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 简单点，直接搞一个hashmap来存储，长度上界是 100000，通过是没问题的*/
public class Solution {
    Map<Integer, Integer> hashMap = new HashMap<>();
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(nums[i])) {
                ans = nums[i];
                break;
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        return ans;
    }

    /*用上面的hashmap的时候就想到，其实并不需要用hashmap
    * hashset应该就可以了 只不过不是很熟悉*/
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (hashSet.contains(nums[i])) {
                ans = nums[i];
                break;
            } else {
                hashSet.add(nums[i]);
            }
        }
        return ans;
    }
}
