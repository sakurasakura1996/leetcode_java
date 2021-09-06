package 每日一题.problem264_丑数II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1){
            return 1;
        }
        List<Integer> ans = new ArrayList<>();
        int p2 = 0, p3 = 0, p5 = 0;
        ans.add(1);
        int cur = 1;
        while (cur < n){
            int tmp = Math.min(2 * ans.get(p2), Math.min(3 * ans.get(p3), 5 * ans.get(p5)));
            if (tmp == 2 * ans.get(p2)){
                p2 += 1;
            }
            if (tmp == 3 * ans.get(p3)){
                p3 += 1;
            }
            if (tmp == 5 * ans.get(p5)){
                p5 += 1;
            }
            cur += 1;
            ans.add(tmp);
        }
        return ans.get(ans.size()-1);
    }
}
