package 每日一题.problem231_2的幂;

public class Solution {
    public boolean isPowerOfTwo(int n){
        return n > 0 && (n & (-n)) == n;
    }
}
