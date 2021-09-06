package 每日一题.problem1269_停在原地的方案数;

//递归 + 记忆化搜索(数组别开太大，减少Math.min((steps/2)+1, arrLen)的计算次数，13ms)
public class Solution {
    int[][] men = null;
    int mod = (int) 1e9 + 7;
    int x = 0;
    public int numWays(int steps, int arrLen) {
        x = Math.min((steps/2)+1, arrLen);//最多能走到的地方
        men = new int[x][steps];
        return dfs(steps, arrLen, 0, 0);
    }

    public int dfs(int steps, int arrLen, int curIndex, int curStep) {
        if (curStep == steps) {
            if (curIndex == 0) {
                return 1;
            }
            return 0;
        }
        //走太远回不来，不用继续遍历了
        if (curIndex >= x) {
            return 0;
        }
        if (men[curIndex][curStep] > 0) {
            return men[curIndex][curStep];
        }else if (men[curIndex][curStep] < 0){
            return 0;
        }
        curStep += 1;
        int way = 0;
        if (curIndex != 0) {
            way += dfs(steps, arrLen, curIndex - 1, curStep);
            way %= mod;
        }
        way += dfs(steps, arrLen, curIndex, curStep);
        way %= mod;
        if (curIndex != arrLen - 1) {
            way += dfs(steps, arrLen, curIndex + 1, curStep);
            way %= mod;
        }
        men[curIndex][curStep - 1] = way == 0 ? -1 : way;
        return way;
    }
}

