package JianZhiOffer.剑指offer53_I_在排序数组中查找数字I;

public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        for (Integer num : nums) {
            if (num == target) {
                ans ++;
            }
        }
        return ans;
    }

    /* 注意看题目，不然这题目不应该出现，数组是排序数组，所以用二分法吧
    * 二分法的话我们可以把题目改成搜索一个可能有重复数字的左右边界，这个难度可能会大一点
    * 那么其实也可以改成，我们只要找到一个这样的数字，就在这个位置向两边搜索，但是这个时间复杂度高一些*/

//    public int search2(int[] nums, int target) {
//        int n = nums.length;
//        int leftBoundary = 0, rightBoundary = n-1;
//        // 1.二分查找找到该数字的左边界
//
//
//        // 2.二分查找找到该数字的有边界
//
//        // 3.直接相减得到出现次数
//
//    }
}
