package 每日一题.problem1486_数组异或操作;

public class Solution {
    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            ans ^= (start + 2 * i);
        }
        return ans;

    }
}
