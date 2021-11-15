package 每日一题.problem38_外观数列;

public class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            ans = count(ans);
        }
        return ans;
    }

    public static String count(String str) {
        int len = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        int num = 1;
        char temp = str.charAt(0);
        for (int i = 1; i < len; i++) {
            if (str.charAt(i) == temp) {
                num ++;
            } else {
                // 写入
                stringBuilder.append(num);
                stringBuilder.append(temp);
                num = 1;
                temp = str.charAt(i);
            }
        }
        stringBuilder.append(num);
        stringBuilder.append(temp);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().countAndSay(1);
        System.out.println(s);
    }
}
