package 每日一题.剑指offerII069_山峰数组的顶部;
/* arr.length >= 3
* 然后山峰数组是最高的，严格最高的，O(n)时间复杂度很好想，那么O(logN)怎么来实现呢 */
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int ans = -1;
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        // 使用O(logN)复杂度来解决问题, 其实也比较好想，这里题目说保证又山峰数组，结合期望的时间复杂度，那么基本上是二分法来做了
        int len = arr.length;
        int ans = -1;
        int left = 0, right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 因为 arr.length >= 3,所以不用考虑mid的边界问题
            // 另外这里的判断条件不需要写的这么复杂。arr[mid]和arr[mid+1]对比就可以了
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                ans = mid;
                break;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                right = mid;
            }
        }
        return ans;
    }
}
