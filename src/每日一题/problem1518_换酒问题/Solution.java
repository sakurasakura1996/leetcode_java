package 每日一题.problem1518_换酒问题;

/**
 * @author chenz
 * @ClassName Solution
 * @Description TODO
 * @date 2021/12/17-12:43
 */
public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while(numBottles >= numExchange) {
            ans += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return ans;
    }

    public static void main(String[] args) {
        int numBottles = 15, numExchange = 4;
        int i = new Solution().numWaterBottles(numBottles, numExchange);
        System.out.println(i);
    }
}
