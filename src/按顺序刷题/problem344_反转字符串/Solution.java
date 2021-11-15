package 按顺序刷题.problem344_反转字符串;

public class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new Solution().reverseString(s);
        for (char ch :
                s) {
            System.out.println(ch);
        }
    }
}
