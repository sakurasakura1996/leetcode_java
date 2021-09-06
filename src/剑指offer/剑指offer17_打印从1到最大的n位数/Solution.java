package 剑指offer.剑指offer17_打印从1到最大的n位数;

public class Solution {
    public int[] printNumbers(int n){
        int upper = (int)Math.pow(10, n) - 1;
//        System.out.println("upper:"+upper);
        int[] ans = new int[upper];
        for (int i = 0; i < upper; i++) {
            ans[i] = i+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.printNumbers(1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);

        }
    }
}
