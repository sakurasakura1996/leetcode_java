package 按顺序刷题.problem73_矩阵置零;

/**
 * @author chenz
 * @ClassName Solution
 * @Description TODO
 * @date 2021/12/19-22:19
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] > 0 || cols[j] > 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
