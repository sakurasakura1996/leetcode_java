package 每日一题.problem1221_分割平衡字符串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int balancedStringSplit(String s) {
        /*感觉直接用贪心应该能解决问题*/
//        Map<Character, Integer> map = new HashMap<>();
//        map.put('L', 0);
//        map.put('R', 0);
        // 三个月没刷题，你怕不是呆了，这个题目还用什么map来存储啊，大兄弟，直接用两个变量存储 L， R的数量不就行了
        // 或者使用一个变量记录 L R数量之差那就更精妙了。。
        int ans = 0;
        int lCount = 0;
        int rCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                lCount ++;
            } else {
                rCount ++;
            }
            if (lCount == rCount) {
                ans ++;
            }
        }
        return ans;
    }

    public int balancedStringSplit2(String s) {
        int ans = 0;
        int interval = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                interval --;
            } else {
                interval ++;
            }
            if (interval == 0) {
                ans ++;
            }
        }
        return ans;
    }
}
