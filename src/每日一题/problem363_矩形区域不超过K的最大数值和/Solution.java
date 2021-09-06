package 每日一题.problem363_矩形区域不超过K的最大数值和;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k){
        // firstly， calculate the prefix sum
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m+1][n+1];
        int ans = Integer.MIN_VALUE;
        // 边界初始化
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = i ; l <= m; l++) {
                    for (int o = j; o <= n; o++) {
                        int temp = prefix[l][o] - prefix[l][j-1] - prefix[i-1][o] + prefix[i-1][j-1];
                        if (temp <= k && temp > ans){
                            ans = temp;
                        }
                    }
                }
            }
        }

    return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{2,2,-1}};
        int k = 0;
        int ans = solution.maxSumSubmatrix(matrix, k);
        System.out.println(ans);
    }
}
