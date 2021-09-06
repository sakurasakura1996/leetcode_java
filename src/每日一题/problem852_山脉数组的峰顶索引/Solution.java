package 每日一题.problem852_山脉数组的峰顶索引;

public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length-2;   // 因为两边取不到
        int ans = 0;
        while (left < right){
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                ans = mid;
                break;
            }else if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]){
                // 还在递增
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
