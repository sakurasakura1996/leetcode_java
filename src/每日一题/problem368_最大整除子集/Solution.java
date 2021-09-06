package 每日一题.problem368_最大整除子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> a = new ArrayList<>();
            a.add(nums[i]);
            ans.add(a);
        }
        List<Integer> ret = new ArrayList<>();
        ret.add(nums[0]);
        for (int i = 1; i < n ; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && ans.get(j).size()+1 > ans.get(i).size()){
                    List<Integer> b = new ArrayList<>(ans.get(j));
                    b.add(nums[i]);
                    ans.set(i, b);
                    if (ans.get(i).size() > ret.size()){
                        ret = ans.get(i);
                    }
                }
            }

        }
        return ret;
    }
    public static void main(String[] args) {
        int[] nums = {1};
        List<Integer> ans = new Solution().largestDivisibleSubset(nums);
        System.out.println(ans);

    }
}
