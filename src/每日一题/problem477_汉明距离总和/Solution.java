package 每日一题.problem477_汉明距离总和;

public class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int num :
                    nums) {
                c += (num >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}
