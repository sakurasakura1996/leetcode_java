package 每日一题.problem412_Fizz_Buzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static final String BUZZ = "Buzz";
    public static final String FIZZ = "Fizz";
    public static final String FIZZBUZZ = "FizzBuzz";
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                ans.add(String.valueOf(i));
            } else if (i % 3 != 0 && i % 5 == 0) {
                ans.add(BUZZ);
            } else if (i % 3 == 0 && i % 5 != 0) {
                ans.add(FIZZ);
            } else {
                ans.add(FIZZBUZZ);
            }

        }
        return ans;
    }
}
