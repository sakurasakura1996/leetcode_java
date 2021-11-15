package 按顺序刷题.problem283_移动零;

public class Solution {
    public void moveZeroes(int[] nums) {
        // 先不急着把0放到后面，我们主要把非0移动前面，然后后面就全部填0就行了。
        int cur = 0, next = 0;
        while (next < nums.length) {
            // 我们应该关注 next
            if (nums[next] != 0) {
                int temp = nums[cur];
                nums[cur] = nums[next];
                nums[next] = temp;
                cur ++;
            }
            next ++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        new Solution().moveZeroes(nums);
        for (int i :
                nums) {
            System.out.println(i);
        }
    }
}
