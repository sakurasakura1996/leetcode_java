package 剑指offer.剑指offer03_数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hashset.contains(nums[i])){
                ans = nums[i];
                break;
            }else{
                hashset.add(nums[i]);
            }
        }
        return ans;
    }
}
