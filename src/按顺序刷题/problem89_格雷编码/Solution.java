package 按顺序刷题.problem89_格雷编码;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>(){{add(0);}};
        if (n == 0){
            ans.add(0);
            return ans;
        }else{
            ans.add(0);
            int head = 1;
            // java这种写法还是很不习惯啊
            for (int i = 0; i < n; i++) {
                for (int j = ans.size()-1; j >=0  ; j--) {
                    ans.add(head + ans.get(j));
                }
                head <<= 1;
            }
            return ans;
        }
    }
}
