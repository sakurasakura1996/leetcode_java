package 按顺序刷题.problem120_三角形最小路径和;

import java.util.ArrayList;
import java.util.List;

// 进阶：使用 O(n)的空间复杂度来解决问题，n为三角形行数
// 使用O(n)的空间复杂度也不难，思考动态规划的递推过程。只需要存上面一层的数据就可以了。
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        if (n == 1) return triangle.get(0).get(0);
        dp.add(new ArrayList<Integer>());
        dp.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i < n; i++) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0) {
                    // 只能从和自己纵坐标相同的点走到
                    tmpList.add(dp.get(i-1).get(j)+triangle.get(i).get(j));
                } else if (j == i){
                    tmpList.add(dp.get(i-1).get(j-1) + triangle.get(i).get(j));
                } else {
                    tmpList.add(Math.min(dp.get(i-1).get(j-1), dp.get(i-1).get(j)) + triangle.get(i).get(j));
                }
            }
            dp.add(tmpList);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp.get(n-1).get(i) < ans) {
                ans = dp.get(n-1).get(i);
            }
        }
        return ans;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = i; j >=0; j--) {
                // from end to start
                if (j == i) {
                    dp[j] = dp[j-1] + triangle.get(i).get(j);
                } else if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j-1], dp[j]) + triangle.get(i).get(j);
                }

            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}
