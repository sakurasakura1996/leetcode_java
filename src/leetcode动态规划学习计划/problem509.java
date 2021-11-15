package leetcode动态规划学习计划;

public class problem509 {
    public int fib(int n) {
        // 注意n=0的情况啊。
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib2(int n) {
        // 上面解法的空间复杂度是O(n)，这道题是完全不需要的,可以用滚动数组的方式来解决,之所以可以这样做的原因还是看递推公式，因为
        // fib(n) = fib(n-1) + fib(n-2) 只和前两项有关，这就是二维dp递推的时候，如果当前只和某一行dp有关，那么也是可以进行压缩的
        if (n < 2) return n;
        int left = 0, mid = 0, right = 1;
        for (int i = 2; i <= n; i++) {
            left = mid;
            mid = right;
            right = left + mid;
        }
        return right;
    }
}
