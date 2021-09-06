package 每日一题.problem633_平方数之和;

public class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c/2);
        for (int i = 0; i <= right; i++) {
            int cur = c - i * i;
            if (Math.sqrt(cur) == (int)Math.sqrt(cur)){
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c){
        // 双指针方法
        int left = 0;
        int right = (int)Math.sqrt(c);
        while (left <= right){
            int sum = left * left + right * right;
            if (sum == c){
                return true;
            }
            else if (sum < c){
                left += 1;
            }
            else{
                right -= 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int c = 1;
        boolean ans = solution.judgeSquareSum2(c);
        System.out.println(ans);
    }
}
