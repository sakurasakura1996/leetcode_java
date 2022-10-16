package 每日一题.problem419_甲板上的战舰;

/**
 * @author chenz
 * @ClassName Solution
 * @Description TODO
 * @date 2021/12/18-19:26
 */
public class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && !visited[i][j]){
                    dfs(board, visited, i, j);
                    ans ++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] board, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];
            if (new_x >= 0 && new_x < board.length && new_y >=0 && new_y < board[0].length && board[new_x][new_y] == 'X' && !visited[new_x][new_y]) {
                dfs(board, visited, new_x, new_y);
            }
        }
    }

}
