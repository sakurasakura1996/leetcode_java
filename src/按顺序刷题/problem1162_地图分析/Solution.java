package 按顺序刷题.problem1162_地图分析;

import java.util.LinkedList;
import java.util.Queue;

// 这道题和 problem542 01矩阵一样的思路就可以了。反正就是矩阵只有0和1，然后求所有的0到最近的1的距离，这道题增加了一问就是其中最大的距离是多少
// 这样我们都不用再用矩阵来存储了，而是每次更新的时候比较下就可以了。
public class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int maxDistance(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int maxDistance = -1;
        // 0到1的距离，那我们就从1开始辐射。。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0 && !visited[newX][newY]){
                    ans[newX][newY] = ans[x][y] + 1;
                    maxDistance = Math.max(maxDistance, ans[newX][newY]);
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return maxDistance;
    }
}
