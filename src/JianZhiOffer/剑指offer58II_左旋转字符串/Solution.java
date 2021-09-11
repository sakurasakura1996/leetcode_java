package JianZhiOffer.剑指offer58II_左旋转字符串;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        int l = s.length();
        return s.substring(n, l) + s.substring(0, n);
    }
}
