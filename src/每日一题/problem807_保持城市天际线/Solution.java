package 每日一题.problem807_保持城市天际线;

/**
 * @author chenz
 * @ClassName Solution
 * @Description TODO
 * @date 2021/12/13-10:47
 */
public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // first calculate the skyline of grid
        int[] rowSkyline = new int[n];
        int[] colSkyline = new int[m];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > rowSkyline[j]) {
                    rowSkyline[j] = grid[i][j];
                }
                if (grid[i][j] > colSkyline[i]) {
                    colSkyline[i] = grid[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] <= rowSkyline[j] && grid[i][j] <= colSkyline[i]) {
                    ans += (Math.min(rowSkyline[j], colSkyline[i]) - grid[i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        int i = new Solution().maxIncreaseKeepingSkyline(grid);
        System.out.println(i);
    }
}
