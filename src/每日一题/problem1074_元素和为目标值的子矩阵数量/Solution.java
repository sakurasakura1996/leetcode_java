package 每日一题.problem1074_元素和为目标值的子矩阵数量;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] matSum = new int[m+1][n+1];
        matSum[1][1] = matrix[0][0];

        for (int i = 1; i < m + 1 ; i++) {
            matSum[i][1] = matSum[i-1][1] + matrix[i-1][0];
        }
        for (int i = 1; i < n+1 ; i++) {
            matSum[1][i] = matSum[1][i-1] + matrix[0][i-1];
        }
        for (int i = 2; i < m+1; i++) {
            for (int j = 2; j < n+1; j++) {
                matSum[i][j] = matSum[i][j-1] + matSum[i-1][j] - matSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        int ans = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = i; k < m + 1; k++) {
                    for (int l = j; l < n + 1; l++) {
                        int mat_sum = matSum[k][l] - matSum[k][j-1] - matSum[i-1][l] + matSum[i-1][j-1];
                        if (mat_sum == target){
                            ans += 1;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int subArraySum(int[] total, int k){
        int count=0, pre = 0;
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>(){{put(0, 1);}};
        for (int num :
                total) {
            pre += num;
            if (hashmap.containsKey(pre - k)){
                count += hashmap.get(pre-k);
            }
            hashmap.put(pre, hashmap.getOrDefault(pre, 0)+1);
        }
        return count;
    }

    public int numSubmatrixSumTarget2(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int[] total = new int[n];
            for (int j = i; j < m ; j++) {
                for (int k = 0; k < n; k++) {
                    total[k] += matrix[j][k];
                }
                ans += subArraySum(total, target);

            }
        }
        return ans;
    }


}
