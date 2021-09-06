package 每日一题.problem1442_形成两个异或相等数组的三元组数目;

public class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] preSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] ^ arr[i-1];
        }
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int triplet_left = preSum[j] ^ preSum[i];
                    int triplet_right = preSum[k+1] ^ preSum[j];
                    if (triplet_left == triplet_right){
                        ans ++;
                    }

                }
            }
        }
        return ans;
    }

    public int countTriplets2(int[] arr){
        // 其实j并没有什么卵用
        int n = arr.length;
        int[] preSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i+1; k < n ; k++) {
                if (preSum[i] == preSum[k+1]){
                    ans += (k - i);
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7,11,12,9,5,2,7,17,22};
        int ans = new Solution().countTriplets(arr);
        System.out.println(ans);
    }
}
