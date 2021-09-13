package 差分数组.problem1109_航班预订统计;

import java.util.Arrays;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int m = bookings.length;
        int[] val = new int[n+1];
        for (int i = 0; i < m; i++) {
            range(val, bookings[i][0], bookings[i][1], bookings[i][2]);
        }
        for (int i = 1; i < n; i++) {
            val[i] += val[i-1];
        }
        return Arrays.copyOfRange(val, 0, n+1);
    }

    public static void range(int[] val, int left, int right, int value) {
        val[left-1] += value;
        val[right] -= value;
    }
}
