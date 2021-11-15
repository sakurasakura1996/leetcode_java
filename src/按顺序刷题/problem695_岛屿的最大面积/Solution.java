package 按顺序刷题.problem695_岛屿的最大面积;
// BFS DFS方法的练习
public class Solution {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int cur = dfs(grid, visited, i, j);
                    ans = Math.max(ans, cur);
                }
            }
        }
        return ans;
    }

    public static int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int num = 1;
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1 && !visited[newX][newY]) {
                num += dfs(grid, visited, newX, newY);
            }
        }
        return num;
    }
}
