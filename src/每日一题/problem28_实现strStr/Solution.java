package 每日一题.problem28_实现strStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null){
            return 0;
        }
        int n1 = haystack.length();
        int n2 = needle.length();

        for (int i = 0; i < n1 - n2 + 1; i++) {
            if(haystack.substring(i, i+n2).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "heello";
        String needle = "el";
        int ans = solution.strStr(haystack, needle);
        System.out.println(ans);
    }
}
