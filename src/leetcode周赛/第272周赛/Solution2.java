package leetcode周赛.第272周赛;

/**
 * @author chenz
 * @ClassName Solution2
 * @Description TODO
 * @date 2021/12/19-10:42
 */
public class Solution2 {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (huiwen(s)) {
                return s;
            }
        }
        return "";
    }

    public boolean huiwen(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }


}
