package 每日一题.problem13_罗马数字转整数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 通常情况下，罗马数字中小的数字在大的数字的右边。若输入的字符串满足该情况，那么可以将每个字符视作一个单独的值，累加每个字符对应的数值即可。
//例如 XXVII 可视作 X + X + V + I + I
//若存在小的数字在大的数字的左边的情况，根据规则需要减去小的数字。对于这种情况，我们也可以将每个字符视作一个单独的值，若一个数字右侧的数字比它大，则将该数字的符号取反。
//例如 XIV 可视作 X - I + V

public class Solution {
    public int remanToInt(String s){
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<String, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            hashmap.put(str[i], values[i]);
        }
        int i = 0;
        int ans = 0;
        while (i < s.length()){
            String s1 = s.substring(i, i+1);
            if (hashmap.containsKey(s1)){
                if (i+1 < s.length() && hashmap.containsKey(s.substring(i, i+2))){
                    String s2 = s.substring(i, i+2);
                    if (hashmap.get(s2) > hashmap.get(s1)){
                        ans += hashmap.get(s2);
                        i += 2;
                    }

                }else{
                    ans += hashmap.get(s1);
                    i += 1;
                }
            }
        }
        return ans;
    }


    public int romanToInt(String s) {
        // 留意java这里的初始化操作。
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "III";
        int ans = new Solution().remanToInt(s);
        System.out.println(ans);
    }
}
