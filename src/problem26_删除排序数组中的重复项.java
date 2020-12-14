/**
 * @ClassName problem26_删除排序数组中的重复项
 * @Date 2020/9/28 16:49
 * @Created by sakura
 **/

class Solution2{
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0;
        int common = 0;
        for (int right = 0; right < n; right++) {
            if (nums[left] < nums[right]) {
                left++;
                nums[left] = nums[right];
            } else {
                common++;
                continue;
            }


        }
        return n - common + 1;
    }
}
public class problem26_删除排序数组中的重复项 {


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int ans = solution2.removeDuplicates(nums);
        System.out.println(ans);

    }


}

