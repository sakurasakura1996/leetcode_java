package 差分数组.problem1094_拼车;

public class Solution {
    public boolean carPooling(int[][] trips, int cap) {
        int m = trips.length;
        int n = trips[0].length;
        int[] val = new int[1001];

        for (int i = 0; i < m; i++) {
            range(val, trips[i][1], trips[i][2], trips[i][0]);
        }
        int sum = 0;
        for (int i = 0; i < 1001; i++) {
            sum += val[i];
            if (sum > cap) {
                return false;
            }
        }
        return true;
    }

    public static void range(int[] val, int startLoc, int endLoc, int peopleNum) {
        val[startLoc] += peopleNum;
        val[endLoc] -= peopleNum;  // 这里并不需要 endLoc + 1
    }
}


