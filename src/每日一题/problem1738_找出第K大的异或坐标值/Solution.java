package 每日一题.problem1738_找出第K大的异或坐标值;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int kthLargestValue(int[][] matrix, int k){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pre = new int[m+1][n+1];
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n + 1; j++) {
                pre[i][j] = pre[i-1][j] ^ pre[i][j-1] ^ pre[i-1][j-1] ^ matrix[i-1][j-1];
                ans.add(pre[i][j]);
            }
        }
        Collections.sort(ans, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        return ans.get(k-1);
    }
}
