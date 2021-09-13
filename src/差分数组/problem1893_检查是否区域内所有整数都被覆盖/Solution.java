package 差分数组.problem1893_检查是否区域内所有整数都被覆盖;

/* 这里考察的差分数组的含义就是， 生成差分数组以后，只要遍历差分数组 [left,right]区间内的差分数组和是否大于0即可 */
public class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] val = new int[52];
        for (int i = 0; i < ranges.length; i++) {
            range(val, ranges[i][0], ranges[i][1], 1);
        }
        int sum = 0;
        for (int i = 0; i < 51; i++) {
            sum += val[i];
            if (i >= left && i <= right && sum <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void range(int[] val, int left, int right, int value) {
        val[left] += value;
        val[right+1] -= value;
    }
}
