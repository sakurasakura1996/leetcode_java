package 按顺序刷题.problem3_无重复字符的最长子串;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 第一想到的就是滑动窗口方法，题眼就是最长子串，子串是连续的，可以用窗口来表示
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int n = s.length();
        int left = 0, right = 0;
        int ans = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while (right < n && left < n){
            if (!hashSet.contains(s.charAt(right))){
                hashSet.add(s.charAt(right));
                right ++;
                ans = Math.max(ans, right - left);
            }else{
                hashSet.remove(s.charAt(left));
                left ++;
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s){
        // 用HashMap来写的，正统滑动窗口来写，看完题解，妈的垃圾代码。
        if(s == null) return 0;
        int n = s.length();
        int left = 0, right = 0, ans = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        while (right < n){
            if (hashMap.containsKey(s.charAt(right))){
                hashMap.replace(s.charAt(right), hashMap.get(s.charAt(right))+1);
                while (hashMap.get(s.charAt(right))>1){
                    if(s.charAt(left)==s.charAt(right)){
                        hashMap.replace(s.charAt(right), hashMap.get(s.charAt(right))-1);
                    }else{
                        hashMap.remove(s.charAt(left));
                    }
                    left ++;
                }
            }else{
                hashMap.put(s.charAt(right), 1);
            }
            right += 1;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s){
        // 用HashSet来写就可以了，前期写java还是多熟悉，精简代码，形成java编码的一些好习惯
        // 下面的代码应该最符合自己的思路，然后这道题告诉我们，滑动窗口也不要太死脑筋，我们不一定非要循环内部先 看right。
        Set<Character> hashSet = new HashSet<>();
        int ans = 0, left = 0, right = 0;
        int n = s.length();

        while (right < n){
            if(!hashSet.isEmpty()){
                hashSet.remove(s.charAt(left));
                left ++;
            }
            while (right < n && !hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.lengthOfLongestSubstring3("pwwkew");
        System.out.println(ans);
    }
}
