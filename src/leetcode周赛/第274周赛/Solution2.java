package leetcode周赛.第274周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz
 * @ClassName Solution2
 * @Description TODO
 * @date 2022/1/2-11:04
 */
public class Solution2 {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < bank.length; i++) {
            int num = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    num++;
                }
            }
            if (num > 0) {
                nums.add(num);
            }
        }
        for (int i = 0; i < nums.size()-1; i++) {
            ans += (nums.get(i) * nums.get(i+1));
        }
        return ans;
    }
}
