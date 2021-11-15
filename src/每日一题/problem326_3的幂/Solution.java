package 每日一题.problem326_3的幂;

public class Solution {
    public boolean isPowerOfThree(int n) {
        // 妈的，递归的终止条件都不写了是吧
        if (n == 3) {
            return true;
        }
        if (n % 3 == 0 && n != 0) {
            return isPowerOfThree(n/3);
        }
        return false;
    }
}
