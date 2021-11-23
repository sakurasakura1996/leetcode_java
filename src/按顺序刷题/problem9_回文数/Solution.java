package 按顺序刷题.problem9_回文数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        List<Integer> nums = new ArrayList<>();
        while (x!=0) {
            nums.add(x%10);
            x/=10;
        }
        for (int i = 0; i < nums.size()/2; i++) {
            if (nums.get(i) != nums.get(nums.size()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
