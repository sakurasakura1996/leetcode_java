package leetcode周赛.第240场周赛;

public class 人口最多的年份 {
    public int maximumPopulation(int[][] logs) {
        int[] numbers = new int[101];
        int m = logs.length;
        for (int i = 0; i < m; i++) {
            for (int j = logs[i][0]; j < logs[i][1] ; j++) {
                numbers[j-1950] ++;
            }
        }
        int max = 0;
        int ans = 0;
        for (int i = 0; i < 101; i++) {
            if (numbers[i] > max){
                max = numbers[i];
                ans = i;
            }
        }
        return ans + 1950;
    }
}
