package leetcode周赛.第274周赛;

/**
 * @author chenz
 * @ClassName Solution1
 * @Description 只需要检查 b后面是否有a
 * @date 2022/1/2-11:01
 */
public class Solution1 {
    public boolean checkString(String s) {
        int n  = s.length();
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return true;
        }
        for (int i = idx+1; i < n; i++) {
            if (s.charAt(i) == 'a') {
                return false;
            }

        }
        return true;
    }
}
