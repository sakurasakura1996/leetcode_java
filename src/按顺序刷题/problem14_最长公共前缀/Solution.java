package 按顺序刷题.problem14_最长公共前缀;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        boolean flag = false;
        for (int i = 0; i < strs[0].length(); i++) {
            String start = strs[0].substring(0, i+1);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() < start.length() || !strs[j].startsWith(start)) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                return ans;
            } else {
                ans = start;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"flower"};
        String s = new Solution().longestCommonPrefix(strs);
        System.out.println(s);
    }
}
