package 每日一题.problem1734_解码异或后的排列;

public class Solution {
    public int[] decode(int[] encoded) {
        int total = 1;
        int n = encoded.length + 1;
        for (int i = 2; i < n + 1; i++) {
            total ^= i;
        }
        int odd = 0;
        for (int i = 1; i < n-1; i=i+2) {
            odd ^= encoded[i];
        }
        int[] ans = new int[n];
        ans[0] = total ^ odd;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i-1] ^ encoded[i-1];
        }
        return ans;
    }
}
