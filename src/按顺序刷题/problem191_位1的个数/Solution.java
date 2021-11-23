package 按顺序刷题.problem191_位1的个数;
// 位运算，妈的还是不太会
public class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {   // 每一位和 2的i次方相与，则可判断每一位是否是1
                ans ++;
            }
        }
        return ans;
    }
}
