package 按顺序刷题.problem994_腐烂的橘子;

import java.util.LinkedList;
import java.util.Queue;

// 感觉这个题目还是蛮像昨天做的 01矩阵和 1162地图分析这个题目，把题目意思转换一下，就是希望找到矩阵中 所有1距离自身最近的2的距离中的最大值。
public class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] ans = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int num = 0;   // 用于记录总共有多少个新鲜橘子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    num ++;
                }
            }
        }
        if (num == 0) return 0;   //注意特殊情况，如果一开始就没有新鲜橘子，那么直接返回0哦
        int maxValue = -1;
        int curNum = 0;
        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >=0 && newY < n && grid[newX][newY] == 1 && !visited[newX][newY]) {
                    ans[newX][newY] = ans[x][y] + 1;
                    curNum ++;
                    maxValue = Math.max(maxValue, ans[newX][newY]);
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        if (curNum < num) return -1;
        return maxValue;
    }
}
