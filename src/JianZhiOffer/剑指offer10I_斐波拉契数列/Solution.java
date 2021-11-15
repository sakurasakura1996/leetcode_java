package JianZhiOffer.剑指offer10I_斐波拉契数列;

public class Solution {
    static int MOD = 1000000007;
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fib(n-1) + fib(n-2))%MOD;
    }

    public int fib2(int n) {
        // 递归容易爆，还是动态规划好一些。
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] ans = new int[n+1];
        ans[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            ans[i] = (ans[i-1] + ans[i-2])%MOD;
        }
        return ans[n];
    }
}
