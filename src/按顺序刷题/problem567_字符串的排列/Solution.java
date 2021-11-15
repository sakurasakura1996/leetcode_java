package 按顺序刷题.problem567_字符串的排列;
// 判断s2 是否包含s1的排列，意思是s1的任意排列，只有s2中有就是true，但是前提这个排列在s2中是连续的。即 s1的排列之一是s2的子串

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 第一时间自己想到的方法是，滑动s2
public class Solution {
    // note:注意哈，下面这个解答是错的，绝不能通过diff==0来判断啊，随便举个例子都会是错的。。。。卧槽，好像也不是，我看到题解也有思想相同的算法。。。好好琢磨一下。。。
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) return false;
        Map<Character, Integer> hashMap1 = new HashMap<>();
        Map<Character, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < l1; i++) {
            hashMap1.put(s1.charAt(i), hashMap1.getOrDefault(s1.charAt(i), 0)+1);
            hashMap2.put(s2.charAt(i), hashMap2.getOrDefault(s2.charAt(i), 0)+1);
        }
        int left = 0, right = l1;
        int diff = 0; // 用diff来记录两个hashMap中不同的数目
        for (Map.Entry<Character, Integer> entry : hashMap1.entrySet()){
            if (hashMap2.containsKey(entry.getKey()) && hashMap2.get(entry.getKey()) == entry.getValue()) {
                continue;
            } else {
                diff++;
            }
        }
        if (diff == 0) return true;
        while (right < l2) {
            char charRight = s2.charAt(right);
            char charLeft = s2.charAt(left);
            if ( hashMap1.getOrDefault(charRight, 0) == hashMap2.getOrDefault(charRight, 0)) {
                diff++;
            } else if (hashMap2.getOrDefault(charRight, 0) + 1 == hashMap1.getOrDefault(charRight, 0)) {
                diff --;
            }
            hashMap2.put(charRight, hashMap2.getOrDefault(charRight, 0)+1);
            if ( hashMap1.getOrDefault(charLeft, 0) == hashMap2.getOrDefault(charLeft, 0)) {
                diff++;
            } else if (hashMap2.getOrDefault(charLeft, 0) - 1 == hashMap1.getOrDefault(charLeft, 0)) {
                diff --;
            }
            hashMap2.put(charLeft, hashMap2.get(charLeft)-1);
            right ++;
            left ++;
            if (diff == 0) return true;
        }

        return false;
    }

    // 滑动窗口方法 该方法还是没有通过所有的，很奇怪。。。。
    public boolean checkInclusion2(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) return false;
        Map<Character, Integer> hashMap1 = new HashMap<>();
        Map<Character, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < l1; i++) {
            hashMap1.put(s1.charAt(i), hashMap1.getOrDefault(s1.charAt(i), 0)+1);
            hashMap2.put(s2.charAt(i), hashMap2.getOrDefault(s2.charAt(i), 0)+1);
        }
        int left = 0, right = l1;
        if (check(hashMap1, hashMap2)) return true;
        while(right < l2) {
            hashMap2.put(s2.charAt(right), hashMap2.getOrDefault(s2.charAt(right), 0) + 1);
            hashMap2.put(s2.charAt(left), hashMap2.get(s2.charAt(left))-1);
            right++;
            left++;
            if (check(hashMap1, hashMap2)) {
                return true;
            }
        }
        return false;
    }

    public boolean check(Map<Character, Integer> hashMap1, Map<Character, Integer> hashMap2) {
        for (Map.Entry<Character, Integer> entry: hashMap1.entrySet()) {
            if (hashMap2.getOrDefault(entry.getKey(), 0) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    // 题解解答，使用int[]数组确实更加简单迅速一下，这里比hashmap肯定是要更好的
    // 这里可以进行简化，首先每次判断我们都要判断一整个cnt数组，未免麻烦了，可以只用一个
    // cnt数组来存储26个字符的数目差值，所以等于0的时候表示该字符，s1和s2是一样多的。
    // 然后在用diff来表示cnt数组中不等于0的个数，只有diff==0的时候，就表示找到答案了，return true
    public boolean checkInclusion3(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {  // Arrays这个包可以直接判断。。。
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    // 该题解方法，使用双指针滑动窗口方法，同样只使用一个cnt数组，
    public boolean checkInclusion4(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean b = new Solution().checkInclusion2(s1, s2);
        System.out.println(b);
    }
}
