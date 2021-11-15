package 按顺序刷题.problem3_无重复字符的最长字串;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 该方法以及其编码方式可以好好记住
    public int lengthOfLongestSubstring(String s) {

        Set<Character> hashSet = new HashSet<>();
        int ans = 0, left = 0, right = 0;
        int n = s.length();

        while (right < n) {
            if (!hashSet.isEmpty()) {
                hashSet.remove(s.charAt(left));
                left ++;
            }
            while (right < n && !hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                right ++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        // 使用自己最先想到的滑动窗口来解决问题。
        int left = 0, right = 0, ans = 0;
        if (s == null) {
            return ans;
        }
        Set<Character> hashSet = new HashSet<>();
        while (right < s.length()){
            while (hashSet.contains(s.charAt(right))) {
                hashSet.remove(s.charAt(left));
                left ++;
            }
            hashSet.add(s.charAt(right));
            right ++;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
