package 每日一题.problem179_最大数;

import java.util.Arrays;

public class Solution {
    public String largestNumber(int[] nums){
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator对象，（这里为lambda表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x){     // 最好找个例子来带入看这个代码，就比较好理解啦。
                sx *= 10;
            }
            while (sy <= y){
                sy *= 10;
            }
            return (int)(-sy * x - y + sx * y + x);    //仔细体会这里如何直接比较 两个数字拼接起来的结果大小的。
        });
        if (numsArr[0] == 0){
            return "0";  //这里直接考虑到 [0,0]这种情况
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int num :
                numsArr) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
}
