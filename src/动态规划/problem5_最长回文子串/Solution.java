package 动态规划.problem5_最长回文子串;

/**
 * @ClassName Solution
 * @Date 2020/10/7 11:07
 * @Created by sakura
 * 分析：使用动态规划来解，dp数组的定义是 dp[i]表示字符串前i个字符中以第i个字符结尾的最长的回文串的长度。
 * 这样，如果以第(i-1)个字符结尾的回文串存在，那么就判断第i个字符和第(i-dp[i-1]-1)个字符是否相同，如果相同，最大回文串长度+2
 * 如果不相同的话，那么就不能用上dp[i-1]的回文串了，那么判断i和i-1是否相同，相同还可以为2，否则就只有自己为1
 **/
public class Solution {
    public String longestPalindrome(String s){
        // 这里的代码没有考虑到“ccc”这样的字符串啊。那我这样的想法是不能解决问题的吗？得用二维吗？应该是得用二维的数组来做。
        if (s.equals("")){
            return s;
        }
        int max = 0;
        int idx = 0;
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            char ch = s.charAt(i-1);
            if (dp[i-1] == 0){
                dp[i] = 1;
            }else{
                if((i-2-dp[i-1])>=0 && (ch == s.charAt(i-2-dp[i-1]))){
                    dp[i] = dp[i-1] + 2;
                }else{
                    if(ch == s.charAt(i-2)){
                        dp[i] = 2;
                    }else{
                        dp[i] = 1;
                    }
                }
            }
            if (dp[i] > max){
                max = dp[i];
                idx = i;
            }
        }
        return s.substring(idx-max, idx);
    }

    public String longestPalindrome_2(String s){
        // 同样的写法，用java还算通过了，python显示超时了啊。。。。

        int n = s.length();
        if (n < 2){
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        char[] charArray = s.toCharArray();
        String ans = "";

        for (int i = n-1; i > -1 ; i--) {  // 注意递推公式的顺序，因为 （i,j) 需要用到 （i+1,j-1)，所以要斜向遍历或者i从下到上，j从左到右
            for (int j = i; j < n; j++) {
                if (j-i == 0){
                    dp[i][j] = true;
                }else if (j - i == 1){
                    dp[i][j] = (charArray[i] == charArray[j]);
                }else{
                    dp[i][j] = (dp[i+1][j-1] && charArray[i] == charArray[j]);
                }
                if (dp[i][j] && ans.length() < (j - i + 1)){
                    ans = s.substring(i, j+1);
                }

            }

        }
        return ans;

    }
    public static void main(String[] args) {
        String s = "babad";
        Solution solution = new Solution();
        String ans = solution.longestPalindrome(s);
        System.out.println(ans);

    }
}
