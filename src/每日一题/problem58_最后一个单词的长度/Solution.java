package 每日一题.problem58_最后一个单词的长度;

public class Solution {
    public int lengthOfLastWord(String s) {
        String newStr = s.trim();
        int ans = 0;
        for (int i = newStr.length()-1; i >= 0; i--) {
            char c = newStr.charAt(i);
            if (c == ' ') {
                break;
            }
            ans ++;
        }
        return ans;
    }
}
