package shopee;

import java.util.Arrays;

public class Problem3 {
    public int pickGoods(int[] goods_list, int balance) {
        // write code here
        // 最后十分钟给debug找到问题的关键了，应该给 goods_list排个序就好了。。。因为前面数据大了，就不算了。反正debug一下就知道如果不排序的问题
        // 出在哪里了。
        Arrays.sort(goods_list);
        int[][] dp = new int[goods_list.length+1][balance+1];

        for (int i = 1; i <= goods_list.length; i++) {
            for (int j = 1; j <= balance ; j++) {
                if (goods_list[i-1] > j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-goods_list[i-1]] + goods_list[i-1], dp[i][j]);
                }
            }
        }
        return dp[goods_list.length][balance];
    }


    public static void main(String[] args) {
        int[] goods = {15, 8, 2};
        int balance = 16;
        int i = new Problem3().pickGoods(goods, balance);
        System.out.println(i);

    }
}
