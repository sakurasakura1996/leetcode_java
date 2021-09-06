package 每日一题.problem342_4的幂;

public class Solution {
    public boolean isPowerOfFour(int n) {
        if (n < 1)
            return false;
        if (n == 1)
            return true;
        if (n > 1 && (n & -n) == n){
            while (n != 0){
                if (n == 1){
                    return true;
                }
                n = n >> 2;
            }
            return false;
        }
        return false;
    }
}
