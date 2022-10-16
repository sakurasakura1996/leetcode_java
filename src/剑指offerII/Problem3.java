package 剑指offerII;

/**
 * @author chenz
 * @ClassName Problem3
 * @Description 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * @date 2021/11/24-13:23
 */
public class Problem3 {
    // 直接计算每一个整数的二进制中1的个数
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = calBitNumber(i);
        }
        return ans;
    }

    public int calBitNumber(int x) {
        int num = 0;
        while (x > 0) {
            x &= (x - 1);
            num ++;
        }
        return num;
    }

    // 上面的时间复杂度是O(nlogn),可以有O(n1)解法，还可以用DP来做唉。
    // 思路就是，计算x的二进制中1的个数，可以找到x的二进制中的最高位的1所代表的数y，然后 dp[x] = dp[x-y] + 1
    public int[] countBits2(int n) {
        int[] ans = new int[n+1];
        int y = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i-1)) == 0) {
                y = i;
            }
            ans[i] = ans[i - y] + 1;
        }
        return ans;
    }

    public int[] countBits3(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }
}
