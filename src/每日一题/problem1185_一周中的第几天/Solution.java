package 每日一题.problem1185_一周中的第几天;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 需要注意的是，这里的年份最多是 2100年，2100年不是闰年，然后 1970年到2100年里，不会有整百的不是闰年。所以 代码中的除以4是正确的。
 * @date 2022/1/3-21:24
 */
public class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        for (int i = 0; i < month - 1; i++) {
            days += monthDays[i];
        }
        if ((year % 40 ==0 || (year % 4 ==0 && year % 100 != 0)) && month > 3) {
            days += 1;
        }
        days += day;
        return week[(days+3) % 7];
    }
}
