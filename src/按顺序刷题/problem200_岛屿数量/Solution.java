package 按顺序刷题.problem200_岛屿数量;

/**
 * @author chenz
 * @ClassName Solution
 * @Description TODO
 * @date 2021/12/16-22:50
 */
public class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    ans ++;
                }
            }
        }
        return ans;

    }

    public void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];
            if (new_x >= 0 && new_x < grid.length && new_y >=0 && new_y < grid[0].length && grid[new_x][new_y] == '1' && !visited[new_x][new_y]) {
                dfs(grid, visited, new_x, new_y);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        int i = new Solution().numIslands(grid);
        System.out.println(i);

    }
    }

