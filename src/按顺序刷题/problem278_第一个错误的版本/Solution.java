package 按顺序刷题.problem278_第一个错误的版本;

public class Solution {
    public boolean isBadVersion(int version) {return false;}
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
