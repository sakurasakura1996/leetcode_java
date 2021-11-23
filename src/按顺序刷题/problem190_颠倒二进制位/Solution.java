package 按顺序刷题.problem190_颠倒二进制位;

public class Solution {
    public int reverseBits(int n) {
       int ans = 0;
        for (int i = 0; i < 32 && n!=0; i++) {
            ans |= (n & 1) << (31 - i);
            n >>>=1;
        }
        return ans;
    }
}
