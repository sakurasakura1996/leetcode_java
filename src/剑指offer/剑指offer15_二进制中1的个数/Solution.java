package 剑指offer.剑指offer15_二进制中1的个数;

public class Solution {
    public int hammingWeight(int n){
        int ans = 0;
        while (n != 0){
            ans += n & 1;
            n >>>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int ans = solution.hammingWeight(n);
        System.out.println(ans);
    }
}
