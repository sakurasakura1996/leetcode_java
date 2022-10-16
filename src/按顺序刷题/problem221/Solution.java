package 按顺序刷题.problem221;

public class Solution {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] nums = new int[m][n];
        int ans = 0;
        // 边界情况
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1'){
                nums[i][0] = 1;
                ans = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1'){
                nums[0][i] = 1;
                ans = 1;
            }
        }
        // 循环
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }else if (nums[i-1][j-1] == 0) {
                    nums[i][j] = 1;
                    ans = Math.max(ans, 1);
                } else {
                    int w = 0;
                    int l = 0;
                    for (int k = i; k >= i - nums[i-1][j-1]; k--) {
                        if (matrix[k][j] == '1'){
                            w++;
                        } else {
                            break;
                        }
                    }
                    for (int k = j; k >= j - nums[i-1][j-1] ; k--) {
                        if (matrix[i][k] == '1'){
                            l ++;
                        } else {
                            break;
                        }
                    }
                    nums[i][j] = Math.min(l, w);
                    ans = Math.max(ans, Math.min(l,w));

                }
            }
        }
        return ans * ans;

    }
}
