package leetcode动态规划学习计划;
/* 第N个泰波那契数 */
public class problem1137 {
    public int tribonacci(int n) {
        if (n < 2) return n;
        int n1 = 0, n2 = 0, n3 = 0, n4 = 1;
        for (int i = 2; i <= n ; i++) {
            n1 = n2;
            n2 = n3;
            n3 = n4;
            n4 = n1 + n2 + n3;
        }
        return n4;
    }
}
