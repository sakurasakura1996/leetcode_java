package 每日一题.problem1154_一年中的第几天;

/**
 * @author chenz
 * @ClassName Solution
 * @Description TODO
 * @date 2021/12/21-10:25
 */
public class Solution {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            days[1]++;
        }
        int ans = 0;
        for (int i = 0; i < month - 1; i++) {
            ans += days[i];
        }
        return ans + day;
        }
}
