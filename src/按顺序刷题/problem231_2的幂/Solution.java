package 按顺序刷题.problem231_2的幂;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        // easy to know: if n satisfy:  10000...  the answer is true, else is false.
        return n > 0 && (n & (n-1)) == 0;
    }
}
