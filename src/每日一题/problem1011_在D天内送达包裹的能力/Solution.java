package 每日一题.problem1011_在D天内送达包裹的能力;

public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int n = weights.length;
        int left = 0;
        int right = 0;
        for (int weight :
                weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right){
            int mid = left + (right - left) / 2;
            int weight_sum = 0;
            int days = 1;
            for (int weight :
                    weights) {
                if (weight_sum + weight <= mid){
                    weight_sum += weight;
                }else{
                    days += 1;
                    weight_sum = weight;
                }
            }
            if (days <= D){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
