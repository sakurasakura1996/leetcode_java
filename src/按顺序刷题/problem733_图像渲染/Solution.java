package 按顺序刷题.problem733_图像渲染;

import java.util.LinkedList;
import java.util.Queue;

// 用于练手 BFS的题目，加油
public class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        if (originColor == newColor) return image;  // 这句话必须得加，不然会死循环。。。。但是这个问题是初始就满足情况吗 如果初始旁边元素上值不一样咋办，奥对，不一样就不用改，改的就是相同元素值的。。。
        image[sr][sc] = newColor;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                if (newx >= 0 && newx < image.length && newy >= 0 && newy < image[0].length && image[newx][newy] == originColor) {
                    queue.add(new int[]{newx, newy});
                    image[newx][newy] = newColor;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 1, 2}};
        int sr = 1, sc = 1, newColor = 1;
        int[][] ints = new Solution().floodFill(image, sr, sc, newColor);
        System.out.println(ints);
    }
}
