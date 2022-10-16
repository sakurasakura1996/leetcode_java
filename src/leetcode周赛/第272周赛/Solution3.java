package leetcode周赛.第272周赛;

/**
 * @author chenz
 * @ClassName Solution3
 * @Description TODO
 * @date 2021/12/19-10:45
 */
public class Solution3 {
    public long getDescentPeriods(int[] prices) {
        // 先找到所有的平滑的长度， 比如 [3,2,1,4] 我们可以找到一个平滑长度 3，那么就是prices.length
        if (prices.length == 1) return 1;
        long ans = 0;
        long num = 1;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i-1] - prices[i] == 1) {
                num++;
            } else {
                ans = ans + ((num + 1) * num)/2;
                num = 1;
            }

        }
        ans = ans + ((num + 1) * num)/2;
        return ans - 1;
    }

    public static void main(String[] args) {
        int[] prices = {4, 2, 1, 4};
        long descentPeriods = new Solution3().getDescentPeriods(prices);
        System.out.println(descentPeriods);
    }
}
