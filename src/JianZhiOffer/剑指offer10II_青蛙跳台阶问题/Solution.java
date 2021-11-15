package JianZhiOffer.剑指offer10II_青蛙跳台阶问题;

public class Solution {
    static int MOD = (int) 1e9+7;
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int[] ans = new int[n+1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i < n+1; i++) {
            ans[i] = (ans[i-1] + ans[i-2])%MOD;
        }
        return ans[n];
    }
}
