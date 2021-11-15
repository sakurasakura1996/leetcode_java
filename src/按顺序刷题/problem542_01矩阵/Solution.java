package 按顺序刷题.problem542_01矩阵;

import java.util.LinkedList;
import java.util.Queue;

// 计算每个0距离最近的1的距离
public class Solution {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
//                    ans[i][j] = 0; 初始化就是0，没必要赋值了。。
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int k = 0; k < 4; k++) {
                int newX = i + dx[k];
                int newY = j + dy[k];
                if (newX >=0 && newX < m && newY >=0 && newY < n && !visited[newX][newY]) {
                    ans[newX][newY] = ans[i][j] + 1;
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return ans;
    }

    // 相比上面的方法，下面这种解法逻辑对于我更好接受一些， 貌似好像这两个代码是重复一样的啊，哈哈哈，大概懂了，这里是多源BFS，我们把所有的起点都放入队列中去。
    public int[][] updateMatrix2(int[][] matrix) {
        // 这个解法就是有点辐射周围的感觉，首先所有的0四周辐射一步，然后再根据辐射到的1入队列，然后再由他们去辐射四周一步，这种比较好理解。
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
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
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    ans[newX][newY] = ans[x][y] + 1;   //这一步理解好了就行。
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return ans;
    }


}
