package 按顺序刷题.problem977_有序数组的平方;
// 如果不管空间复杂度，直接遍历一遍，已经部分有序了，O(n)可以直接排序出来
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] a = new int[nums.length];
        int pos = 0;
        for (int i = 0; i < nums.length-1; i++) {
            // 双指针，找到绝对值最小的元素下表
            if (Math.abs(nums[i]) >= Math.abs(nums[i+1])){
                pos = i+1;
            }else{
                break;
            }
        }
        int left = pos, right = pos+1, cur = 0;
        while (left >= 0 && right <= nums.length-1){
            if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                a[cur] = nums[left] * nums[left];
                cur++;
                left--;
            } else {
                a[cur] = nums[right] * nums[right];
                cur++;
                right++;
            }
        }
        if (left<0){
            for (int i = right; i <nums.length ; i++) {
                a[cur] = nums[i] * nums[i];
                cur++;
            }
        }else{
            for (int i = left; i >=0 ; i--) {
                a[cur]=nums[i] * nums[i];
                cur++;
            }
        }
        return a;
    }

    // 卧槽，看完题解，发现了一个更好的双指针啊，尼玛为啥要找到边界呢，我们可以从两边往中间啊，先找最大的
    public int[] sortedSquares2(int[] nums) {
        int left = 0, right = nums.length-1;
        int[] ans = new int[nums.length];
        int cur = nums.length-1;
        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])){
                ans[cur] = nums[left] * nums[left];
                left++;
            }else{
                ans[cur] = nums[right] * nums[right];
                right--;
            }
            cur++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,2};
        int[] ints = new Solution().sortedSquares(nums);
        for (int i :
                ints) {
            System.out.println(i);
        }
    }
}
