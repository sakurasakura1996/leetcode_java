package 每日一题.problem1720_解码异或后的数组;

public class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int [] ans = new int[n+1];
        ans[0] = first;
        for (int i = 0; i < n; i++) {
            int temp = first ^ encoded[i];
            ans[i+1] = temp;
            first = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] encoded = {6, 2, 7, 3};
        int first = 4;
        int [] ans = solution.decode(encoded, first);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
