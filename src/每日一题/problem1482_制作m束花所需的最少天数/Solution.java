package 每日一题.problem1482_制作m束花所需的最少天数;

import java.util.Arrays;

public class Solution {
    public int minDays(int[] bloomDay, int m, int k){
        int n = bloomDay.length;
        if (m * k > n) return -1;
        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();
        while (left < right){
            int mid = left + (right - left) / 2;
            if (check(mid, bloomDay, m, k)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int day, int[] bloomDay, int m, int k){
        // 测试第 day天能否满足条件
        int len = bloomDay.length;
        int flower = 0, cailiao = 0, cur = 0;
        while (cur < len) {
            if (bloomDay[cur] <= day){
                cailiao ++;
                if (cailiao == k){
                    flower ++;
                    cailiao = 0;
                }
            }else{
                cailiao = 0;
            }
            cur ++;
        }
        return flower >= m;
    }

}
