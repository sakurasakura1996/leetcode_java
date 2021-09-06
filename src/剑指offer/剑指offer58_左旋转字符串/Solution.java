package 剑指offer.剑指offer58_左旋转字符串;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
