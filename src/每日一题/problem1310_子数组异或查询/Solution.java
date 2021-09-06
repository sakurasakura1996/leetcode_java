package 每日一题.problem1310_子数组异或查询;

public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] preSum = new int[n+1];
        int[] ans = new int[queries.length];
        // 前缀异或结果保存起来
        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = preSum[r+1] ^ preSum[l];
        }
        return ans;

    }
}
