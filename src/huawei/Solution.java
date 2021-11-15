package huawei;
/*一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 1 和 0 来表示。

示例 1：

输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
示例 2：

输入：obstacleGrid = [[0,1],[0,0]]
输出：1

提示：
•	m == obstacleGrid.length
•	n == obstacleGrid[i].length
•	1 <= m, n <= 100
•	obstacleGrid[i][j] 为 0 或 1
*/
public class Solution {

    public int waysOfNumber(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        int ans = solution.waysOfNumber(matrix);
        System.out.println(ans);
    }
}
