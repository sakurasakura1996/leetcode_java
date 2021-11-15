package 每日一题.problem650_只有两个键的键盘;
/* 只支持两种操作，一个是复制全部，一个是粘贴，求最少的操作次数
*  我们考虑如果 n是奇数的话，如果 n = 1，ans = 0，如果 n = 3， ans = 3， 那是不是，后面的奇数情况因为粘贴以后，肯定都是偶数，也不是，比如 9，可以直接复制三个字符的时候，直接粘贴两次，也不一定是偶数
*  那到底是怎么个解法呢     */

public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i < n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);   // 主要是这里的理解有点问题,我们并不用考虑什么当前复制板的内容是什么，
                    // 我们就想做复制板内容更换的时候，肯定要先进行一次复制，那么肯定就会被算进去，就没问题。。。。
                    dp[i] = Math.min(dp[i], dp[i/j] + j);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int ans = new Solution().minSteps(n);
        System.out.println(ans);
    }
}
