package leetcode动态规划学习计划;

public class problem70 {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int p = 0, q = 1, r = 2;
        for (int i = 3; i <=n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
