package problem1_两数之和;

import java.util.HashMap;

/**
 * @ClassName problem1_两数之和
 * @Date 2020/9/17 21:42
 * @Created by sakura
 **/

class Solution {
    public int[] twoSum(int[] nums, int target){

        HashMap<Integer, Integer> hashMap = new HashMap();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length ; i++) {
                hashMap.put(nums[i], i);
            }

        for (int i = 0; i < nums.length ; i++) {
            if (hashMap.containsKey(target-nums[i]) && hashMap.get(target-nums[i])!=i) {
                ans[0] = i;
                ans[1] = hashMap.get(target - nums[i]);
//                return new int[] {i, hashMap.get(target - nums[i])};
            }
        }
        return ans;
    }
}

public class problem1_两数之和 {
    public static void main(String[] args) {
        Solution solu = new Solution();
        int[] nums = new int[] {3, 2, 4};
        int target = 6;
        int[] ans = solu.twoSum(nums, target);
        for (int a: ans) {
            System.out.println(a);
        }
    }

}
